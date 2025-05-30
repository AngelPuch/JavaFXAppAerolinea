/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.javafxappaerolinea.modelo.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Assistant extends Employee {
    private String email;
    private Date birthDate;
    private int assistanceHours;
    private String name;
    private int numberOfLanguages;
    private List<Flight> flights;
    
    // Constructor
    public Assistant() {
        super();
        this.flights = new ArrayList<>();
    }
    
    public Assistant(int id, String name, String address, Date birthDate, 
                     String gender, double salary, String username, String password,
                     String email, int assistanceHours, int numberOfLanguages) {
        super(id, name, address, birthDate, gender, salary, username, password);
        this.email = email;
        this.birthDate = birthDate;
        this.assistanceHours = assistanceHours;
        this.name = name;
        this.numberOfLanguages = numberOfLanguages;
        this.flights = new ArrayList<>();
    }
    
    // Getters and Setters
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public Date getBirthDate() {
        return birthDate;
    }
    
    @Override
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    public int getAssistanceHours() {
        return assistanceHours;
    }
    
    public void setAssistanceHours(int assistanceHours) {
        this.assistanceHours = assistanceHours;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    public int getNumberOfLanguages() {
        return numberOfLanguages;
    }
    
    public void setNumberOfLanguages(int numberOfLanguages) {
        this.numberOfLanguages = numberOfLanguages;
    }
    
    public List<Flight> getFlights() {
        return flights;
    }
    
    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
    
    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }
}
