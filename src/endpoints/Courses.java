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
import model.Cours;
import model.Sujet;
import dao.CoursDao;
import dao.SujetDao;

@Path("/formations/{id}/sujets/{ids}/courses")
public class Courses {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Cours> courses(@PathParam("ids") Integer identifiant){
		return CoursDao.list().filter(s -> s.getSujet().getId() == identifiant).collect(Collectors.toSet()); // elle permet de transformer un stream à un autre type de données
	}
	
	
	/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path ("/{idc}")
	public Cours find(@PathParam("idc") Integer identifiant) {
		return CoursDao.list().filter(t -> t.getId() == identifiant).findFirst().get();
	}
	*/
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path ("/{idc}")
	public Cours find(@PathParam("id") int id, @PathParam("ids") Integer identifiant,  @PathParam("idc") Integer idcours) {
		return CoursDao.list().filter
				(s -> s.getSujet().getFormation().getId() == id && 
										s.getSujet().getId() == identifiant &&
										s.getId()==idcours).findFirst().get();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Cours create(Cours cours) {
		return CoursDao.create(cours);
	}

}
