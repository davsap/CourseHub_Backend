package dao;

import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.Transaction;

import helpers.HibernateHelper;
import model.Formation;
import model.User;

public class FormationsDAO {
	public static Stream<Formation> list(){
		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t= null;
		Stream<Formation> result = null;
		
	try {
		t = s.beginTransaction();
		//code
		result = s.createQuery("FROM formations").list().stream();
		
		t.commit();
		
	}catch(Exception e) {
		if(t !=null)
			t.rollback();

	} finally {

		s.close();

	}
	return result;
	}
	
	
	public static Formation create(Formation f) {
		
		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t= null;
		
		
		try {
		t = s.beginTransaction();
		//code
		s.save(f);
		
		t.commit();
		
			}catch(Exception e) {
				if(t !=null)
			t.rollback();

			} finally {

				s.close();

			}
	return f;

	}
	public static Formation delete(Formation f) {
		
		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t= null;
		
		
		try {
		t = s.beginTransaction();
		//code
		s.delete(f);
		
		t.commit();
		
			}catch(Exception e) {
				if(t !=null)
			t.rollback();

			} finally {

				s.close();

			}
	return f;

	}

	
}
