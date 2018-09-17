package dao;

import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
		result = s.createQuery("FROM Formations").list().stream();
		
		t.commit();
		
	}catch(Exception e) {
		if(t !=null)
			t.rollback();

	} finally {

		s.close();

	}
	return result;
	}
	
	public static Stream<Formation> list(Integer userID){
		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t= null;
		Stream<Formation> result = null;
		
	try {
		t = s.beginTransaction();
		//code
		Query query = s.createQuery("FROM Formations f inner join users u where u.id= :userID");
		query.setParameter("userID",userID);
		result = query.list().stream();
		
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
	public static void delete(Integer identifiant) {
		
		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t= null;
		
		
		try {
		t = s.beginTransaction();
		//code
		Query q = s.createQuery("DELETE FROM Formations WHERE id_formation = :id");
		q.setParameter("id", identifiant);
		q.executeUpdate();
		t.commit();
		
			}catch(Exception e) {
				if(t !=null)
			t.rollback();

			} finally {

				s.close();

			}

	}
}	

