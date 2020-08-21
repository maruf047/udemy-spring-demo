package com.company.demo;

import com.company.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

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

//            Create 3 student object
            Student tempStudent1 = new Student("Paul", "Wall", "paul@demo.abc");
            Student tempStudent2 = new Student("Mayr", "Public", "mary@demo.abc");
            Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@demo.abc");

//            Start a transaction
            session.beginTransaction();

//            Save the student object
            System.out.println("Saving the student");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

//            Commit transaction
            session.getTransaction()
                    .commit();
            System.out.println("Done");

        } finally {
            sessionFactory.close();
        }
    }
}
