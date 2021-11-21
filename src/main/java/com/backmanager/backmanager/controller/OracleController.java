package com.backmanager.backmanager.controller;

import java.util.HashMap;

import com.backmanager.backmanager.dbtools.handler.CreateOracleConnectionHandler;
import com.backmanager.backmanager.dbtools.handler.DeleteOracleConnectionHandler;
import com.backmanager.backmanager.dbtools.handler.QueryOracleConntionHandlder;
import com.backmanager.backmanager.po.OracleDataBaseInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oracle")
public class OracleController {

    HashMap<String,String> resultMap = new HashMap<String,String>();
    
    @Autowired
    CreateOracleConnectionHandler coc;

    @Autowired
    DeleteOracleConnectionHandler doc;

    @Autowired
    QueryOracleConntionHandlder qoc;
    
    /** 
     * 创建数据库连接
     * @param odb
     * @return
     */
    @CrossOrigin
    @RequestMapping("/createConnection")
    public HashMap<String,String> createConnect(OracleDataBaseInfo odb) {
        
        try {
            return coc.doMethod(odb);
        } catch (Exception e) {
            resultMap.put("result", "create conntion failed:"+e);
            return resultMap;
        }
    }
    /**
     * 删除已经保存的连接
     * @param odb
     * @return
     */
    @RequestMapping("/deleteConnection")
    public HashMap<String,String> deleteConnection(OracleDataBaseInfo odb){
        try {
            return doc.doMethod(odb);
        } catch (Exception e) {
            resultMap.put("result", "delete conntion failed:"+e);
            return resultMap;
        }
        
        
    }
    /**
     * 查询连接详情
     * @param odb
     * @return
     */
    @RequestMapping("/queryConntion")
    public HashMap<String, Object> queryOracleConntion(OracleDataBaseInfo odb) {
        try {
            return qoc.doMethod(odb);
        } catch (Exception e) {
            
            return null;
        }
    }
}
