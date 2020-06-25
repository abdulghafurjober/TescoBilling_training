/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesco.billingsystem.dao;

import com.tesco.billingsystem.gui.EmployeeVO;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author hanabi
 */
//import com.sun.jdi.connect.spi.Connection;
public class EmployeeDAO extends DbDriver{
    
    public void getEmployee(EmployeeVO empVO){
        ResultSet rs=null;
        CallableStatement cStmt=null;
        Connection conn=null;
        System.out.println(empVO.getIcno());
        System.out.println(empVO.getPwd());
        try{
            loadDriver();
            conn = DbConnection();
            
            cStmt = conn.prepareCall("{call dbo.loginEmployee(?,?)}");
            cStmt.setString(1, empVO.getIcno());
            cStmt.setString(2, empVO.getPwd());
            rs = cStmt.executeQuery(); 
            System.out.println("Successfully executed SP:LoginEmployee");
           
            if(rs.next()==true){
                System.out.println("Succesfull Authentication");
                empVO.setLoginFlag(true);
                String name = rs.getString("name");//column name
                empVO.setName(name);
                String icno = rs.getString("icno");
                empVO.setIcno(icno);
            }else{
                 System.out.println("Failed Authentication");
                empVO.setLoginFlag(false);
            }
            
        }catch (Exception exGE){
            System.out.println("Problem with getEmployee method");
            exGE.printStackTrace();
        }finally{
            closeConnection(rs,conn,cStmt);
        }
    }
    public void addEmployee(EmployeeVO empVO){
        System.out.println("addEmployee Method");
        System.out.print(empVO.getIcno());
        System.out.print(empVO.getName());
        System.out.print(empVO.getPwd());
        CallableStatement cStmt=null;
        Connection conn=null;
        try{
           
            loadDriver();
            conn = DbConnection();
            
            cStmt = conn.prepareCall("{call dbo.addEmployee(?,?,?)}");
            cStmt.setString(1, empVO.getIcno());
            cStmt.setString(2, empVO.getPwd());
            cStmt.setString(3, empVO.getName());
            
            cStmt.execute();
            System.out.println("Successfully executed SP:addEmployee");
            
        }catch(Exception exAE){
            System.out.println("Problem with addEmployee method");
            exAE.printStackTrace();
        }finally{
            closeConnection(conn,cStmt);
        }
    }
    public void deleteEmployee(EmployeeVO empVO){
        System.out.println("deleteEmployee Method");
        System.out.println(empVO.getIcno());
        System.out.println(empVO.getPwd());
        Connection conn=null;
        CallableStatement cStmt=null;
        try{
            loadDriver();
            conn = DbConnection();
            
            cStmt = conn.prepareCall("{call dbo.deleteEmployee(?)}");
            System.out.println("3- SP ok");
            cStmt.setString(1, empVO.getIcno());
            //cStmt.setSt= cStmt.executeQuery()ring(2, empVO.getPwd());
            cStmt.execute();
            System.out.println("Successfully executed SP:deleteEmployee");
            
        }catch(Exception exDE){
            System.out.println("Problem with deleteEmployee method");
            exDE.printStackTrace();
        }finally{
            closeConnection(conn,cStmt);
        }
    }
    public void alterEmployee(EmployeeVO empVO){
        System.out.println("updateEmployee Method");
        System.out.println(empVO.getIcno());
        System.out.println(empVO.getPwd());
        System.out.println(empVO.getName());
        //ResultSet rs=null;
        CallableStatement cStmt=null;
        Connection conn=null;
        try{
            loadDriver();
            conn = DbConnection();
            
            cStmt = conn.prepareCall("{call dbo.updateEmployee(?,?,?)}");
            cStmt.setString(1, empVO.getIcno());
            cStmt.setString(2, empVO.getPwd());
            cStmt.setString(3, empVO.getName());
            
            cStmt.execute();
            System.out.println("Successfully executed SP:alterEmployee");
        }catch(Exception exUE){
            System.out.println("Problem with updateEmployee method");
            exUE.printStackTrace();
        }
    }
    public List <EmployeeVO> displayEmployee(){
        ArrayList <EmployeeVO> arrayEmployee = new ArrayList<>();
        ResultSet rs=null;
        CallableStatement cStmt=null;
        Connection conn=null;
        try{
            
            loadDriver();
            conn = DbConnection();
            cStmt = conn.prepareCall("{call dbo.displayEmployee()}");
            rs = cStmt.executeQuery();
            
            while(rs.next()){
                //create new object called empVO
                EmployeeVO empVO = new EmployeeVO();
                //setting new object, it is called object relational mapping
                empVO.setIcno(rs.getString(1));
                empVO.setPwd(rs.getString(2));
                empVO.setName(rs.getString(3));
                //we are going to put all the newly ctetaed object into the array list
                arrayEmployee.add(empVO);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            closeConnection(rs,conn,cStmt);
        }
        return arrayEmployee;
    }
}