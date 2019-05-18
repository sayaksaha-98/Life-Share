package com.lifeshare.www.lifeshare;

public class UserProfile {

    public String userEmail;
    public String userName;
    public String userBlood;
    public String userPhone;
    public String userState;
    public String userDistrict;

    public UserProfile(){

    }

    public UserProfile(String userState, String userDistrict, String userEmail, String userName, String userBlood, String userPhone) {

        this.userEmail = userEmail;
        this.userName = userName;
        this.userBlood = userBlood;
        this.userPhone = userPhone;
        this.userState = userState;
        this.userDistrict = userDistrict;
    }





    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserBlood() {
        return userBlood;
    }

    public void setUserBlood(String userBlood) {
        this.userBlood = userBlood;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUserDistrict() {
        return userDistrict;
    }

    public void setUserDistrict(String userDistrict) {
        this.userDistrict = userDistrict;
    }
}
