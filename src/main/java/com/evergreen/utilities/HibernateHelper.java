package com.evergreen.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {
	private static SessionFactory sessionFactory; 	// SessionFactory is Thread Safe
	static {
		if (sessionFactory == null) {
			try {
				Configuration config = new Configuration();
				config.configure("hibernate.cfg.xml");
				sessionFactory = config.buildSessionFactory();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Utility method to return SessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
