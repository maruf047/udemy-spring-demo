package com.company.demo;


import com.company.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndStudentsDemo {

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
//            Use the session object to Java object
            System.out.println("Creating new course objects ...");

//            Start a transaction
            session.beginTransaction();

//            Create a course
            Course tempCourse = new Course("Pacman - How to Score One Million Points");

            System.out.println("Saving course...");
            System.out.println("Course: " + tempCourse);

            session.save(tempCourse);

//            Create the students
            Student tempStudent1 = new Student("John", "Doe", "john@demo.abc");
            Student tempStudent2 = new Student("Mary", "Public", "mary@demo.abc");

//            Add students to course
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

//            Save the students
            System.out.println("Saving students...");
            session.save(tempStudent1);
            session.save(tempStudent2);

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
