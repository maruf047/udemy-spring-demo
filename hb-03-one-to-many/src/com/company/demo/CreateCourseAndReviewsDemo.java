package com.company.demo;


import com.company.hibernate.entity.Course;
import com.company.hibernate.entity.Instructor;
import com.company.hibernate.entity.InstructorDetail;
import com.company.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndReviewsDemo {

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

//            Create a course
            Course tempCourse = new Course("Pacman - How to Score One Million Points");

//            Add some reviews
            tempCourse.addReview(new Review("Great course!"));
            tempCourse.addReview(new Review("Excellent course!"));
            tempCourse.addReview(new Review("Worst course ever!"));

//            Save the course ... leverage the cascade all

            System.out.println("Saving course...");
            System.out.println("Course: " + tempCourse);
            System.out.println("Reviews: " + tempCourse.getReviewList());

            session.save(tempCourse);

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
