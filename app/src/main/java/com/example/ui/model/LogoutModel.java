package com.example.ui.model;

public class LogoutModel {

    public LogoutModel(int status) {
        this.status = status;
    }

    /**
     * status : 0
     */


    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
