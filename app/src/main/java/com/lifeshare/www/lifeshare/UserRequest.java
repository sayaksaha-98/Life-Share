package com.lifeshare.www.lifeshare;

public class UserRequest {
    public String PName;
    public String PPhone;
    public String PHospital;

    public UserRequest(){

    }

    public UserRequest(String PName, String PPhone, String PHospital){
        this.PName = PName;
        this.PPhone = PPhone;
        this.PHospital = PHospital;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public String getPPhone() {
        return PPhone;
    }

    public void setPPhone(String PPhone) {
        this.PPhone = PPhone;
    }

    public String getPHospital() {
        return PHospital;
    }

    public void setPHospital(String PHospital) {
        this.PHospital = PHospital;
    }
}
