package com.company.demo;


import com.company.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdatedStudentDemo {

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

            int studentId = 1;

//            Get a new session and start transaction
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Retrieve student by id: Primary key
            System.out.println("\nGetting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);
            System.out.println("Get complete: " + myStudent);

            System.out.println("Updating student..");
            myStudent.setFirstName("Scooby");

//            Commit transaction
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Update email for all students
            System.out.println("Update email for all students");

            session.createQuery("update Student set email='foo@gmail.com'")
                    .executeUpdate();

//            Commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            sessionFactory.close();
        }
    }
}
