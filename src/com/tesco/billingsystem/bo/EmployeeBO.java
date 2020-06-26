/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesco.billingsystem.bo;

import com.tesco.billingsystem.dao.EmployeeDAO;
import com.tesco.billingsystem.gui.EmployeeVO;
import com.tesco.billingsystem.bo.ExtraException;

import java.util.List;

/**
 *vo
 * @author EliteBook
 */
public class EmployeeBO { 
    public void authenticate(EmployeeVO empVO){
        System.out.println("authenticate(EmployeeVO empVO)");
        EmployeeDAO empDAO = new EmployeeDAO();
        empDAO.getEmployee(empVO);
    }
    
    public void removeEmployee(EmployeeVO empVO){
        System.out.println("removeEmployee(EmployeeVO empVO)");
        EmployeeDAO empDAO = new EmployeeDAO();
        empDAO.deleteEmployee(empVO);
    }
    
    public void updateEmployeeName(EmployeeVO empVO){
        System.out.println("updateEmployeeName(EmployeeVO empVO)");
        EmployeeDAO empDAO = new EmployeeDAO();
        empDAO.alterEmployee(empVO);
    }
     
    public void createNewEmployee(EmployeeVO empVO) throws ExtraException{
        EmployeeDAO empDAO = new EmployeeDAO();
        List<EmployeeVO> allEmployee = empDAO.displayEmployee(); 
        //empDAO.addEmployee(empVO);
        if(allEmployee.size()<10){
            System.out.println("createNewEmployee(EmployeeVO empVO)");
            empDAO.addEmployee(empVO);
            System.out.println(allEmployee.size());   
        }else{
            System.out.println("More than necessary");
            throw new ExtraException("Reach limit");
        }   
    }
    
    public List<EmployeeVO> displayAllEmployee(){
        System.out.println("displayAllEmployee(EmployeeVO empVO)");
        EmployeeDAO empDAO = new EmployeeDAO();
        List<EmployeeVO> allEmployee = empDAO.displayEmployee();
        
        return allEmployee;
    }
    /*
    public boolean excessEmployee(int count) throws ExtraException{
        boolean flag = false;
        if(count >= 20){
            
        }
        else{
            System.out.println("Added employee");
            flag = true;
        }
        
        return flag;
    }*/
}
