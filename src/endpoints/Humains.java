package endpoints;

import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import helpers.HibernateHelper;
import model.Humain;
import model.Todo;

@Path("/humains")
public class Humains {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Humain> list() {
		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t = null;
		Set<Humain> result = null;
		
		try {
			t = s.beginTransaction();
			
			result = (Set<Humain>) s.createQuery("FROM Humains").list().stream().collect(Collectors.toSet());
			
			t.commit();
		} catch(Exception e) {
			
		} finally {
			s.close();
		}
		
		return result;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Humain create(Humain h) {
		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t = null;
		
		
		try {
			t = s.beginTransaction();
			
			s.save(h);
			t.commit();
		} catch(Exception e) {
			
		} finally {
			s.close();
		}
		
		return h;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{hid}/todos")
	public Todo insert(@PathParam("hid") Integer hid, Todo tx) {
		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t = null;
		Humain h = new Humain();
		h.setId(hid);
	
		try {
			t = s.beginTransaction();
			tx.setH(h);
			s.save(tx);
			t.commit();
		} catch(Exception e) {
			
		} finally {
			s.close();
		}
		
		return tx;
	}
}
