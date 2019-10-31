package com.example.netflixclient.models;


import javax.validation.constraints.NotNull;


public class User {


    private String userName;

    private Long identificationNumber;

    public User(String userName, Long identificationNumber) {
        this.userName = userName;
        this.identificationNumber = identificationNumber;
    }

    private User(){
        
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public Long getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(Long identificationNumber) {
        this.identificationNumber = identificationNumber;
    }


    @Override
    public String toString() {
        return "User{" +
                "User Name :"+userName+
                "Identification Number :"+identificationNumber+
                "}";
    }
}
