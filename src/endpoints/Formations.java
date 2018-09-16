package endpoints;

import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.CoursDao;
import dao.FormationsDAO;
import dao.SujetDao;
import model.Cours;
import model.Formation;
import model.Sujet;

@Path("/formations")
public class Formations {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Formation> list(){
		
		return FormationsDAO.list().collect(Collectors.toSet()); // elle permet de transformer un stream à un autre type de données
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path ("/{id}")
	public Formation find(@PathParam("id") Integer identifiant) {
		return FormationsDAO.list().filter(t -> t.getId() == identifiant).findFirst().get();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Formation create(Formation f) {
		return FormationsDAO.create(f);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	  public void delete(@PathParam("id") Integer identifiant) {
        Formation formation =FormationsDAO.list().filter(t -> t.getId() == identifiant).findFirst().get();
        FormationsDAO.delete(formation);

    }
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path ("/user/{id}")
	public Formation findByUserID(@PathParam("id") Integer identifiant) {
		return FormationsDAO.list().filter(t -> t.getId() == identifiant).findFirst().get();
	}
	
	// @DELETE
	//@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	//@Path ("/user/{id}")
	//public Formation deleteByUserID(@PathParam("id") Integer identifiant) {
	//	return FormationsDAO.list().filter(t -> t.getId() == identifiant).findFirst().get();
	//}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path ("/{id}/sujets")
	public Set<Sujet> sujets(@PathParam("id") int id){
		return SujetDao.list().filter(s -> s.getFormation().getId() == id).collect(Collectors.toSet()); // elle permet de transformer un stream à un autre type de données
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path ("/{id}/sujets/{ids}")
	public Sujet find(@PathParam("id") int id, @PathParam("ids") Integer identifiant) {
		return SujetDao.list().filter(s -> s.getFormation().getId() == id && s.getId() == identifiant).findFirst().get(); // elle permet de transformer un stream à un autre type de données
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path ("/{id}/sujets")
	public Sujet create (Sujet sujet,@PathParam("id") int id) {
		Formation f = new Formation();
		f.setId(id);
		sujet.setFormation(f);
		return SujetDao.create(sujet);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path ("/{id}/sujets/{ids}/courses/{idc}")
	public Cours find(@PathParam("id") int id, @PathParam("ids") Integer identifiant,@PathParam("idc") Integer coursID) {
		return CoursDao.list().filter
				(c -> c.getId() == coursID).findFirst().get(); // elle permet de transformer un stream à un autre type de données
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path ("/{id}/sujets/{ids}/courses")
	public Set<Cours> courses(@PathParam("id") int id,@PathParam("ids") Integer identifiant){
		return SujetDao.list().filter(c -> c.getId() == identifiant).findFirst().get().getCourses(); // elle permet de transformer un stream à un autre type de données
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path ("/{id}/sujets/{ids}/courses")
	public Cours create (Cours cours,@PathParam("id") int id, @PathParam("ids") Integer identifiant) {
//		Formation f = new Formation();
//		
//		f.setId(id);
		Sujet s = new Sujet();
		s.setId(identifiant);
//		s.setFormation(f);
		cours.setSujet(s);
		return CoursDao.create(cours);
	}
}
