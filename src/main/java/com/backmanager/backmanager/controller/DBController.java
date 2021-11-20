package com.backmanager.backmanager.controller;

import java.sql.Connection;
import java.util.HashMap;

import com.backmanager.backmanager.check.Check;
import com.backmanager.backmanager.po.OracleDataBaseInfo;
import com.backmanager.backmanager.sqlExcute.AbourDataBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBController {
    @Autowired
    private RedisTemplate<String,String> rt;

    @RequestMapping("/ss")
    public String ee() {
        System.out.println("maind");
        return "ss";
    }
     /**
    * 连接Oracle数据库
    * @param ip 数据库所在地址，本地用localhost
    * @param connectname 连接数据库的用户名
    * @param password 连接数据库的用户名对应的密码
    * @param port  数据库的对外端口号
    * @param oracleSID 数据库实例名称
    * @return 是否连接成功
    */
    @RequestMapping("/createOracleConnect")
    public HashMap<String,String> createOracleConnect(OracleDataBaseInfo odb) {
        
        HashMap<String,String> resultMap = new HashMap<String,String>();
        
        
        try {
            boolean flag = Check.checkOracleConnectMustInput(odb);
            if(!flag){
                resultMap.put("", "");
                resultMap.put("result", "oracle connection must params Imcomplete:");
                resultMap.put("oracleDataBaseInfo",String.valueOf(odb));
                return resultMap;
            }
            if("1".equals(odb.getSaveFlag())){//如果是保存，进行校验后进入redis
                // boolean flagtoSave = Check.checkOracleConnectToSaveMustInput(odb);//验证保存参数必输性
                // if(!flagtoSave){//不通过
                //     resultMap.put("result", "save failed");
                //     return resultMap;
                // }
                Connection  c1  = AbourDataBase.connectOracle(odb.getIp(),odb.getDbUsrNa(),odb.getPassword(),odb.getPort(),odb.getSid());
                if(c1 != null){
                    resultMap.put("result", "connect successed");
                    synchronized(this) {
                        HashMap<String,String> connectMap = new HashMap<String,String>();
                        connectMap.put("ip",odb.getIp());
                        connectMap.put("password", odb.getPassword());
                        connectMap.put("port", odb.getPort()); 
                        connectMap.put("sid", odb.getSid());
                        connectMap.put("dbUsrNa", odb.getDbUsrNa());
                        connectMap.put("", odb.getServiceName());
                        rt.opsForHash().putAll(odb.getCustId()+":"+odb.getConnectName(),connectMap);
                    }
                }
                c1.close();
                
                
            } else {
                
            }
            
            
            return resultMap;
        } catch (Exception e) {
            resultMap.put("result", "connect failed:"+e);
            return resultMap;
        }
    }
    @RequestMapping("/rr")
    public void man(){

    }
}
