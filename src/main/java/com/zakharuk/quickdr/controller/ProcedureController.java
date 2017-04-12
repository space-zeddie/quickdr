package com.zakharuk.quickdr.controller;

import com.zakharuk.quickdr.entity.ChildPatient;
import com.zakharuk.quickdr.entity.Patient;
import com.zakharuk.quickdr.entity.Procedure;
import com.zakharuk.quickdr.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by matvii on 12.04.17.
 */
@Controller
public class ProcedureController {

    @Autowired
    private ProcedureService procedureService;

    private SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");

    /**
     * GET /create  --> Create a new procedure and save it in the database.
     */
    @RequestMapping("/create-procedure")
    @ResponseBody
    public String create(String type, String date, String compl) {
        String id = "";
        try {
            Procedure procedure = new Procedure();
            procedure.setType(type);
            procedure.setDateOfProcedure(formatter.parse(date));
            procedure.setCompleted(Boolean.parseBoolean(compl));
            procedureService.add(procedure);
            id = String.valueOf(procedure.getId());
        }
        catch (Exception ex) {
            return HEADER +  "Error registering the procedure: " + ex.toString() + FOOTER;
        }
        return HEADER + "Procedure succesfully registered with id = " + id + FOOTER;
    }

    /**
     * GET /delete  --> Delete the procedure having the passed id.
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(int id) {
        try {
            Procedure procedure = new Procedure();
            procedure.setId(id);
            procedureService.remove(procedure);
        }
        catch (Exception ex) {
            return HEADER + "Error deleting the procedure:" + ex.toString() + FOOTER;
        }
        return HEADER + "Procedure succesfully deleted!" + FOOTER;
    }

    /**
     * GET /update  --> Update the name and the age for the subject in the
     * database having the passed id.
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(int id, String type, String date, String compl) {
        try {
            Procedure procedure = procedureService.getProcedureById(id);
            procedure.setType(type);
            procedure.setDateOfProcedure(formatter.parse(date));
            procedure.setCompleted(Boolean.parseBoolean(compl));
            procedureService.update(procedure);
        }
        catch (Exception ex) {
            return HEADER + "Error updating the procedure: " + ex.toString() + FOOTER;
        }
        return HEADER + "Procedure succesfully updated!" + FOOTER;
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
