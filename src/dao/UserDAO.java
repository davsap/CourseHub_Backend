package dao;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.Transaction;

import helpers.HibernateHelper;
import model.Formation;
import model.User;

public class UserDAO {

	public static Stream<User> list() {
		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t = null;
		Stream<User> result = null;

		try {
			t = s.beginTransaction();
			// code
			result = s.createQuery("FROM Utilisateurs").list().stream();
			t.commit();

		} catch (Exception e) {
			if (t != null)
				t.rollback();

		} finally {

			s.close();

		}
		return result;
	}

	public static User create(User u) {

		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t = null;

		try {
			t = s.beginTransaction();
			// code
			s.save(u);

			t.commit();

		} catch (Exception e) {
			if (t != null)
				t.rollback();

		} finally {

			s.close();

		}
		return u;

	}

	public static User delete(User u) {

		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t = null;

		try {
			t = s.beginTransaction();
			// code
			s.delete(u);

			t.commit();

		} catch (Exception e) {
			if (t != null)
				t.rollback();

		} finally {

			s.close();

		}
		return u;

	}
}
