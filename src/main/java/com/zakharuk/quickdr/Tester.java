package com.zakharuk.quickdr;

import com.zakharuk.quickdr.entity.ChildPatient;
import com.zakharuk.quickdr.entity.Doctor;
import com.zakharuk.quickdr.entity.Patient;
import com.zakharuk.quickdr.entity.Therapist;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by matvii on 06.02.17.
 */
public class Tester {

    public static void main(String[] args) {
//        ApplicationContext context =
   //             new ClassPathXmlApplicationContext("beans.xml");
   //     Doctor doctor = (Doctor)context.getBean("jane");
    //    Patient patient = (Patient)context.getBean("john");
     //   doctor.examine(patient);

        ChildPatient patient1 = new ChildPatient("Anna", 12);
        Doctor doctor1 = new Therapist("Jane", 221);
        doctor1.examine(patient1);


    }
}
