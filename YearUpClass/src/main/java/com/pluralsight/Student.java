package com.pluralsight;

public class Student extends Person{
    private int id;
    private String github;
    private String linkedIn;
    private String codingNickname;
    private String codeWarsXPoints;
    private String imageURL;
    private String deviceType;
    private int pageNumberWorkbook;
    private String currentlyWorkingOn;

    public Student(String firstname, String lastname, String email, String gender, int id, String github, String linkedIn, String codingNickname, String codeWarsXPoints, String imageURL, String deviceType, int pageNumberWorkbook, String currentlyWorkingOn) {

        super(firstname, lastname, email, gender);
        this.id = id;
        this.github = github;
        this.linkedIn = linkedIn;
        this.codingNickname = codingNickname;
        this.codeWarsXPoints = codeWarsXPoints;
        this.imageURL = imageURL;
        this.deviceType = deviceType;
        this.pageNumberWorkbook = pageNumberWorkbook;
        this.currentlyWorkingOn = currentlyWorkingOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getCodingNickname() {
        return codingNickname;
    }

    public void setCodingNickname(String codingNickname) {
        this.codingNickname = codingNickname;
    }

    public String getCodeWarsXPoints() {
        return codeWarsXPoints;
    }

    public void setCodeWarsXPoints(String codeWarsXPoints) {
        this.codeWarsXPoints = codeWarsXPoints;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public int getPageNumberWorkbook() {
        return pageNumberWorkbook;
    }

    public void setPageNumberWorkbook(int pageNumberWorkbook) {
        this.pageNumberWorkbook = pageNumberWorkbook;
    }

    public String getCurrentlyWorkingOn() {
        return currentlyWorkingOn;
    }

    public void setCurrentlyWorkingOn(String currentlyWorkingOn) {
        this.currentlyWorkingOn = currentlyWorkingOn;
    }
}
