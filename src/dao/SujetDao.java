package dao;

import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.Transaction;

import helpers.HibernateHelper;
import model.Sujet;

public class SujetDao {
	
	public static Stream<Sujet> list(){
		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t= null;
		Stream<Sujet> result = null;
		
	try {
		t = s.beginTransaction();
		//code
		result = s.createQuery("from Sujets").list().stream();
		
		t.commit();
		
	}catch(Exception e) {
		if(t !=null)
			t.rollback();

	} finally {

		s.close();

	}
	return result;
	}
	
	
	public static Sujet create(Sujet sujet) {
		
		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t= null;
		
		
		try {
		t = s.beginTransaction();
		//code
		s.save(sujet);
		
		t.commit();
		
			}catch(Exception e) {
				if(t !=null)
			t.rollback();

			} finally {

				s.close();

			}
	return sujet;

	}
	
	public static Sujet delete(Sujet sujet) {
		
		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t= null;
		
		
		try {
		t = s.beginTransaction();
		//code
		s.delete(sujet);
		
		t.commit();
		
			}catch(Exception e) {
				if(t !=null)
			t.rollback();

			} finally {

				s.close();

			}
	return sujet;

	}

	
}
