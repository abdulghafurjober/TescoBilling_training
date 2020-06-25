/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesco.billingsystem.dao;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

/**
 *
 * @author EliteBook
 */
public class DbDriver {
  public String DRIVER;
  public String USERNAME;
  public String PASSWORD;
  public String URL;
  
  public void getProp(){
        Properties prop = new Properties();
        FileInputStream fit = null;
        try{
            fit = new FileInputStream("C:\\Users\\EliteBook\\Desktop\\Avows\\Student Projects\\TescoBillingSystem\\resources\\db.properties");
            prop.load(fit);
            fit.close();//to stop reading the properties
        }catch(Exception ex){ ex.printStackTrace();
        }finally{
        }
        DRIVER = prop.getProperty("DRIVER");
        USERNAME= prop.getProperty("USERNAME");
        PASSWORD=prop.getProperty("PASSWORD");
        URL= prop.getProperty("URL");
  }
    
   
   
    public void closeConnection(Connection conn, CallableStatement cStmt){
        if(cStmt != null){
            try{
            System.out.println("cStmt.close(); executed");
            cStmt.close();
            }catch(Exception ec){
                ec.printStackTrace();
            }
        }
         if(conn != null){
            try{
            System.out.println("conn.close(); executed");
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
                System.out.println("cStmt.close(); executed");
            }catch(Exception ec){
                ec.printStackTrace();
            }
        }
         if(conn != null){
            try{
            conn.close();
            System.out.println("conn.close(); executed");
            }catch(Exception ec){
                ec.printStackTrace();
            }
        }
         if(rs != null){
            try{
            rs.close();
                System.out.println("rs.close(); executed");
            }catch(Exception ec){
                ec.printStackTrace();
            }
        }
    }

    public void loadDriver() {
        getProp();
        try {
            Class.forName(DRIVER);
        } catch (Exception ex) {
        }
    }

    public Connection DbConnection() {
        getProp();
        Connection conn=null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
        } catch (Exception ex) {
        }
        
        return conn;
    }
}
