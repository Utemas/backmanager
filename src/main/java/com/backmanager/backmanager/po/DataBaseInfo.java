package com.backmanager.backmanager.po;

import java.io.Serializable;

public class DataBaseInfo implements Serializable{
    private String custId;//客户ID
    private String connectName;//连接名
    private String connectUrl;//连接地址
    private String port;//连接端口
    private String connectUserName;//连接用户名
    private String connectPassword;//连接密码
    private String dataBaseType;//数据库类型
    private String SID;//Oracle SID
    private String serviceName; //Oracle 服务名

    public void setCustId(String custId) {
        this.custId = custId;
    }
    public String getCustId(){
        return this.custId;
    }

    public void setConnectName(String connectName) {
        this.connectName = connectName;
    }
    public String getConnectName(){
        return this.connectName;
    }
    public String getConnectUrl() {
        return connectUrl;
    }
    public void setConnectUrl(String connectUrl) {
        this.connectUrl = connectUrl;
    }
    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public String getConnectUserName() {
        return connectUserName;
    }
    public void setConnectUserName(String connectUserName) {
        this.connectUserName = connectUserName;
    }
    public String getConnectPassword() {
        return connectPassword;
    }
    public void setConnectPassword(String connectPassword) {
        this.connectPassword = connectPassword;
    }
    public String getDataBaseType() {
        return dataBaseType;
    }
    public void setDataBaseType(String dataBaseType) {
        this.dataBaseType = dataBaseType;
    }
    public String getSID() {
        return SID;
    }
    public void setSID(String sID) {
        SID = sID;
    }
    public String getServiceName() {
        return serviceName;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    
    
}
