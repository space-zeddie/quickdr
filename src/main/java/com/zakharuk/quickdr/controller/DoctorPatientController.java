package com.zakharuk.quickdr.controller;

import com.zakharuk.quickdr.service.DoctorService;
import com.zakharuk.quickdr.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by matvii on 13.04.17.
 */
@Controller
public class DoctorPatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;

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
