package com.company.demo;


import com.company.hibernate.entity.Course;
import com.company.hibernate.entity.Instructor;
import com.company.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesDemo {

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
            System.out.println("Creating new course objects ...");

//            Start a transaction
            session.beginTransaction();

//            Get the instructor from DB
            int theId = 1;
            Instructor tempInstructor =
                    session.get(Instructor.class, theId);

//            Create some courses
            Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
            Course tempCourse2 = new Course("The Pinball Masterclass");

//            Add courses to instructor
            tempInstructor.addCourse(tempCourse1);
            tempInstructor.addCourse(tempCourse2);

//            Save the courses.
            System.out.println("Saving the courses");
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
