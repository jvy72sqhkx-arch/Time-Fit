package com.timefit.entity;


public class User {


    private String userName;
    private String password;

    public User(){
    }



    public String getUserName(){
        return userName;
    }

    public void setUserName(String name){
        this.userName = name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

}
