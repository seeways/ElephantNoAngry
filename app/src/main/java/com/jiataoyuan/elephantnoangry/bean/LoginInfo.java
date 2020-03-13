package com.jiataoyuan.elephantnoangry.bean;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class LoginInfo extends LitePalSupport {

    @Column(unique = true, nullable = false)
    private long id;
    @Column(unique = true, nullable = false)
    private String phone;
    @Column(unique = true, nullable = false)
    private String pass;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
