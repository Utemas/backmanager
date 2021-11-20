package com.backmanager.backmanager.po;

import java.io.Serializable;

public class OracleDataBaseInfo implements Serializable{
    private String custId;//客户ID
    private String connectName;//连接名
    private String ip;//连接地址
    private String port;//连接端口
    private String dbUsrNa;//连接用户名
    private String password;//连接密码
    private String sid;//Oracle SID
    private String serviceName; //Oracle 服务名
    private String saveFlag; //保存标志 0-暂存 1-保存
    
    public String getSaveFlag() {
        return saveFlag;
    }
    public void setSaveFlag(String saveFlag) {
        this.saveFlag = saveFlag;
    }
    public String getCustId() {
        return custId;
    }
    public void setCustId(String custId) {
        this.custId = custId;
    }
    public String getConnectName() {
        return connectName;
    }
    public void setConnectName(String connectName) {
        this.connectName = connectName;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public String getDbUsrNa() {
        return dbUsrNa;
    }
    public void setDbUsrNa(String dbUsrNa) {
        this.dbUsrNa = dbUsrNa;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getServiceName() {
        return serviceName;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public String getSid() {
        return sid;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }
    @Override
    public String toString() {
        return "OracleDataBaseInfo [connectName=" + connectName + ", custId=" + custId + ", dbUsrNa=" + dbUsrNa
                + ", ip=" + ip + ", password=" + password + ", port=" + port + ", serviceName=" + serviceName + ", sid="
                + sid + "]";
    }
    
}
