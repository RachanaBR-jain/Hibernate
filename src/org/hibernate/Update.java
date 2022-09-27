package org.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.entity.Users;

public class Update {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// Create object of entity class type
			Users user = new Users();
			// Start transaction
			session.beginTransaction();
			// Perform operation
			user = session.get(Users.class, 2);
			// Updating object
			user.setFirstName("Kyathi");

			// Commit the transaction
			session.getTransaction().commit();
			System.out.println(user);

		} finally {
			session.close();
			factory.close();
		}

	}
}
