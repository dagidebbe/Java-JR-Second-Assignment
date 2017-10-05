package com.company;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Date.*;

/**
 *
 */
public class user {
    public static long userIdCounter=0;
    private long userid=0;
    private String name;
    private Date dob;



    public user(String name, Date dob) {
        this.name = name;
        this.dob = dob;
        this.userid=userIdCounter;
        userIdCounter++;
    }
    public user(long userid, String name, Date dob) {
        this.userid = userid;
        this.name = name;
        this.dob = dob;
        userIdCounter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public static long getUserIdCounter() {
        return userIdCounter;
    }

    public static void setUserIdCounter(long userIdCounter) {
        user.userIdCounter = userIdCounter;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }
}
