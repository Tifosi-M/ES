package com.es.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by szp on 15/8/18.
 */
@Entity
@javax.persistence.Table(name = "t_users", schema = "", catalog = "ESdb")
public class TUsersEntity {
    private int userId;

    @Id
    @javax.persistence.Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private String username;

    @Basic
    @javax.persistence.Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String nickname;

    @Basic
    @javax.persistence.Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private String password;

    @Basic
    @javax.persistence.Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String telephone;

    @Basic
    @javax.persistence.Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    private String qqNumber;

    @Basic
    @javax.persistence.Column(name = "qq_number")
    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    private String weiboAccount;

    @Basic
    @javax.persistence.Column(name = "weibo_account")
    public String getWeiboAccount() {
        return weiboAccount;
    }

    public void setWeiboAccount(String weiboAccount) {
        this.weiboAccount = weiboAccount;
    }

    private Integer permissions;

    @Basic
    @javax.persistence.Column(name = "permissions")
    public Integer getPermissions() {
        return permissions;
    }

    public void setPermissions(Integer permissions) {
        this.permissions = permissions;
    }

    private String instroduce;

    @Basic
    @javax.persistence.Column(name = "instroduce")
    public String getInstroduce() {
        return instroduce;
    }

    public void setInstroduce(String instroduce) {
        this.instroduce = instroduce;
    }

    private String nationality;

    @Basic
    @javax.persistence.Column(name = "nationality")
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    private String hometownProvince;

    @Basic
    @javax.persistence.Column(name = "hometown_province")
    public String getHometownProvince() {
        return hometownProvince;
    }

    public void setHometownProvince(String hometownProvince) {
        this.hometownProvince = hometownProvince;
    }

    private String hometownCity;

    @Basic
    @javax.persistence.Column(name = "hometown_city")
    public String getHometownCity() {
        return hometownCity;
    }

    public void setHometownCity(String hometownCity) {
        this.hometownCity = hometownCity;
    }

    private String currentProvince;

    @Basic
    @javax.persistence.Column(name = "current_province")
    public String getCurrentProvince() {
        return currentProvince;
    }

    public void setCurrentProvince(String currentProvince) {
        this.currentProvince = currentProvince;
    }

    private String currentCity;

    @Basic
    @javax.persistence.Column(name = "current_city")
    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    private String currentNationality;

    @Basic
    @javax.persistence.Column(name = "current_nationality")
    public String getCurrentNationality() {
        return currentNationality;
    }

    public void setCurrentNationality(String currentNationality) {
        this.currentNationality = currentNationality;
    }

    private Double longitude;

    @Basic
    @javax.persistence.Column(name = "longitude")
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    private Double latitude;

    @Basic
    @javax.persistence.Column(name = "latitude")
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    private Integer age;

    @Basic
    @javax.persistence.Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Date birthday;

    @Basic
    @javax.persistence.Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    private String sex;

    @Basic
    @javax.persistence.Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private Timestamp registrationDate;

    @Basic
    @javax.persistence.Column(name = "registration_date")
    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    private String imgpath;

    @Basic
    @javax.persistence.Column(name = "imgpath")
    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    private Float activevalue;

    @Basic
    @javax.persistence.Column(name = "activevalue")
    public Float getActivevalue() {
        return activevalue;
    }

    public void setActivevalue(Float activevalue) {
        this.activevalue = activevalue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TUsersEntity that = (TUsersEntity) o;

        if (userId != that.userId) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (qqNumber != null ? !qqNumber.equals(that.qqNumber) : that.qqNumber != null) return false;
        if (weiboAccount != null ? !weiboAccount.equals(that.weiboAccount) : that.weiboAccount != null) return false;
        if (permissions != null ? !permissions.equals(that.permissions) : that.permissions != null) return false;
        if (instroduce != null ? !instroduce.equals(that.instroduce) : that.instroduce != null) return false;
        if (nationality != null ? !nationality.equals(that.nationality) : that.nationality != null) return false;
        if (hometownProvince != null ? !hometownProvince.equals(that.hometownProvince) : that.hometownProvince != null)
            return false;
        if (hometownCity != null ? !hometownCity.equals(that.hometownCity) : that.hometownCity != null) return false;
        if (currentProvince != null ? !currentProvince.equals(that.currentProvince) : that.currentProvince != null)
            return false;
        if (currentCity != null ? !currentCity.equals(that.currentCity) : that.currentCity != null) return false;
        if (currentNationality != null ? !currentNationality.equals(that.currentNationality) : that.currentNationality != null)
            return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (registrationDate != null ? !registrationDate.equals(that.registrationDate) : that.registrationDate != null)
            return false;
        if (imgpath != null ? !imgpath.equals(that.imgpath) : that.imgpath != null) return false;
        if (activevalue != null ? !activevalue.equals(that.activevalue) : that.activevalue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (qqNumber != null ? qqNumber.hashCode() : 0);
        result = 31 * result + (weiboAccount != null ? weiboAccount.hashCode() : 0);
        result = 31 * result + (permissions != null ? permissions.hashCode() : 0);
        result = 31 * result + (instroduce != null ? instroduce.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + (hometownProvince != null ? hometownProvince.hashCode() : 0);
        result = 31 * result + (hometownCity != null ? hometownCity.hashCode() : 0);
        result = 31 * result + (currentProvince != null ? currentProvince.hashCode() : 0);
        result = 31 * result + (currentCity != null ? currentCity.hashCode() : 0);
        result = 31 * result + (currentNationality != null ? currentNationality.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (imgpath != null ? imgpath.hashCode() : 0);
        result = 31 * result + (activevalue != null ? activevalue.hashCode() : 0);
        return result;
    }
}
