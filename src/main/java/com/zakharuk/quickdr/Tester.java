package com.zakharuk.quickdr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by matvii on 06.02.17.
 */
public class Tester {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        Doctor doctor = (Doctor)context.getBean("jane");
        Patient patient = (Patient)context.getBean("john");
        doctor.examine(patient);
    }
}
