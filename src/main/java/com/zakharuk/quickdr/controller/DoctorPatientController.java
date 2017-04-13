package com.zakharuk.quickdr.controller;

import com.zakharuk.quickdr.dao.DoctorPatientDao;
import com.zakharuk.quickdr.entity.ChildPatient;
import com.zakharuk.quickdr.entity.Doctor;
import com.zakharuk.quickdr.entity.Patient;
import com.zakharuk.quickdr.service.DoctorPatientService;
import com.zakharuk.quickdr.service.DoctorService;
import com.zakharuk.quickdr.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.print.Doc;
import java.util.List;

/**
 * Created by matvii on 13.04.17.
 */
@Controller
public class DoctorPatientController {

    @Autowired
    private DoctorPatientService doctorPatientService;

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;

    /**
     * GET /assign-patient  --> Assign a patient to a doctor by id
     */
    @RequestMapping("/assign-patient")
    @ResponseBody
    public String update(int patientId, int doctorId) {
        try {
            Doctor doctor = doctorService.getDoctorById(doctorId);
            Patient patient = patientService.getPatientById(patientId);
            doctor.examine((ChildPatient) patient);
            if (!doctorPatientService.getDoctorsPatients(doctorId).contains(patient))
                doctorPatientService.assignPatientToDoctor(doctorId, patientId);
        }
        catch (Exception ex) {
            return Constants.HEADER + "Error assigning the patient: " + ex.toString() + Constants.FOOTER;
        }
        return Constants.HEADER + "Patient succesfully assigned!" + Constants.FOOTER;
    }

    /**
     * GET /doctors-patients  --> List all patients of a doctor
     */
    @RequestMapping("/doctors-patients")
    @ResponseBody
    public String listPatients(int doctorId) {
        StringBuilder resp = new StringBuilder();
        resp.append(Constants.HEADER);
        try {
            List<Patient> patientList = doctorPatientService.getDoctorsPatients(doctorId);
            for (Patient p : patientList) {
                resp.append("<p>");
                resp.append(p);
                resp.append("</p>");
            }
        }
        catch (Exception ex) {
            return Constants.HEADER + "Error listing the patients: " + ex.toString() + Constants.FOOTER;
        }
        return resp.toString() + Constants.FOOTER;
    }

    @RequestMapping("/unattended-patients")
    @ResponseBody
    public String listUnattendedPatients() {
        StringBuilder resp = new StringBuilder();
        resp.append(Constants.HEADER);
        try {
            List<Patient> patientList = doctorPatientService.getUnattendedPatients();
            for (Patient p : patientList) {
                resp.append("<p>");
                resp.append(p);
                resp.append("</p>");
            }
        }
        catch (Exception ex) {
            return Constants.HEADER + "Error listing the patients: " + ex.toString() + Constants.FOOTER;
        }
        return resp.toString() + Constants.FOOTER;
    }

    /**
     * GET /patients-doctors  --> List all doctors of a patient
     */
    @RequestMapping("/patients-doctors")
    @ResponseBody
    public String listDoctors(int patientId) {
        StringBuilder resp = new StringBuilder();
        resp.append(Constants.HEADER);
        try {
            List<Doctor> doctorList = doctorPatientService.getPatientsDoctors(patientId);
            for (Doctor p : doctorList) {
                resp.append("<p>");
                resp.append(p);
                resp.append("</p>");
            }
        }
        catch (Exception ex) {
            return Constants.HEADER + "Error listing the doctors: " + ex.toString() + Constants.FOOTER;
        }
        return resp.toString() + Constants.FOOTER;
    }

    @RequestMapping("/available-doctors")
    @ResponseBody
    public String listAvailableDoctors() {
        StringBuilder resp = new StringBuilder();
        resp.append(Constants.HEADER);
        try {
            List<Doctor> doctorList = doctorPatientService.getAvailableDoctors();
            for (Doctor p : doctorList) {
                resp.append("<p>");
                resp.append(p);
                resp.append("</p>");
            }
        }
        catch (Exception ex) {
            return Constants.HEADER + "Error listing the doctors: " + ex.toString() + Constants.FOOTER;
        }
        return resp.toString() + Constants.FOOTER;
    }



}
