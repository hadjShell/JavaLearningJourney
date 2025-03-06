package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private int studentNo;
    private String name;
    private int age;

    public Student() {}

    public Student(int no, String name, int age) {
        this.studentNo = no;
        this.name = name;
        this.age = age;
    }
    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNo=" + studentNo +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
