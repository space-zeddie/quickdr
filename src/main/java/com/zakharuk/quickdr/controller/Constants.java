package com.zakharuk.quickdr.controller;

/**
 * Created by matvii on 13.04.17.
 */
public class Constants {

    public static final String signUpBtn(long id) {
        return "<a href=\"/select-add-student?subjectid=" + id + "\" class=\"btn btn-info\">Sign Up</a>";
    }

    public static final String listStudentsBtn(long id) {

        return "<a href=\"/list-students?id=" + id + "\" class=\"btn btn-info\">View Students</a>";
    }
    public static final String deleteSubjectBtn(long id) {

        return "<a href=\"/delete?id=" + id + "\" class=\"btn btn-info\">Delete Subject</a>";
    }
    public static final String editSubjectBtn(long id) {

        return "<a href=\"/edit-subject?id=" + id + "\" class=\"btn btn-info\">Edit Subject</a>";
    }


    public static final String recommendBtn(long id) {

        return "<a href=\"/recommend?id=" + id + "&rec=true" + "\" class=\"btn btn-info\">Recommend</a>";
    }

    public static final String unrecommendBtn(long id) {

        return "<a href=\"/recommend?id=" + id + "&rec=false" + "\" class=\"btn btn-info\">Unrecommend</a>";
    }

    public static final String updateProfBtn(long id) {

        return "<a href=\"/?id=" + id  + "\" class=\"btn btn-info updateProf\" id=\""+ id +"\">Change Professor</a>";
    }

    public static final String editPatientBtn(int id) {
        return "<a href=\"/edit-patient?id=" + id  + "\" class=\"btn btn-info edit-patient\" id=\""+ id +"\">Edit Patient Record</a>";
    }
    public static final String signOutPatientBtn(int id) {
        return "<a href=\"/sign-out-patient?patientId=" + id  + "\" class=\"btn btn-info edit-patient\" id=\""+ id +"\">Sign Out Patient</a>";
    }





    public static final String addStudentBtn(long id, long studentId) {

        return "<a href=\"/add-user?subjectid=" + id + "&userid=" + studentId + "\" class=\"btn btn-info\">Sign Up </a>";
    }
    public static final String setProfBtn(long id, long prof) {

        return "<a href=\"/set-profr?id=" + id + "&prof=" + prof + "\" class=\"btn btn-info\">Change Professor</a>";
    }
    public static final String removeStudentBtn(long id, long studentId) {

        return "<a href=\"/remove-user?subjectid=" + id + "&userid=" + studentId + "\" class=\"btn btn-info\">Sign Off </a>";
    }

    public static final String HEADER = "<!DOCTYPE html>\n" +
            "<html xmlns:th=\"http://www.thymeleaf.org\">\n" +
            "<head lang=\"en\">\n" +
            "\n" +
            "    <title>QuickDR</title>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n" +
            "    <link href=\"css/bootstrap.min.css\"\n" +
            "          th:href=\"@{css/bootstrap.min.css}\"\n" +
            "          rel=\"stylesheet\" media=\"screen\" />\n" +
            "    <script src=\"js/jq.js\"\n" +
            "            th:src=\"@{js/jq.js}\"></script>\n" +
            "    <script src=\"js/bootstrap.js\"\n" +
            "            th:src=\"@{js/bootstrap.js}\"></script>\n" +
            "    <script src=\"js/main.js\"\n" +
            "            th:src=\"@{js/main.js}\"></script>\n" +
            "    <link href=\"../static/css/main.css\"\n" +
            "          th:href=\"@{css/main.css}\" rel=\"stylesheet\" media=\"screen\"/>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"container\">";

    public static final String FOOTER = "<br><a href=\"/index\" class=\"btn btn-info\"><< Back to Homepage</a>" + "\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>";
}
