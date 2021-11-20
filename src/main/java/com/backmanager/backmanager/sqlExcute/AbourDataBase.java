package com.backmanager.backmanager.sqlExcute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbourDataBase {
    
   /**
    * 连接Oracle数据库
    * @param ip 数据库所在地址，本地用localhost
    * @param connectname 连接数据库的用户名
    * @param password 连接数据库的用户名对应的密码
    * @param port  数据库的对外端口号
    * @param oracleSID 数据库实例名称
    * @return 连接实体
    */
    public static Connection connectOracle(String ip,String connectname,String password,String port,String oracleSID){
        try {
            
            String oracleUrl = "jdbc:oracle:thin:@"+ip+":"+port+":"+oracleSID; 
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn=null;
            conn=DriverManager.getConnection(oracleUrl, connectname, password);
            return conn; //返回一个连接
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
