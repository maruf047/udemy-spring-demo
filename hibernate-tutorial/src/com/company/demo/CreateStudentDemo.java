package com.company.demo;


import com.company.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

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

//            Create a student object
            Student tempStudent = new Student("John", "Doe", "john@demo.abc");

//            Start a transaction
            session.beginTransaction();

//            Save the student object
            System.out.println("Saving the student");
            session.save(tempStudent);

//            Commit transaction
            session.getTransaction()
                    .commit();
            System.out.println("Done");

        } finally {
            sessionFactory.close();
        }
    }
}
