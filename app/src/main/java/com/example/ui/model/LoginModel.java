package com.example.ui.model;

public class LoginModel {


    public LoginModel(int id, String name, String account, int role_id, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.role_id = role_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    /**
     * id : 1
     * name : 張秋龍
     * account : e1001
     * role_id : 1
     * created_at : 2019-05-10 15:18:16
     * updated_at : 2019-05-10 15:18:16
     */




    private int id;
    private String name;
    private String account;
    private int role_id;
    private String created_at;
    private String updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
