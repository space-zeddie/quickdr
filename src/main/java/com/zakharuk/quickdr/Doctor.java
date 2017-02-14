package com.zakharuk.quickdr;

import javafx.util.Pair;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by matvii on 06.02.17.
 */
public interface Doctor {

    void examine(Patient patient);
    Pair<Date, Date> getWorkingHours();
    boolean bookAppointment(Patient patient, Date at);
    Map<Date, Patient> getAppointments();
    List<Patient> getPatients();
    List<Procedures> getAvailableProcedures();

}
