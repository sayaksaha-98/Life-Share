package com.lifeshare.www.lifeshare;

public class nearbyRequest {

    private String pName;
    private String pHospital;
    private String pPhone;

    public nearbyRequest(){

    }

    public nearbyRequest(String pName, String pHospital, String pPhone) {
        this.pName = pName;
        this.pHospital = pHospital;
        this.pPhone = pPhone;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpHospital() {
        return pHospital;
    }

    public void setpHospital(String pHospital) {
        this.pHospital = pHospital;
    }

    public String getpPhone() {
        return pPhone;
    }

    public void setpPhone(String pPhone) {
        this.pPhone = pPhone;
    }
}
