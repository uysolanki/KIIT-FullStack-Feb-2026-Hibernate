package com.kiit.lms;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	//cfg.configure("hibernate.cfg.xml");
    	cfg.configure();
    	SessionFactory factory=cfg.buildSessionFactory();

    	System.out.println(factory.isClosed());  //false

    }
}
