package com.zakharuk.quickdr.controller;

import com.zakharuk.quickdr.entity.ChildPatient;
import com.zakharuk.quickdr.entity.Patient;
import com.zakharuk.quickdr.service.DoctorPatientService;
import com.zakharuk.quickdr.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.Path;
import java.util.List;

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
    @RequestMapping(value="/register-patient", method = RequestMethod.POST)
    @ResponseBody
    public Patient create(@PathVariable  String name, @PathVariable int age, @PathVariable String diagnosis) {
        Patient patient = null;
        try {
            patient = new ChildPatient(name, age);
            patient.setDiagnosis(diagnosis);
            System.err.println("hello");
            patientService.addPatient(patient);
        }
        catch (Exception ex) {
            //return Constants.HEADER +  "Error registering the partient: " + patient + Constants.FOOTER;
            return null;
        }
        //return Constants.HEADER + "Patient succesfully registered with " + patient + Constants.FOOTER;
        return patient;
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
    @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Patient> getUser(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        Patient patient = patientService.getPatientById(id);
        if (patient == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Patient>(patient, HttpStatus.OK);
    }
   /* @RequestMapping(value="/get-patient", method = RequestMethod.GET)
    @ResponseBody
    public Patient getById(int id) {
        Patient patient;
        try {
            patient = patientService.getPatientById(id);
        }
        catch (Exception ex) {
            return null;
        }
        return patient;
    }*/

    /**
     * GET /update  --> Update the name and the age for the subject in the
     * database having the passed id.
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updateSubject(int id, String name, int age, String diagnosis) {
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
   /* @RequestMapping("/set-prof")
    @ResponseBody
    public String setProf(long id, String prof) {
        try {
            Subject subject = subjectDao.findOne(id);
            subject.setProf(prof);
            subjectDao.save(subject);
        }
        catch (Exception ex) {
            return HEADER + "Error updating the subject: " + ex.toString() + FOOTER;
        }
        return HEADER + "Subject succesfully updated!" + FOOTER;
    }*/

    /*@RequestMapping("/recommend")
    @ResponseBody
    public String recommend(long id, boolean rec) {
        try {
            Subject subject = subjectDao.findOne(id);
            subject.setRecommended(rec);
            subjectDao.save(subject);
        }
        catch (Exception ex) {
            return HEADER + "Error updating the subject: " + ex.toString() + FOOTER;
        }
        return HEADER + "Subject succesfully updated!" + FOOTER;
    }*/



   /* @RequestMapping("/all-patients")
    @ResponseBody
    public String findAll() {
        StringBuilder res = new StringBuilder();
        res.append(HEADER);
        try {
            Iterable<Subject> all = subjectDao.findAll();
            res = listSubjects(all, res);
        }
        catch (Exception ex) {
            res.append("Error retrieving the subjects: " + ex.toString());
        }
        finally {
            res.append(FOOTER);
            return res.toString();
        }
    }*/

    /*@RequestMapping("/all-recommended")
    @ResponseBody
    public String findAllRecommended() {
        StringBuilder res = new StringBuilder();
        res.append(HEADER);
        try {
            List<Subject> all = new ArrayList<Subject>();
            for (Subject s : subjectDao.findAll())
                if (s.isRecommended()) all.add(s);
            res = listSubjects(all, res);
        }
        catch (Exception ex) {
            res.append("Error retrieving the subjects: " + ex.toString());
        }
        finally {
            res.append(FOOTER);
            return res.toString();
        }
    }*/

    /*private StringBuilder listSubjects(Iterable<Subject> is, StringBuilder res) {
        for (Subject s : is) {
            res.append("<div>");
            res.append(s.toString());
            res.append("<br>");
            res.append(listStudentsBtn(s.getId()));
            if (SecurityConfiguration.isStudent() && s.isRecommended() && ZakharukApplication.isSecondStage())
                res.append(signUpBtn(s.getId()));
            if (SecurityConfiguration.isMethodist() && ZakharukApplication.isFirstStage()) {
                if (!s.isRecommended())
                    res.append(recommendBtn(s.getId()));
                else
                    res.append(unrecommendBtn(s.getId()));
            }
            if (SecurityConfiguration.isMethodist() && ZakharukApplication.isFirstStage() || SecurityConfiguration.isAdmin())
                res.append(updateProfBtn(s.getId()));
            if (SecurityConfiguration.isAdmin())
                res.append(editSubjectBtn(s.getId()));
            if (SecurityConfiguration.isAdmin())
                res.append(deleteSubjectBtn(s.getId()));
            res.append("</div>");
            res.append("<br>");
        }
        return res;
    }*/

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
        res.append("Age <input type=\"text\" id=\"credits\" name=\"credits\" th:text=\"${credits}\" value=\""
                + patient.getAge() +"\" /><br />");
        res.append("Diagnosis <input type=\"text\" id=\"annotation\" name=\"annotation\" th:text=\"${annotation}\" value=\""
                + patient.getDiagnosis() +"\" /><br />");
        res.append("<a id=\"" + patient.getPatientId() + "\" href=\"/\" class = \"btn btn-info lnk_edit\">Update</a>");
        res.append(Constants.FOOTER);
        return res.toString();
    }

   /* @RequestMapping("/list-students")
    @ResponseBody
    public String listStudents(long id) {
        StringBuilder res = new StringBuilder();
        res.append(HEADER);
        try {
            Subject s = subjectDao.findOne(id);
            for (User u : s.getStudents()) {
                res.append(u.toString());
                res.append("<br>");
                if (SecurityConfiguration.isStudent() &&
                        (u.getId() == userDao.findByName(SecurityConfiguration.findAuth().getName()).getId()))
                    res.append(removeStudentBtn(s.getId(), u.getId()));
                res.append("<br>");
            }
        }
        catch (Exception ex) {
            res.append("Error retrieving the students: " + ex.toString());
        }
        finally {
            res.append(FOOTER);
            return res.toString();
        }
    }*/


    /*@RequestMapping("/add-user")
    @ResponseBody
    @Transactional
    public String addUser(Long subjectid, Long userid) {
        try {
            Subject subject = subjectDao.findOne(subjectid);
            User user = userDao.findOne(userid);
            if (!subject.getStudents().contains(user)) {
                subject.getStudents().add(user);
                user.getSubjects().add(subject);
                subjectRepository.save(new HashSet<Subject>(){{
                    add(subject);
                }});
                userRepository.save(new HashSet<User>(){{
                    add(user);
                }});
            }
        }
        catch (Exception ex) {
            return HEADER + "Error adding the user: " + ex.toString() + FOOTER;
        }
        return HEADER + "User succesfully added!" + FOOTER;
    }

    @RequestMapping("/remove-user")
    @ResponseBody
    public String removeUser(Long subjectid, Long userid) {
        try {
            Subject subject = subjectDao.findOne(subjectid);
            User user = userDao.findOne(userid);
            if (subject.getStudents().contains(user)) {
                user.getSubjects().remove(subject);
                subject.getStudents().remove(user);
                subjectRepository.save(new HashSet<Subject>(){{
                    add(subject);
                }});
                userRepository.save(new HashSet<User>(){{
                    add(user);
                }});
            }
        }
        catch (Exception ex) {
            return "Error removing the user: " + ex.toString();
        }
        return "User succesfully removed!";
    }*/

    /*@RequestMapping("/select-add-student")
    @ResponseBody
    public String selectStudent(Long subjectid) {
        StringBuilder res = new StringBuilder();
        res.append(HEADER);
        Subject subject = subjectDao.findOne(subjectid);
        //Iterable<User> users = userDao.findAll();
        //for (User u : users)
        User u = userDao.findByName(SecurityConfiguration.findAuth().getName());
        res.append("<p>You currently have " + u.getAllCredits() + " credits. Are you sure you want to sign up?</p>");
        res.append(addStudentBtn(subjectid, u.getId()));
        res.append(FOOTER);
        return res.toString();
    }*/

}
