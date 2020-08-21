package com.company.demo;


import com.company.hibernate.entity.Course;
import com.company.hibernate.entity.Instructor;
import com.company.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {

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
            System.out.println("Creating new instructor object ...");

//            Create a objects
/*            Instructor tempInstructor =
                    new Instructor("Chad", "Darby", "darby@demo.abc");
            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http://www.demo.com/youtube",
                            "Demoing");*/
            Instructor tempInstructor =
                    new Instructor("Susan", "Public", "susan@demo.abc");
            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http://www.susan.com/youtube",
                            "Gaming");

//            Associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

//            Start a transaction
            session.beginTransaction();

//            Save the objects. This will also save details object using Cascade.
            System.out.println("Saving the objects");
            session.save(tempInstructor);

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
