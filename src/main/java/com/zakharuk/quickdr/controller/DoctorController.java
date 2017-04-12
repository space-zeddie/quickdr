package com.zakharuk.quickdr.controller;

import com.zakharuk.quickdr.entity.Doctor;
import com.zakharuk.quickdr.entity.Procedure;
import com.zakharuk.quickdr.entity.Therapist;
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

    private SimpleDateFormat formatter = new SimpleDateFormat("HH-mm");

    /**
     * GET /create  --> Create a new procedure and save it in the database.
     */
    @RequestMapping("/create-doctor")
    @ResponseBody
    public String create(String name, int office, String whour1, String whour2) {
        String id = "";
        try {
            Doctor doctor = new Therapist();
            doctor.setName(name);
            doctor.setOffice(office);
            doctor.setWorkingHour1(formatter.parse(whour1));
            doctor.setWorkingHour2(formatter.parse(whour2));
            doctorService.add(doctor);
            id = String.valueOf(doctor.getId());
        }
        catch (Exception ex) {
            return HEADER +  "Error registering the doctor: " + ex.toString() + FOOTER;
        }
        return HEADER + "Doctor succesfully registered with id = " + id + FOOTER;
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
        }
        catch (Exception ex) {
            return HEADER + "Error deleting the doctor:" + ex.toString() + FOOTER;
        }
        return HEADER + "Doctor succesfully deleted!" + FOOTER;
    }

    /**
     * GET /update  --> Update the name and the age for the subject in the
     * database having the passed id.
     */
    @RequestMapping("/update-doctor")
    @ResponseBody
    public String update(int id, String name, int office, String whour1, String whour2) {
        try {
            Doctor doctor = doctorService.getDoctorById(id);
            doctor.setName(name);
            doctor.setOffice(office);
            doctor.setWorkingHour1(formatter.parse(whour1));
            doctor.setWorkingHour2(formatter.parse(whour2));
            doctorService.update(doctor);
        }
        catch (Exception ex) {
            return HEADER + "Error updating the doctor: " + ex.toString() + FOOTER;
        }
        return HEADER + "Doctor succesfully updated!" + FOOTER;
    }

    private String signUpBtn(long id) {
        return "<a href=\"/select-add-student?subjectid=" + id + "\" class=\"btn btn-info\">Sign Up</a>";
    }

    private String listStudentsBtn(long id) {

        return "<a href=\"/list-students?id=" + id + "\" class=\"btn btn-info\">View Students</a>";
    }
    private String deleteSubjectBtn(long id) {

        return "<a href=\"/delete?id=" + id + "\" class=\"btn btn-info\">Delete Subject</a>";
    }
    private String editSubjectBtn(long id) {

        return "<a href=\"/edit-subject?id=" + id + "\" class=\"btn btn-info\">Edit Subject</a>";
    }


    private String recommendBtn(long id) {

        return "<a href=\"/recommend?id=" + id + "&rec=true" + "\" class=\"btn btn-info\">Recommend</a>";
    }

    private String unrecommendBtn(long id) {

        return "<a href=\"/recommend?id=" + id + "&rec=false" + "\" class=\"btn btn-info\">Unrecommend</a>";
    }

    private String updateProfBtn(long id) {

        return "<a href=\"/?id=" + id  + "\" class=\"btn btn-info updateProf\" id=\""+ id +"\">Change Professor</a>";
    }




    private String addStudentBtn(long id, long studentId) {

        return "<a href=\"/add-user?subjectid=" + id + "&userid=" + studentId + "\" class=\"btn btn-info\">Sign Up </a>";
    }
    private String setProfBtn(long id, long prof) {

        return "<a href=\"/set-profr?id=" + id + "&prof=" + prof + "\" class=\"btn btn-info\">Change Professor</a>";
    }
    private String removeStudentBtn(long id, long studentId) {

        return "<a href=\"/remove-user?subjectid=" + id + "&userid=" + studentId + "\" class=\"btn btn-info\">Sign Off </a>";
    }

    protected static String HEADER = "<!DOCTYPE html>\n" +
            "<html xmlns:th=\"http://www.thymeleaf.org\">\n" +
            "<head lang=\"en\">\n" +
            "\n" +
            "    <title>Subjects</title>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n" +
            "    <link href=\"css/bootstrap.min.css\"\n" +
            "          th:href=\"@{css/bootstrap.min.css}\"\n" +
            "          rel=\"stylesheet\" media=\"screen\" />\n" +
            "    <script src=\"css/js/jq.js\"\n" +
            "            th:src=\"@{css/js/jq.js}\"></script>\n" +
            "    <script src=\"css/js/bootstrap.js\"\n" +
            "            th:src=\"@{css/js/bootstrap.js}\"></script>\n" +
            "    <script src=\"css/js/main.js\"\n" +
            "            th:src=\"@{css/js/main.js}\"></script>\n" +
            "    <link href=\"../static/css/main.css\"\n" +
            "          th:href=\"@{css/main.css}\" rel=\"stylesheet\" media=\"screen\"/>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"container\">";

    protected static String FOOTER = "<br><a href=\"/index\" class=\"btn btn-info\"><< Back to Homepage</a>" + "\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>";

}
