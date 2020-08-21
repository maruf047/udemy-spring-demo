package com.company.demo;


import com.company.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class AddCoursesForMaryDemo {

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

//            Get the student Mary from DB
            int studentId = 2;
            Student tempStudent = session.get(Student.class, studentId);

            System.out.println("Loaded student: " + tempStudent);
            System.out.println("Courses: " + tempStudent.getCourseList());

//            Create more courses
            Course tempCourse1 = new Course("Rubik's cube - How to speed cube");
            Course tempCourse2 = new Course("Atari 2600 - Game Development");

//            Add student Mary to courses
            tempCourse1.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);

//            Save the courses
            session.save(tempCourse1);
            session.save(tempCourse2);


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
