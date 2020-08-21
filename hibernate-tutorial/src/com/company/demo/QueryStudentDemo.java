package com.company.demo;


import com.company.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {

    public static void main(String[] args) {

//        Create session factory
        SessionFactory sessionFactory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Student.class)
                        .buildSessionFactory();

//        Create session
        Session session = sessionFactory.getCurrentSession();

        try {
//            Use the session object to Java object
            System.out.println("Creating new student object ...");

//            Start a transaction
            session.beginTransaction();

//            Query the students
            List<Student> students = session.createQuery("from Student").getResultList();

//            Display the students
            displayStudents(students);

//            Query students: lastName = 'Doe'
            students = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();

//            Display the students
            System.out.println("\nStudent with last name Doe");
            displayStudents(students);

//            Query students: lastName = 'Doe' or firstName = 'Daffy'
            students = session.createQuery("from Student s where s.lastName = 'Doe' OR s.firstName = 'Daffy'").getResultList();

//            Display the students
            System.out.println("\nStudent with last name Doe or first name Daffy");
            displayStudents(students);

//            Query students: email Like 'demo.abc'
            students = session.createQuery("from Student s where s.email LIKE '%gmail.abc'").getResultList();

//            Display the students
            System.out.println("\nStudent with email Like gmail.abc");
            displayStudents(students);

//            Commit transaction
            session.getTransaction()
                    .commit();

            System.out.println("Done");

        } finally {
            sessionFactory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
