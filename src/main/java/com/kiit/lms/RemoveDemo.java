package com.kiit.lms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kiit.lms.model.Student;

public class RemoveDemo 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	//cfg.configure("hibernate.cfg.xml");
    	cfg.configure();
    	SessionFactory factory=cfg.buildSessionFactory();

    	System.out.println(factory.isClosed());  //false
    	
    	Session session1=factory.openSession();		//blank sessions
    	Transaction tx=session1.beginTransaction();
    	
    	Student stud1=session1.get(Student.class, 3);	
    	session1.remove(stud1); 
    	tx.commit();
    	
    	session1.close();
    	factory.close();

    }
}
