package com.practice.hibernate.demo;

import com.practice.hibernate.demo.entity.Address;
import com.practice.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class CreateStudentAddressDemo {


    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Student.class)
                                            .addAnnotatedClass(Address.class)
                                            .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {
            // create the object
            Student tempStudent = new Student("Maro", "Kako", "Maro@practice.com");

            // create the billing address object
            Address billingAddress = new Address("Tamara Mefe Str.", "Old York", "123489");

            // start a transaction
            session.beginTransaction();

            // save the object
            System.out.println("Saving the student and images...");
            tempStudent.setBillingAddress(billingAddress);
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
