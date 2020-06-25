/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesco.billingsystem.dao;

import com.tesco.billingsystem.gui.EmployeeVO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author EliteBook
 */
public class DbDriver {
    
   
    public void closeConnection(Connection conn, CallableStatement cStmt){
        if(cStmt != null){
            try{
            cStmt.close();
            }catch(Exception ec){
                ec.printStackTrace();
            }
        }
         if(conn != null){
            try{
            conn.close();
            }catch(Exception ec){
                ec.printStackTrace();
            }
        }
        
    }
    public void closeConnection(ResultSet rs, Connection conn, CallableStatement cStmt){
         if(cStmt != null){
            try{
            cStmt.close();
            }catch(Exception ec){
                ec.printStackTrace();
            }
        }
         if(conn != null){
            try{
            conn.close();
            }catch(Exception ec){
                ec.printStackTrace();
            }
        }
         if(rs != null){
            try{
            rs.close();
            }catch(Exception ec){
                ec.printStackTrace();
            }
        }
    }

    public void loadDriver() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception ex) {
        }
    }

    public Connection DbConnection() {
        Connection conn=null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Tesco", "sa", "123456");
            
        } catch (Exception ex) {
        }
        
        return conn;
    }
}
