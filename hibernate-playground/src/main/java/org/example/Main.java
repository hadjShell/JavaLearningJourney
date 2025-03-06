package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(101, "David", 23);

        SessionFactory sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
//        s.persist(s1);
//
//        s.persist(new Student(102, "John", 20));
//        Student s2 = s.get(Student.class, 102);
//        System.out.println(s2);
//        s2.setName("Jasmine");
//        s.merge(s2);
//        s2 = s.get(Student.class, 102);
//        System.out.println(s2);
        Student s4 = s.get(Student.class, 102);
        if (s4 != null) {
            s.remove(s4);
        }
        else {
            System.out.println("Student not found");
        }
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
}