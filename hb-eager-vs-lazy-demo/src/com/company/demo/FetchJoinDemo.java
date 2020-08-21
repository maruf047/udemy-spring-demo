package com.company.demo;


import com.company.hibernate.entity.Course;
import com.company.hibernate.entity.Instructor;
import com.company.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

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

//            Option2: Query with HQL

//            Get the instructor from DB
            int theId = 1;
            Query<Instructor> query =
                    session.createQuery("SELECT i FROM Instructor i "
                                    + "JOIN FETCH i.courseList "
                                    + "WHERE i.id=:theInstructorId",
                            Instructor.class);

//            Set param on query
            query.setParameter("theInstructorId", theId);

//            Execute query and get instructor
            Instructor tempInstructor = query.getSingleResult();

            System.out.println("Instructor: " + tempInstructor);

//            Commit transaction
            session.getTransaction()
                    .commit();

//            Close the session
            session.close();

            System.out.println("Session closed.");

//            Get courses for the instructor
            System.out.println("Courses: " + tempInstructor.getCourseList());

            System.out.println("Done");

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
