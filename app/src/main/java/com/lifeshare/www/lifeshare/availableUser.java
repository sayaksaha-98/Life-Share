package com.lifeshare.www.lifeshare;

public class availableUser {

    private String aEmail;
    private String aName;
    private String aPhone;

    public availableUser() {
    }

    public availableUser(String aEmail, String aName, String aPhone) {
        this.aEmail = aEmail;
        this.aName = aName;
        this.aPhone = aPhone;
    }

    public String getaEmail() {
        return aEmail;
    }

    public void setaEmail(String aEmail) {
        this.aEmail = aEmail;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaPhone() {
        return aPhone;
    }

    public void setaPhone(String aPhone) {
        this.aPhone = aPhone;
    }
}
