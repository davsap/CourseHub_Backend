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

@Path("/formation/sujet")
public class Sujets {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Sujet> sujets(){
		return SujetDao.list().collect(Collectors.toSet()); // elle permet de transformer un stream à un autre type de données
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path ("/{id}")
	public Sujet find(@PathParam("id") Integer identifiant) {
		return SujetDao.list().filter(s -> s.getId() == identifiant).findFirst().get();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Sujet create(Sujet sujet) {
		return SujetDao.create(sujet);
	}

}
