package com.example.dawaiwala.Models;

public class Users {
    String  profilepic,username,email,password;

    public Users(String profilepic,String username, String email, String password) {
        this.profilepic=profilepic;
        this.username = username;
        this.email = email;
        this.password = password;
    }



    //Signup Constructor
    public Users(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
