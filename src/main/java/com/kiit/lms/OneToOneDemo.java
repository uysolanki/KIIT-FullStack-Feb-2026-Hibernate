package com.kiit.lms;

import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kiit.lms.model.ChieMinister;
import com.kiit.lms.model.State;
import com.kiit.lms.model.Student;

public class OneToOneDemo 
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
    	
    	ChieMinister cm1=ChieMinister.builder()
    			.cmname("Fadnavis")
    			.age(60)
    			.build();
    	
    	ChieMinister cm2=ChieMinister.builder()
    			.cmname("Patel")
    			.age(65)
    			.build();
    	
    	ChieMinister cm3=ChieMinister.builder()
    			.cmname("Sharma")
    			.age(70)
    			.build();
    	
    	State st1=State.builder()
    			.sname("Mh")
    			.capital("Mumbai")
    			.chieMinister(cm1)
    			.build();
    	
    	State st2=State.builder()
    			.sname("Gj")
    			.capital("Ahmedabad")
    			.chieMinister(cm2)
    			.build();
    	
    	State st3=State.builder()
    			.sname("Rj")
    			.capital("Jaipur")
    			.chieMinister(cm3)
    			.build();
    	
    	session1.save(st1);
    	session1.save(st2);
    	session1.save(st3);
    	tx.commit();
    	session1.close();
    	factory.close();
    	
    	
    }
}
