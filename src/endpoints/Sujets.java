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

import dao.SujetDao;
import model.Sujet;

@Path("/formations/{id}/sujets")
public class Sujets {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Sujet> sujets(@PathParam("id") int id){
		return SujetDao.list().filter(s -> s.getFormation().getId() == id).collect(Collectors.toSet()); // elle permet de transformer un stream à un autre type de données
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path ("/{ids}")
	public Sujet find(@PathParam("id") int id, @PathParam("ids") Integer identifiant) {
		return SujetDao.list().filter(s -> s.getFormation().getId() == id && s.getId() == identifiant).findFirst().get(); // elle permet de transformer un stream à un autre type de données
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Sujet create(Sujet sujet) {
		return SujetDao.create(sujet);
	}

}
