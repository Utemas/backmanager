package com.backmanager.backmanager.dbtools.handler;

import java.sql.Connection;
import java.util.HashMap;

import com.backmanager.backmanager.check.Check;
import com.backmanager.backmanager.po.OracleDataBaseInfo;
import com.backmanager.backmanager.sqlExcute.AbourDataBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
/**
    * 连接Oracle数据库
    * @param ip 数据库所在地址，本地用localhost
    * @param connectname 连接数据库的用户名
    * @param password 连接数据库的用户名对应的密码
    * @param port  数据库的对外端口号
    * @param oracleSID 数据库实例名称
    * @return 是否连接成功
    */
public class CreateOracleConnectionHandler{
    @Autowired
    RedisTemplate<String,String> rt;
    
    HashMap<String, String> hm = new HashMap<String, String>();
    public HashMap<String,String> doMethod(OracleDataBaseInfo odb){
        try {
            boolean flag = Check.checkOracleConnectMustInput(odb);
            if(!flag){
                hm.clear();
                hm.put("retFlg", "false");
                hm.put("retMsg", "oracle connection must params Imcomplete:");
                hm.put("oracleDataBaseInfo",String.valueOf(odb));
                return hm;
            }
            if("1".equals(odb.getSaveFlag())){//如果是保存，进行校验后进入redis
                boolean flagtoSave = Check.checkOracleConnectToSaveMustInput(odb);//验证保存参数必输性
                if(!flagtoSave){//不通过
                    hm.clear();
                    hm.put("retFlg", "false");
                    hm.put("retMsg", "save failed");
                    hm.put("oracleDataBaseInfo",String.valueOf(odb));
                    return hm;
                }
                Connection  c1  = AbourDataBase.connectOracle(odb.getIp(),odb.getDbUsrNa(),odb.getPassword(),odb.getPort(),odb.getSid());
                if(c1 != null){
                    synchronized(this) {
                        HashMap<String,String> connectMap = new HashMap<String,String>();
                        connectMap.put("ip",odb.getIp());
                        connectMap.put("password", odb.getPassword());
                        connectMap.put("port", odb.getPort()); 
                        connectMap.put("sid", odb.getSid());
                        connectMap.put("dbUsrNa", odb.getDbUsrNa());
                        connectMap.put("serviceName", odb.getServiceName());
                        rt.opsForHash().putAll("oracle:"+odb.getCustId()+":"+odb.getConnectName(),connectMap);
                    }
                }
                hm.put("retFlg", "true");
                hm.put("retMsg", "create connection successed");
                c1.close();
            } else { //存入Oracle
                
            }
           return  hm;
        } catch (Exception e) {
            hm.put("retMsg", e.toString());
            return hm;
        }
        
    }
}
