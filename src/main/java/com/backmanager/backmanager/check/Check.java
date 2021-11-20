package com.backmanager.backmanager.check;

import com.backmanager.backmanager.po.OracleDataBaseInfo;

public class Check {
    private static boolean flag = false;
    /**
     * 
     * @param param
     * @return
     */
    public static boolean checkMustInput(String param){
        if(!"".equals(param) && !"null".equals(param) && null != param){
            return true;
        }
        return false;
    }
    /**
     * 
     * @param odb
     * @return
     */
    public static boolean checkOracleConnectToSaveMustInput(OracleDataBaseInfo odb){
        if(!checkMustInput(odb.getConnectName())){
            return false;
        }
        if(!checkMustInput(odb.getCustId())){
            return false;
        }
        if(!checkOracleConnectMustInput(odb)){
            return false;
        }
        return true;
    }
    /**
     * 
     * @param odb
     * @return
     */
    public static boolean checkOracleConnectMustInput(OracleDataBaseInfo odb){
        if(!checkMustInput(odb.getIp())){
            return false;
        }
        if(!checkMustInput(odb.getDbUsrNa())){
            return false;
        }
        if(!checkMustInput(odb.getPassword())){
            return false;
        }
        if(!checkMustInput(odb.getPort())){
            return false;
        }
        if(!checkMustInput(odb.getSid())){
            return false;
        }
        return true;
    }
}
