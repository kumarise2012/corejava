package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class GroupCollectoer {

    public static void main(String[] args){

        List<Employee> empList = new ArrayList<>();

        empList.add(new Employee(50,"RAM",50000.00));
        empList.add(new Employee(40,"RAM",40000.00));
        empList.add(new Employee(30,"RAM",30000.00));
        empList.add(new Employee(10,"RAM",20000.00));
        empList.add(new Employee(20,"RAM",10000.00));

        System.out.println(empList.toString());
        // Convert list to map

        Map<Double , Set<Employee>> empMap=  empList.stream().collect(Collectors.groupingBy(emp -> emp.getSalary(),TreeMap::new,Collectors.toSet()));

        System.out.println(empMap.toString());









    }
}


class Employee{
    int id;
    String name;
    Double salary;

    public Employee(int id ,String name , Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}