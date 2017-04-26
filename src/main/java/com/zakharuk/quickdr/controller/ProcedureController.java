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
            return Constants.HEADER +  "Error registering the procedure: " + ex.toString() + Constants.FOOTER;
        }
        return Constants.HEADER + "Procedure succesfully registered with id = " + id + Constants.FOOTER;
    }

    /**
     * GET /delete  --> Delete the procedure having the passed id.
     */
    @RequestMapping("/delete-procedure")
    @ResponseBody
    public String delete(int id) {
        try {
            Procedure procedure = new Procedure();
            procedure.setId(id);
            procedureService.remove(procedure);
        }
        catch (Exception ex) {
            return Constants.HEADER + "Error deleting the procedure:" + ex.toString() + Constants.FOOTER;
        }
        return Constants.HEADER + "Procedure succesfully deleted!" + Constants.FOOTER;
    }

    /**
     * GET /update  --> Update the name and the age for the subject in the
     * database having the passed id.
     */
    @RequestMapping("/update-procedure")
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
            return Constants.HEADER + "Error updating the procedure: " + ex.toString() + Constants.FOOTER;
        }
        return Constants.HEADER + "Procedure succesfully updated!" + Constants.FOOTER;
    }

}
