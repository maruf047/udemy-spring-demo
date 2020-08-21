package com.company.demo;


import com.company.hibernate.entity.Course;
import com.company.hibernate.entity.Instructor;
import com.company.hibernate.entity.InstructorDetail;
import com.company.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetCourseAndReviewsDemo {

    public static void main(String[] args) {

//        Create session factory
        SessionFactory sessionFactory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Instructor.class)
                        .addAnnotatedClass(InstructorDetail.class)
                        .addAnnotatedClass(Course.class)
                        .addAnnotatedClass(Review.class)
                        .buildSessionFactory();

//        Create session
        Session session = sessionFactory.getCurrentSession();

        try {
//            Use the session object to Java object
            System.out.println("Creating new course objects ...");

//            Start a transaction
            session.beginTransaction();

//            Get the course
            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);

//            Print the course
            System.out.println("Course: " + tempCourse);

//            Print the course reviews
            System.out.println("Reviews: " + tempCourse.getReviewList());

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
