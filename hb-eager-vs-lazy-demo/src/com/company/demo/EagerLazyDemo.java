package com.company.demo;


import com.company.hibernate.entity.Course;
import com.company.hibernate.entity.Instructor;
import com.company.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EagerLazyDemo {

    public static void main(String[] args) {

//        Create session factory
        SessionFactory sessionFactory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Instructor.class)
                        .addAnnotatedClass(InstructorDetail.class)
                        .addAnnotatedClass(Course.class)
                        .buildSessionFactory();

//        Create session
        Session session = sessionFactory.getCurrentSession();

        try {
//            Use the session object to Java object
            System.out.println("Get course objects ...");

//            Start a transaction
            session.beginTransaction();

//            Get the instructor from DB
            int theId = 1;
            Instructor tempInstructor =
                    session.get(Instructor.class, theId);

            System.out.println("Instructor: " + tempInstructor);

            System.out.println("Courses: " + tempInstructor.getCourseList());

//            Commit transaction
            session.getTransaction()
                    .commit();

//            Close the session
            session.close();

            System.out.println("Session closed.");
//            Option: Call getter method while the session is open

//            Get courses for the instructor
            System.out.println("Courses: " + tempInstructor.getCourseList());

            System.out.println("Done");

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
