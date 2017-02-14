package com.zakharuk.quickdr;

import javax.print.Doc;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by matvii on 14.02.17.
 */
public interface IPatientRecord {

    Patient getPatient();
    List<Doctor> getDoctors();
    List<String> getDiagnoses();
    List<Procedure> getProcedures();

}
