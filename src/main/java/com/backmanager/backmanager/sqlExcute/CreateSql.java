package com.backmanager.backmanager.sqlExcute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateSql {
    Connection conn=null;
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    public Connection connect(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn=DriverManager.getConnection(url, "scott", "tiger");
            System.out.println("连接成功");
            return conn; //返回一个连接
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
