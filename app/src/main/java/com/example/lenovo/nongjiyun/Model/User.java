package com.example.lenovo.nongjiyun.Model;

public class User {
    private String userId;
    private String account;
    private String nickName;
    private String avatar;
    private int sex;
    private int identity;
    private String cityCode;
    private String townCode;
    private String streetCode;
    private String address;
    private int isComplete;
    private int isIdentity;
    private int coin;
    private int grade;
    private int signCount;
    private int problemCount;
    private int answerCount;
    private String companyName;
    private String email;
    private String industry;
    private String education;
    private int isSign;
    public User() {
    }

    public User(String userId, String account, String nickName, String avatar, int sex, int identity, String cityCode, String townCode, String streetCode, String address, int isComplete, int isIdentity, int coin, int grade, int signCount, int problemCount, int answerCount, String companyName, String email, String industry) {
        this.userId = userId;
        this.account = account;
        this.nickName = nickName;
        this.avatar = avatar;
        this.sex = sex;
        this.identity = identity;
        this.cityCode = cityCode;
        this.townCode = townCode;
        this.streetCode = streetCode;
        this.address = address;
        this.isComplete = isComplete;
        this.isIdentity = isIdentity;
        this.coin = coin;
        this.grade = grade;
        this.signCount = signCount;
        this.problemCount = problemCount;
        this.answerCount = answerCount;
        this.companyName = companyName;
        this.email = email;
        this.industry = industry;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public String getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(int isComplete) {
        this.isComplete = isComplete;
    }

    public int getIsIdentity() {
        return isIdentity;
    }

    public void setIsIdentity(int isIdentity) {
        this.isIdentity = isIdentity;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getSignCount() {
        return signCount;
    }

    public void setSignCount(int signCount) {
        this.signCount = signCount;
    }

    public int getProblemCount() {
        return problemCount;
    }

    public void setProblemCount(int problemCount) {
        this.problemCount = problemCount;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", account='" + account + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", sex=" + sex +
                ", identity=" + identity +
                ", cityCode='" + cityCode + '\'' +
                ", townCode='" + townCode + '\'' +
                ", streetCode='" + streetCode + '\'' +
                ", address='" + address + '\'' +
                ", isComplete=" + isComplete +
                ", isIdentity=" + isIdentity +
                ", coin=" + coin +
                ", grade=" + grade +
                ", signCount=" + signCount +
                ", problemCount=" + problemCount +
                ", answerCount=" + answerCount +
                ", companyName='" + companyName + '\'' +
                ", email='" + email + '\'' +
                ", industry='" + industry + '\'' +
                ", education='" + education + '\'' +
                ", isSign=" + isSign +
                '}';
    }

}
