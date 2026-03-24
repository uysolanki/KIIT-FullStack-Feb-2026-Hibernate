package com.kiit.lms;

import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kiit.lms.model.ChieMinister;
import com.kiit.lms.model.State;
import com.kiit.lms.model.Student;

public class OneToOneGetDemo 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	//cfg.configure("hibernate.cfg.xml");
    	cfg.configure();
    	SessionFactory factory=cfg.buildSessionFactory();

    	System.out.println(factory.isClosed());  //false
    	
    	Session session1=factory.openSession();
    	Transaction tx=session1.beginTransaction();
    	
    	State st=session1.get(State.class, 1);
    	System.out.println(st.getCapital());
    	
    	System.out.println(st.getChieMinister().getCmname());
    	session1.close();
    	factory.close();
    	
    	
    }
}
