package com.zakharuk.quickdr.controller;

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
        Patient patient = null;
        Doctor doctor = null;
        try {
            doctor = doctorService.getDoctorById(doctorId);
            patient = patientService.getPatientById(patientId);
            doctor.examine((ChildPatient) patient);
            if (!doctorPatientService.getDoctorsPatients(doctorId).contains(patient))
                doctorPatientService.assignPatientToDoctor(doctorId, patientId);
        }
        catch (Exception ex) {
            return Constants.HEADER + "Error assigning the patient: " + patient.toString() + " to " + doctor.toString()
                    + Constants.FOOTER;
        }
        return Constants.HEADER + "Patient succesfully assigned!" + Constants.FOOTER;
    }

    @RequestMapping("/sign-out-patient")
    @ResponseBody
    public String deleteByPatient(int patientId) {
        Patient patient = null;
        try {
            patient = patientService.getPatientById(patientId);
            if (doctorPatientService.getPatientsDoctors(patientId).size() > 0)
                doctorPatientService.removeByPatient(patientId);
        }
        catch (Exception ex) {
            return Constants.HEADER + "Error signing out the patient: " + patient.toString() + Constants.FOOTER;
        }
        return Constants.HEADER + "Patient succesfully signed out!" + Constants.FOOTER;
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
                resp.append("<div class='jumbotron'>");
                resp.append(patientDisplayDoctorsPatients(p));
                resp.append("</div>");
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
                resp.append(patientDisplayUnattendedPatients(p));
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

    @RequestMapping("/booked-doctors")
    @ResponseBody
    public String listBookedDoctors() {
        StringBuilder resp = new StringBuilder();
        resp.append(Constants.HEADER);
        try {
            List<Doctor> doctorList = doctorPatientService.getBookedDoctors();
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


    @RequestMapping("/patients-one-doctor")
    @ResponseBody
    public String listPatientsWithOnlyOneDoctor(int doctorId) {
        StringBuilder resp = new StringBuilder();
        resp.append(Constants.HEADER);
        try {
            List<Patient> patientList = doctorPatientService.getPatientsWithOneDoctor(doctorId);
            for (Patient p : patientList) {
                resp.append("<div class='jumbotron'>");
                resp.append(patientDisplayDoctorsPatients(p));
                resp.append("</div>");
            }
        }
        catch (Exception ex) {
            return Constants.HEADER + "Error listing the patients: " + ex.toString() + Constants.FOOTER;
        }
        return resp.toString() + Constants.FOOTER;
    }

    private String patientDisplayDoctorsPatients(Patient patient) {
        StringBuilder resp = new StringBuilder();
        resp.append(patient.toString());
        resp.append("</br>");
        resp.append(Constants.editPatientBtn(patient.getPatientId()));
       // resp.append("</br>");
        resp.append(Constants.signOutPatientBtn(patient.getPatientId()));
        return resp.toString();
    }

    private String patientDisplayUnattendedPatients(Patient patient) {
        StringBuilder resp = new StringBuilder();
        resp.append(patient.toString());
        resp.append("</br>");
        resp.append(Constants.editPatientBtn(patient.getPatientId()));
        // resp.append("</br>");
        resp.append(Constants.assignPatientBtn(patient.getPatientId(), 1));
        return resp.toString();
    }




}
