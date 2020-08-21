package com.company.demo;


import com.company.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {

    public static void main(String[] args) {

//        Create session factory
        SessionFactory sessionFactory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Student.class)
                        .buildSessionFactory();

//        Create session
        Session session = sessionFactory.getCurrentSession();

        try {
//            Use the session object to Java object
            System.out.println("Creating new student object ...");

//            Create a student object
            Student tempStudent = new Student("Daffy", "Duck", "daffy@demo.abc");

//            Start a transaction
            session.beginTransaction();

//            Save the student object
            System.out.println("Saving the student");
            System.out.println(tempStudent);
            session.save(tempStudent);

//            Commit transaction
            session.getTransaction()
                    .commit();

//            Find out student1's id: Primary key
            System.out.println("Saved student: Gen id: " + tempStudent.getId());

//            Get a new session and start transaction
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Retrieve student by id: Primary key
            System.out.println("\nGetting student with id: " + tempStudent.getId());
            Student myStudent = session.get(Student.class, tempStudent.getId());
            System.out.println("Get complete: " + myStudent);

//            Commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            sessionFactory.close();
        }
    }
}
