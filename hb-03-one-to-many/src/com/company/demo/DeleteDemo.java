package com.company.demo;


import com.company.hibernate.entity.Instructor;
import com.company.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {

    public static void main(String[] args) {

//        Create session factory
        SessionFactory sessionFactory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Instructor.class)
                        .addAnnotatedClass(InstructorDetail.class)
                        .buildSessionFactory();

//        Create session
        Session session = sessionFactory.getCurrentSession();

        try {

//            Start transaction
            session.beginTransaction();

//            Get instructor by primary key / id
            int theId = 1;
            Instructor tempInstructor =
                    session.get(Instructor.class, theId);

            System.out.println("Found instructor: " + tempInstructor);

//            Delete the instructor
            if (tempInstructor != null) {
                System.out.println("Deleting: " + tempInstructor);

//                Will also delete associated details object
                session.delete(tempInstructor);
            }

//            Commit transaction
            session.getTransaction()
                    .commit();
            System.out.println("Done");

        } finally {
            sessionFactory.close();
        }
    }
}
