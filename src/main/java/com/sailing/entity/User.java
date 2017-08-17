package com.sailing.entity;

import java.beans.Transient;
import java.util.Calendar;
import java.util.Date;

public class User {
    private String uid;

    private String username;

    private String upassword;

    private String uname;

    private Integer uage;

    private String usex;

    private String uemail;

    private String uphone;

    private Date uregistertime;

    private Byte ustatus;

    private String uvalidatecode;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", upassword='" + upassword + '\'' +
                ", uname='" + uname + '\'' +
                ", uage=" + uage +
                ", usex='" + usex + '\'' +
                ", uemail='" + uemail + '\'' +
                ", uphone='" + uphone + '\'' +
                ", uregistertime=" + uregistertime +
                ", ustatus=" + ustatus +
                ", uvalidatecode='" + uvalidatecode + '\'' +
                '}';
    }

    public Integer getUage() {
        return uage;
    }

    public void setUage(Integer uage) {
        this.uage = uage;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public Date getUregistertime() {
        return uregistertime;
    }

    public void setUregistertime(Date uregistertime) {
        this.uregistertime = uregistertime;
    }

    public Byte getUstatus() {
        return ustatus;
    }

    public void setUstatus(Byte ustatus) {
        this.ustatus = ustatus;
    }

    public String getUvalidatecode() {
        return uvalidatecode;
    }

    public void setUvalidatecode(String uvalidatecode) {
        this.uvalidatecode = uvalidatecode;
    }


    @Transient //by
    public Date getLastActivateTime() {
        Calendar cl = Calendar.getInstance();
        cl.setTime(uregistertime);
        cl.add(Calendar.DATE , 2);

        return cl.getTime();
    }
}