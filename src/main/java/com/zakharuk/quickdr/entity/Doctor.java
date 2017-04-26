package com.zakharuk.quickdr.entity;

import javafx.util.Pair;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by matvii on 06.02.17.
 */
public interface Doctor {

    void examine(ChildPatient patient);
    Pair<Date, Date> getWorkingHours();
    boolean bookAppointment(Patient patient, Date at);
    Map<Date, Patient> getAppointments();
    List<ChildPatient> getPatients();
    List<Procedures> getAvailableProcedures();

    String getName();

    void setName(String name);

    int getOffice();

    void setOffice(int office);

    void setId(int id);

    int getId();

    void setWorkingHour1(Date workingHour1);
    Date getWorkingHour1();

    void setWorkingHour2(Date workingHour1);
    Date getWorkingHour2();

}
