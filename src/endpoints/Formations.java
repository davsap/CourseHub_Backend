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

import dao.FormationsDAO;
import model.Formation;

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
	
}
