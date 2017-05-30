package com.example.forever.bestdeal.ModelClass;

import java.io.Serializable;

/**
 * Created by Ashif Rahman on 5/30/2017.
 */

public class UserModel implements Serializable {
    private int userId;
    private String firebaseUserKey;
    private String fullname;
    private String userEmail;
    private String password;
    private String userContactNo;
    private String address;

    public UserModel(int userId, String fullname, String userEmail, String password, String userContactNo, String address) {
        this.userId = userId;
        this.fullname = fullname;
        this.userEmail = userEmail;
        this.password = password;
        this.userContactNo = userContactNo;
        this.address = address;
    }

    public UserModel(String firebaseUserKey,String fullname, String userEmail, String password, String userContactNo) {
        this.firebaseUserKey = firebaseUserKey;
        this.fullname = fullname;
        this.userEmail = userEmail;
        this.password = password;
        this.userContactNo = userContactNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirebaseUserKey() {
        return firebaseUserKey;
    }

    public void setFirebaseUserKey(String firebaseUserKey) {
        this.firebaseUserKey = firebaseUserKey;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserContactNo() {
        return userContactNo;
    }

    public void setUserContactNo(String userContactNo) {
        this.userContactNo = userContactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
