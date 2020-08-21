package com.company.demo;


import com.company.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteMaryStudentDemo {

    public static void main(String[] args) {

//        Create session factory
        SessionFactory sessionFactory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Instructor.class)
                        .addAnnotatedClass(InstructorDetail.class)
                        .addAnnotatedClass(Course.class)
                        .addAnnotatedClass(Review.class)
                        .addAnnotatedClass(Student.class)
                        .buildSessionFactory();

//        Create session
        Session session = sessionFactory.getCurrentSession();

        try {

//            Start a transaction
            session.beginTransaction();

//            Get the student Mary from DB
            int studentId = 2;
            Student tempStudent = session.get(Student.class, studentId);

            System.out.println("Loaded student: " + tempStudent);
            System.out.println("Courses: " + tempStudent.getCourseList());

//            Delete student
            System.out.println("Deleting student: " + tempStudent);
            session.delete(tempStudent);

//            Commit transaction
            session.getTransaction()
                    .commit();
            System.out.println("Done");

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
