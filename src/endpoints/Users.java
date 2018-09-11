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

import dao.UserDAO;
import model.User;

@Path("/users")
public class Users {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<User> list(){
		
		return UserDAO.list().collect(Collectors.toSet()); // elle permet de transformer un stream à un autre type de données
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path ("/{id}")
	public User find(@PathParam("id") Integer identifiant) {
		return UserDAO.list().filter(t -> t.getId() == identifiant).findFirst().get();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User create(User u) {
		return UserDAO.create(u);
	}
	
}
