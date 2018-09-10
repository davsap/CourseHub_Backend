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
import dao.CoursDao;


@Path("/formation/courses")
public class Courses {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Cours> cours(){
		return CoursDao.list().collect(Collectors.toSet()); // elle permet de transformer un stream à un autre type de données
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path ("/{id}")
	public Cours find(@PathParam("id") Integer identifiant) {
		return CoursDao.list().filter(t -> t.getId() == identifiant).findFirst().get();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Cours create(Cours cours) {
		return CoursDao.create(cours);
	}

}
