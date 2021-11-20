package com.backmanager.backmanager.dbtools.handler;

import java.util.HashMap;

import com.backmanager.backmanager.check.Check;
import com.backmanager.backmanager.po.OracleDataBaseInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class QueryOracleConntionHandlder {
    @Autowired
    RedisTemplate<String,String> rt;

    @Autowired
    RedisTemplate<Object,Object> rto;

    public HashMap<String,Object> doMethod(OracleDataBaseInfo odb) {
        HashMap<String,Object> odbMap = new HashMap<String,Object>();
        if(!Check.checkMustInput(odb.getConnectName())){
            odbMap.put("retFlg", "false");
            odbMap.put("retMsg", "连接名称没有接受到");
            odbMap.put("odb",odb);
            return odbMap;
        }
        if(!Check.checkMustInput(odb.getCustId())){
            odbMap.put("retFlg", "false");
            odbMap.put("retMsg", "客户编号没有接受到");
            odbMap.put("odb",odb);
            return odbMap;
        }
        if("1".equals(odb.getSaveFlag())){ //保存的数据库连接信息在redis里
            synchronized(this) {
                String password = String.valueOf(rt.opsForHash().get("oracle:"+odb.getCustId()+":"+odb.getConnectName(), "password"));
                String dbUsrNa = String.valueOf(rt.opsForHash().get("oracle:"+odb.getCustId()+":"+odb.getConnectName(), "dbUsrNa"));
                String port = String.valueOf(rt.opsForHash().get("oracle:"+odb.getCustId()+":"+odb.getConnectName(), "port"));
                String ip = String.valueOf(rt.opsForHash().get("oracle:"+odb.getCustId()+":"+odb.getConnectName(), "ip"));
                String sid = String.valueOf(rt.opsForHash().get("oracle:"+odb.getCustId()+":"+odb.getConnectName(), "sid"));
                String serviceName = String.valueOf(rt.opsForHash().get("oracle:"+odb.getCustId()+":"+odb.getConnectName(), "serviceName"));
                odb.setPassword(password);
                odb.setDbUsrNa(dbUsrNa);
                odb.setIp(ip);
                odb.setPort(port);
                odb.setSid(sid);
                odb.setServiceName(serviceName);
                odbMap.put("odb", odb);
                return odbMap;
            }
        } else {
            odbMap.clear();
            odbMap.put("retFlg", "false");
            odbMap.put("retMsg", "this part[query template] is making");
            return odbMap;
        }
        
        
    }
}
