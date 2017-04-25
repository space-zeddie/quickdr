package com.zakharuk.quickdr.controller;

import com.zakharuk.quickdr.entity.ChildPatient;
import com.zakharuk.quickdr.entity.Patient;
import com.zakharuk.quickdr.service.DoctorPatientService;
import com.zakharuk.quickdr.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by matvii on 12.04.17.
 */
@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorPatientService doctorPatientService;

    /**
     * GET /create  --> Create a new patient and save it in the database.
     */
    @RequestMapping("/register-patient")
    @ResponseBody
    public String create(String name, int age, String diagnosis) {
        String patientId = "";
        Patient patient = null;
        try {
            patient = new ChildPatient(name, age);
            patient.setDiagnosis(diagnosis);
            patientService.addPatient(patient);
            patientId = String.valueOf(patient.getPatientId());
        }
        catch (Exception ex) {
            return Constants.HEADER +  "Error registering the partient: " + patient + Constants.FOOTER;
        }
        return Constants.HEADER + "Patient succesfully registered with " + patient + Constants.FOOTER;
    }

    /**
     * GET /delete  --> Delete the patient having the passed id.
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(int id) {
        try {
            Patient patient = new ChildPatient();
            patient.setPatientId(id);
            patientService.remove(patient);
            doctorPatientService.removeByPatient(id);
        }
        catch (Exception ex) {
            return Constants.HEADER + "Error deleting the patient:" + ex.toString() + Constants.FOOTER;
        }
        return Constants.HEADER + "Patient succesfully deleted!" + Constants.FOOTER;
    }

    /**
     * GET /get-by-name  --> Return the id for the patient having the passed
     * name.
     */
    @RequestMapping("/get-patient-by-name")
    @ResponseBody
    public String getByName(String name) {
        String patientId = "";
        try {
            Patient patient = patientService.findByName(name);
            patientId = String.valueOf(patient.getPatientId());
        }
        catch (Exception ex) {
            return Constants.HEADER + "Patient not found" + Constants.FOOTER;
        }
        return Constants.HEADER + "The patient id is: " + patientId + Constants.FOOTER;
    }

    /**
     * GET /update  --> Update the name and the age for the subject in the
     * database having the passed id.
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updatePatient(int id, String name, int age, String diagnosis) {
        Patient patient = null;
        try {
            patient = patientService.getPatientById(id);
            patient.setName(name);
            patient.setAge(age);
            patient.setDiagnosis(diagnosis);
            patientService.savePatient(patient);
        }
        catch (Exception ex) {
            return Constants.HEADER + "Error updating the patient: " + patient.toString() + Constants.FOOTER;
        }
        return Constants.HEADER + "Patient succesfully updated!" + Constants.FOOTER;
    }

    /**
     * GET /update  --> Update the name and the credits for the subject in the
     * database having the passed id.
     */
    @RequestMapping("/edit-patient")
    @ResponseBody
    public String editPatient(int id) {
        StringBuilder res = new StringBuilder();
        res.append(Constants.HEADER);
        Patient patient = patientService.getPatientById(id);
        res.append("<div class=\"jumbotron\">");
        res.append("<div>");
        res.append("Name <input type=\"text\" id=\"name\" name=\"name\" th:text=\"${name}\" value=\""
                + patient.getName() +"\" /><br />");
        res.append("Age <input type=\"text\" id=\"age\" name=\"age\" th:text=\"${age}\" value=\""
                + patient.getAge() +"\" /><br />");
        res.append("Diagnosis <input type=\"text\" id=\"diagnosis\" name=\"diagnosis\" th:text=\"${diagnosis}\" value=\""
                + patient.getDiagnosis() +"\" /><br />");
        res.append("<a id=\"" + patient.getPatientId() + "\" href=\"/\" class = \"btn btn-info lnk_edit\">Update</a>");
        res.append(Constants.FOOTER);
        return res.toString();
    }

    @RequestMapping("/add-patient")
    @ResponseBody
    public String registerDoctor() {
        StringBuilder res = new StringBuilder();
        res.append(Constants.HEADER);
        res.append("<div class=\"jumbotron\">\n" +
                "        <div>\n" +
                "            Name <input type=\"text\" id=\"name\" name=\"name\"  /><br />\n" +
                "            Age <input type=\"text\" id=\"age\" name=\"age\" /><br />\n" +
                "            Diagnosis <input type=\"text\" id=\"diagnosis\" name=\"diagnosis\"/><br />\n" +
                "            <a id=\"link\" href=\"/\" class = \"btn btn-info regist_patient\">Register</a>\n" +
                "        </div>\n" +
                "    </div>");
        res.append(Constants.FOOTER);
        return res.toString();
    }

}
