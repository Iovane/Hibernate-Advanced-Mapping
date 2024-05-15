package com.practice.hibernate.demo;

import com.practice.hibernate.demo.entity.Instructor;
import com.practice.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateUserStudentInstructorDemo {


    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Student.class)
                                            .addAnnotatedClass(Instructor.class)
                                            .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {
            // create the object
            Instructor tempInstructor = new Instructor("Maro", "Kako", "maro@practice.com", 10000.0);
            Student tempStudent = new Student("Dato", "Bandzo", "dato@practice.com", "Rogor Gavxdet Skibidi Toilet");

            // start a transaction
            session.beginTransaction();

            // save the object
            System.out.println("Saving the instructor and student...");
            session.save(tempInstructor);
            session.save(tempStudent);

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
