package com.example.ui.model;

public class LoginTokenModel {

    public LoginTokenModel(int status, String token) {
        this.status = status;
        this.token = token;
    }

    /**
     * status : 0
     * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvd2ViLm51dGMtaW1hYy5jb206Njc4OVwvYXBpXC9hdXRoXC9sb2dpbiIsImlhdCI6MTU1ODM3NTE0NCwiZXhwIjoxNTU4Mzc4NzQ0LCJuYmYiOjE1NTgzNzUxNDQsImp0aSI6Im1aakc4ZFI0UG9VUEcwZXAiLCJzdWIiOjEsInBydiI6ImY5MzA3ZWI1ZjI5YzcyYTkwZGJhYWVmMGUyNmYwMjYyZWRlODZmNTUifQ.O89LfOX5uIsCENE21zjFWnTQDvJ45ypputROaWpjXCU
     */


    private int status;
    private String token;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
