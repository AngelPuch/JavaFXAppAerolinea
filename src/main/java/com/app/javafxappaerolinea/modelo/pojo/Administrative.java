/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.javafxappaerolinea.modelo.pojo;

import java.util.Date;

/**
 *
 * @author Dell
 */
public class Administrative extends Employee {
    private String department;
    private int workHours;
    
    // Constructor
    public Administrative() {
        super();
    }
    
    public Administrative(int id, String name, String address, Date birthDate, 
                          String gender, double salary, String username, String password,
                          String department, int workHours) {
        super(id, name, address, birthDate, gender, salary, username, password);
        this.department = department;
        this.workHours = workHours;
    }
    
    // Getters and Setters
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public int getWorkHours() {
        return workHours;
    }
    
    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }
}
