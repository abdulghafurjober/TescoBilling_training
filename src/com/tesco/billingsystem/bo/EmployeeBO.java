/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesco.billingsystem.bo;

import com.tesco.billingsystem.dao.EmployeeDAO;
import com.tesco.billingsystem.gui.EmployeeVO;
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
    
    public void createNewEmployee(EmployeeVO empVO){
        System.out.println("createNewEmployee(EmployeeVO empVO)");
        EmployeeDAO empDAO = new EmployeeDAO();
        empDAO.addEmployee(empVO);
    }
    
    public List<EmployeeVO> displayAllEmployee(){
        System.out.println("displayAllEmployee(EmployeeVO empVO)");
        EmployeeDAO empDAO = new EmployeeDAO();
        List<EmployeeVO> allEmployee = empDAO.displayEmployee();
        
        return allEmployee;
    }
}
