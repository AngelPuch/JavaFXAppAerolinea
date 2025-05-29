/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.javafxappaerolinea.modelo.dao;

import com.app.javafxappaerolinea.exception.DuplicateResourceException;
import com.app.javafxappaerolinea.exception.ResourceNotFoundException;
import com.app.javafxappaerolinea.modelo.pojo.Employee;
import com.app.javafxappaerolinea.modelo.pojo.Administrative;
import com.app.javafxappaerolinea.modelo.pojo.Assistant;
import com.app.javafxappaerolinea.modelo.pojo.Pilot;
import com.app.javafxappaerolinea.utilidad.JsonUtil;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Dell
 */
public class EmployeeDAO {
    private final JsonUtil<Employee> persistence;
    private static final String FILE_PATH = "data/empleados.json";

    public EmployeeDAO() {
        this.persistence = new JsonUtil<>(FILE_PATH, Employee.class);
    }

    public List<Employee> findAll() throws IOException {
        return persistence.loadAll();
    }

    public Employee findById(int id) throws IOException, ResourceNotFoundException {
        List<Employee> employees = persistence.loadAll();
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Empleado con ID " + id + " no encontrado"));
    }

    public Employee findByUsername(String username) throws IOException, ResourceNotFoundException {
        List<Employee> employees = persistence.loadAll();
        return employees.stream()
                .filter(e -> e.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Empleado con usuario " + username + " no encontrado"));
    }

    public List<Administrative> findAllAdministratives() throws IOException {
        List<Employee> employees = persistence.loadAll();
        return employees.stream()
                .filter(e -> e instanceof Administrative)
                .map(e -> (Administrative) e)
                .collect(Collectors.toList());
    }

    public List<Assistant> findAllAssistants() throws IOException {
        List<Employee> employees = persistence.loadAll();
        return employees.stream()
                .filter(e -> e instanceof Assistant)
                .map(e -> (Assistant) e)
                .collect(Collectors.toList());
    }

    public List<Pilot> findAllPilots() throws IOException {
        List<Employee> employees = persistence.loadAll();
        return employees.stream()
                .filter(e -> e instanceof Pilot)
                .map(e -> (Pilot) e)
                .collect(Collectors.toList());
    }

    public void save(Employee employee) throws IOException, DuplicateResourceException {
        List<Employee> employees = persistence.loadAll();
        if (employees.stream().anyMatch(e -> e.getId() == employee.getId())) {
            throw new DuplicateResourceException("Ya existe un empleado con ID " + employee.getId());
        }
        if (employees.stream().anyMatch(e -> e.getUsername().equals(employee.getUsername()))) {
            throw new DuplicateResourceException("Ya existe un empleado con usuario " + employee.getUsername());
        }
        persistence.save(employee);
    }

    public void update(Employee employee) throws IOException, ResourceNotFoundException {
        List<Employee> employees = persistence.loadAll();
        if (employees.stream().noneMatch(e -> e.getId() == employee.getId())) {
            throw new ResourceNotFoundException("Empleado con ID " + employee.getId() + " no encontrado");
        }
        persistence.update(employee, e -> e.getId() == employee.getId());
    }

    public void delete(int id) throws IOException, ResourceNotFoundException {
        List<Employee> employees = persistence.loadAll();
        if (employees.stream().noneMatch(e -> e.getId() == id)) {
            throw new ResourceNotFoundException("Empleado con ID " + id + " no encontrado");
        }
        persistence.delete(e -> e.getId() == id);
    }
}
