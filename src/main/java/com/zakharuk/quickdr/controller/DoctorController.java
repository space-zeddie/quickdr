package com.zakharuk.quickdr.controller;

import com.zakharuk.quickdr.entity.Doctor;
import com.zakharuk.quickdr.entity.Procedure;
import com.zakharuk.quickdr.entity.Therapist;
import com.zakharuk.quickdr.service.DoctorPatientService;
import com.zakharuk.quickdr.service.DoctorService;
import com.zakharuk.quickdr.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.print.Doc;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by matvii on 13.04.17.
 */
@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorPatientService doctorPatientService;

    private SimpleDateFormat formatter = new SimpleDateFormat("HH-mm");

    /**
     * GET /create  --> Create a new procedure and save it in the database.
     */
    @RequestMapping("/create-doctor")
    @ResponseBody
    public String create(String name, int office, String whour1, String whour2) {
        String id = "";
        Doctor doctor = null;
        try {
            doctor = new Therapist();
            doctor.setName(name);
            doctor.setOffice(office);
            doctor.setWorkingHour1(formatter.parse(whour1));
            doctor.setWorkingHour2(formatter.parse(whour2));
            doctorService.add(doctor);
            id = String.valueOf(doctor.getId());
        }
        catch (Exception ex) {
            return Constants.HEADER +  "Error registering the doctor: " + doctor.toString() + Constants.FOOTER;
        }
        return Constants.HEADER + "Doctor succesfully registered " + doctor + Constants.FOOTER;
    }

    /**
     * GET /delete  --> Delete the doctor having the passed id.
     */
    @RequestMapping("/delete-doctor")
    @ResponseBody
    public String delete(int id) {
        try {
            Doctor doctor = new Therapist();
            doctor.setId(id);
            doctorService.remove(doctor);
            doctorPatientService.removeByDoctor(id);
        }
        catch (Exception ex) {
            return Constants.HEADER + "Error deleting the doctor:" + ex.toString() + Constants.FOOTER;
        }
        return Constants.HEADER + "Doctor succesfully deleted!" + Constants.FOOTER;
    }

    /**
     * GET /update  --> Update the name and the age for the subject in the
     * database having the passed id.
     */
    @RequestMapping("/update-doctor")
    @ResponseBody
    public String update(int id, String name, int office, String whour1, String whour2) {
        Doctor doctor = null;
        try {
            doctor = doctorService.getDoctorById(id);
            doctor.setName(name);
            doctor.setOffice(office);
            doctor.setWorkingHour1(formatter.parse(whour1));
            doctor.setWorkingHour2(formatter.parse(whour2));
            doctorService.update(doctor);
        }
        catch (Exception ex) {
            return Constants.HEADER + "Error updating the doctor: " + doctor.toString() + Constants.FOOTER;
        }
        return Constants.HEADER + "Doctor succesfully updated!" + Constants.FOOTER;
    }

    @RequestMapping("/edit-doctor")
    @ResponseBody
    public String editDoctor(int id) {
        StringBuilder res = new StringBuilder();
        res.append(Constants.HEADER);
        Doctor doctor = doctorService.getDoctorById(id);
        res.append("<div class=\"jumbotron\">");
        res.append("<div>");
        res.append("Name <input type=\"text\" id=\"name\" name=\"name\" value=\""
                + doctor.getName() +"\" /><br />");
        res.append("Office <input type=\"text\" id=\"office\" name=\"office\" value=\""
                + doctor.getOffice() +"\" /><br />");
        res.append("Starts working at <input type=\"text\" id=\"whour1\" name=\"whour1\" value=\""
                + doctor.getWorkingHour1() +"\" /><br />");
        res.append("Finishes work at <input type=\"text\" id=\"whour2\" name=\"whour2\" value=\""
                + doctor.getWorkingHour2() +"\" /><br />");
        res.append("<a id=\"" + doctor.getId() + "\" href=\"/\" class = \"btn btn-info lnk_edit_doc\">Update</a>");
        res.append(Constants.FOOTER);
        return res.toString();
    }

}
