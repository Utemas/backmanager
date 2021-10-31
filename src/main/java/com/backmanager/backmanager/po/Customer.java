package com.backmanager.backmanager.po;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class Customer implements Serializable{
    private String id;
    private String name;
    private String password;
    private String sts;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }

    public void setSts(String sts){
        this.sts = sts;
    }
    public String getSts(){
        return this.sts;
    }

}
