package com.company.demo;


import com.company.hibernate.entity.Instructor;
import com.company.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDetailDemo {

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

//            Get the instructor detail object
            int theId = 3;
            InstructorDetail tempInstructorDetail =
                    session.get(InstructorDetail.class, theId);

//            Print the instructor detail
            System.out.println("Temp Instructor Detail: " + tempInstructorDetail);

//            Print the associated instructor
            System.out.println("Associated Instructor: " + tempInstructorDetail.getInstructor());

//            Delete the instructor detail
            System.out.println("Deleting Instructor Detail: " + tempInstructorDetail);

//            Remove the associated reference - Break bi-directional link
            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(tempInstructorDetail);

//            Commit transaction
            session.getTransaction()
                    .commit();
            System.out.println("Done");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
