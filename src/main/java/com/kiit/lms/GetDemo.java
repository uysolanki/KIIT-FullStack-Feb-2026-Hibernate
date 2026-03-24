package com.kiit.lms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kiit.lms.model.Student;

public class GetDemo 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	//cfg.configure("hibernate.cfg.xml");
    	cfg.configure();
    	SessionFactory factory=cfg.buildSessionFactory();

    	System.out.println(factory.isClosed());  //false
    	
    	Session session1=factory.openSession();		//blank sessions
    	Session session2=factory.openSession();
    	
    	Student stud1=session1.get(Student.class, 1);	//not in the cache DB will be queried YES	
    	System.out.println(stud1);
    	
    	Student stud2=session2.get(Student.class, 1);	//not in the session 2 cache DB it will search session cache will query DB
    	System.out.println(stud2);
    	
    	Student stud3=session2.get(Student.class, 1);	//not in the session 2 cache DB it will search session cache will query DB
    	System.out.println(stud2);
    	
    	System.out.println(stud2==stud3);   			//true
    	
    	Student stud4=session1.get(Student.class, 77);	//not in the cache DB will be queried YES	
    	System.out.println(stud4);
    	session1.close();
    	factory.close();

    }
}
