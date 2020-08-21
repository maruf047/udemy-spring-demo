package com.company.demo;


import com.company.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {

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

//            Delete the student
            System.out.println("Deleting student: " + myStudent);
            session.delete(myStudent);

//            Delete student id=2
            System.out.println("Deleting student id=2");
            session.createQuery("delete from Student where id=2")
                    .executeUpdate();

//            Commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            sessionFactory.close();
        }
    }
}
