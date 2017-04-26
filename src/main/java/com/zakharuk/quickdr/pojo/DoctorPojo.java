package com.zakharuk.quickdr.pojo;

import java.util.Date;

/**
 * Created by matvii on 13.04.17.
 */
public class DoctorPojo {

    private String name;
    private int office;
    private Date workingHour1;
    private Date workingHour2;

    public DoctorPojo(String name, int office, Date workingHour1, Date workingHour2) {
        this.name = name;
        this.office = office;
        this.workingHour1 = workingHour1;
        this.workingHour2 = workingHour2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOffice() {
        return office;
    }

    public void setOffice(int office) {
        this.office = office;
    }

    public Date getWorkingHour1() {
        return workingHour1;
    }

    public void setWorkingHour1(Date workingHour1) {
        this.workingHour1 = workingHour1;
    }

    public Date getWorkingHour2() {
        return workingHour2;
    }

    public void setWorkingHour2(Date workingHour2) {
        this.workingHour2 = workingHour2;
    }
}
