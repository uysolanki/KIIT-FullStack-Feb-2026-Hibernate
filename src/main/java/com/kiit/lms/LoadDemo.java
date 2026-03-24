package com.kiit.lms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kiit.lms.model.Student;

public class LoadDemo 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	//cfg.configure("hibernate.cfg.xml");
    	cfg.configure();
    	SessionFactory factory=cfg.buildSessionFactory();

    	System.out.println(factory.isClosed());  		//false
    	
    	Session session1=factory.openSession();			//blank sessions
    	Session session2=factory.openSession();
    	
    	Student stud1=session1.load(Student.class, 1);	//not in the cache DB will be queried YES	
    	System.out.println(stud1.getRno());
    	
    	System.out.println("--------------");
    	
    	System.out.println(stud1.getSname());
    	
    	Student stud2=session1.load(Student.class, 1);
    	System.out.println(stud2.getSname());
    	session1.close();
    	factory.close();
    }
}
