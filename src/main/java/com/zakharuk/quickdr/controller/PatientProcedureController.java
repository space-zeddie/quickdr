package com.zakharuk.quickdr.controller;

import com.zakharuk.quickdr.dao.PatientProcedureDao;
import com.zakharuk.quickdr.entity.ChildPatient;
import com.zakharuk.quickdr.entity.Doctor;
import com.zakharuk.quickdr.entity.Patient;
import com.zakharuk.quickdr.entity.Procedure;
import com.zakharuk.quickdr.service.DoctorService;
import com.zakharuk.quickdr.service.PatientService;
import com.zakharuk.quickdr.service.ProcedureService;
import org.apache.tomcat.jni.Proc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by matvii on 13.04.17.
 */

@Controller
public class PatientProcedureController  {

    @Autowired
    private PatientProcedureDao patientProcedureDao;

    @Autowired
    private ProcedureService procedureService;
    @Autowired
    private PatientService patientService;

    @RequestMapping("/assign-procedure")
    @ResponseBody
    public String update(int procedureId, int patientId) {
        Patient patient = null;
        Procedure procedure = null;
        try {
            procedure = procedureService.getProcedureById(procedureId);
            patient = patientService.getPatientById(patientId);
            //if (!doctorPatientService.getDoctorsPatients(doctorId).contains(patient))
                patientProcedureDao.assignProcedureToPatient(procedureId, patientId);
        }
        catch (Exception ex) {
            return Constants.HEADER + "Error assigning the patient: " + patient + " to " + procedure
                    + Constants.FOOTER;
        }
        return Constants.HEADER + "Patient succesfully assigned!" + Constants.FOOTER;
    }


}
