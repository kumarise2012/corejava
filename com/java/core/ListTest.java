package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class ListTest {

    public static void main(String[] args){

    List<Student> studentList = new ArrayList<Student>();

    studentList.add(new Student(100,"RAM","abc@gmail.com"));
    studentList.add(new Student(90,"RAM","abc@gmail.com"));
    studentList.add(new Student(50,"RAM","abc@gmail.com"));
    studentList.add(new Student(80,"SHYAM","abc@gmail.com"));
    studentList.add(new Student(20,"SHYAM","abc@gmail.com"));

    studentList.forEach(System.out :: println);

    System.out.println("===============SIMPLE SORTING USING JAVA 8 =================================");

    List<Student> sortedList = studentList.stream().sorted(Comparator.comparing(Student::getId,Comparator.reverseOrder())).collect(Collectors.toList());

    sortedList.forEach(System.out :: println);

        System.out.println("===============get unique names =================================");

        System.out.println(studentList.stream().collect(Collectors.groupingBy(Student::getName , Collectors.toSet())).toString());

        Map<Integer ,Set<Student>> idMap = studentList.stream().collect(Collectors.groupingBy(Student::getId , Collectors.toSet()));

        System.out.println("====PrintMap====="+ idMap);

        Map<String ,Set<Student>> nameMap = studentList.stream().collect(Collectors.groupingBy(Student::getName , Collectors.toSet()));

        System.out.println("====PrintMap====="+ nameMap);

        Map<String ,List<Student>> chknamelistMap = studentList.stream().collect(Collectors.groupingBy(Student::getName , Collectors.toList()));

        System.out.println("====PrintMap====="+ chknamelistMap);




    }
}


class Student {
    int id;
    String name;
    String email;

    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


