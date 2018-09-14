package endpoints;

import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import helpers.HibernateHelper;
import model.Todo;

@Path("/todos")
public class Todos {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Todo> list() {
		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t = null;
		Set<Todo> result = null;
		
		try {
			t = s.beginTransaction();
			
			result = (Set<Todo>) s.createQuery("FROM Taches").list().stream().collect(Collectors.toSet());
			
			t.commit();
		} catch(Exception e) {
			
		} finally {
			s.close();
		}
		
		return result;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Todo create(Todo h) {
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
}
