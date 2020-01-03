package com.example.ui.model;

public class ManufactureModel {

    public ManufactureModel(String mo_id) {
        this.mo_id = mo_id;
    }

    /**
     * mo_id : 1MO1901190001
     */


    private String mo_id;

    public String getMo_id() {
        return mo_id;
    }

    public void setMo_id(String mo_id) {
        this.mo_id = mo_id;
    }
}
