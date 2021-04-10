package com.wee.learn.model.user.instructor;

import java.util.Map;

public class Instructor {

    private String first_name;
    private String last_name;
    private String email;
    private String profile_picture;

    public Instructor()
    {
    }

    public Instructor(Map<String, Object> instructor)
    {
        this.email = instructor.get("email").toString();
        this.first_name = instructor.get("first_name").toString();
        this.last_name = instructor.get("last_name").toString();
        this.profile_picture = instructor.get("profile_picture").toString();
    }


    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }
}
