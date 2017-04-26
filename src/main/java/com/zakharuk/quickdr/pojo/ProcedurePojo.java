package com.zakharuk.quickdr.pojo;

import java.util.Date;

/**
 * Created by matvii on 12.04.17.
 */
public class ProcedurePojo {

    private String type;
    private Date date;
    private boolean completed;

    public ProcedurePojo(String type, Date date, boolean completed) {
        this.type = type;
        this.date = date;
        this.completed = completed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
