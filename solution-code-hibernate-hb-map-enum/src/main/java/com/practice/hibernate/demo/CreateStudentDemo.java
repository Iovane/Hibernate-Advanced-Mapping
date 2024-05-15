package com.practice.hibernate.demo;

import com.practice.hibernate.demo.entity.Status;
import com.practice.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {


    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Student.class)
                                            .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {
            // create the object
            Student tempStudent1 = new Student("Maro", "Kako", "dato@practice.com", Status.ACTIVE);
            Student tempStudent2 = new Student("Dato", "Bandzo", "dato@practice.com", Status.INACTIVE);

            // start a transaction
            session.beginTransaction();

            // save the object
            System.out.println("Saving the student and images...");
            session.save(tempStudent1);
            session.save(tempStudent2);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            // clean up code
            session.close();
            factory.close();
        }
    }
}
