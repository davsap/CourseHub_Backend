package dao;

import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import helpers.HibernateHelper;
import model.Cours;

public class CoursDao {

	public static Stream<Cours> list(){
		Session session = HibernateHelper.getSessionFactory().openSession();
		Transaction transaction= null;
		Stream<Cours> result = null;
		
	try {
		transaction = session.beginTransaction();
		result = session.createQuery("FROM Courses ORDER BY id_cours ASC").list().stream();
		transaction.commit();
		
	}catch(Exception e) {
		if(transaction !=null)
			transaction.rollback();

	} finally {

		session.close();

	}
	return result;
	}
	
	public static Stream<Cours> list(Integer sujetID){
		Session session = HibernateHelper.getSessionFactory().openSession();
		Transaction transaction= null;
		Stream<Cours> result = null;
		
	try {
		transaction = session.beginTransaction();
		//code
		result = session.createQuery("FROM Courses").list().stream();
	
		
		transaction.commit();
		
	}catch(Exception e) {
		if(transaction !=null)
			transaction.rollback();

	} finally {

		session.close();

	}
	return result;
	}
	public static Cours create(Cours cours) {
		
		Session session = HibernateHelper.getSessionFactory().openSession();
		Transaction transaction= null;
		
		
		try {
		transaction = session.beginTransaction();
		//code
		session.save(cours);
		
		transaction.commit();
		
			}catch(Exception e) {
				if(transaction !=null)
			transaction.rollback();

			} finally {

				session.close();

			}
	return cours;

	}
	
	public static Cours delete(Cours cours) {
		
		Session session = HibernateHelper.getSessionFactory().openSession();
		Transaction transaction= null;
		
		
		try {
		transaction = session.beginTransaction();
		//code
		session.delete(cours);
		
		transaction.commit();
		
			}catch(Exception e) {
				if(transaction !=null)
			transaction.rollback();

			} finally {

				session.close();

			}
	return cours;

	}

}
