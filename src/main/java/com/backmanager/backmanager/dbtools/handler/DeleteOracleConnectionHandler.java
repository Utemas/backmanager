package com.backmanager.backmanager.dbtools.handler;

import java.util.HashMap;

import com.backmanager.backmanager.po.OracleDataBaseInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
@Service
/**
    * 删除数据库连接
    * @param odb
    * @return
*/
public class DeleteOracleConnectionHandler {
    @Autowired
    RedisTemplate<String,String> rt;
    HashMap<String,String> hm = new HashMap<String,String>();
    public HashMap<String,String> doMethod(OracleDataBaseInfo odb) {
        hm.clear();
        if("1".equals(odb.getSaveFlag())){//保存的删redis
            boolean deleteResult = rt.delete("oraclce:"+odb.getCustId()+":"+odb.getConnectName());
            if(!deleteResult){
                hm.clear();
                hm.put("retFlg", "false");
                hm.put("retMsg", "delete failed");
            }
            hm.put("retFlg", "true");
            hm.put("retMsg", "delete successed");
            return hm;
        } else {//暂存的删 Oracle
            hm.clear();
            hm.put("retFlg", "false");
            hm.put("retMsg", "this part[delete template] is making");
            return hm;
        }
        
    }
}
