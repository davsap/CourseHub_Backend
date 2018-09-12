package endpoints;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import dao.UserDAO;
import model.User;

@Path("/users")
public class Users {
	@Context
	HttpServletResponse response;

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
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login")
	public User login(User u) throws IOException {
		User user = null;
		Optional<User> result;
		try {

			result = UserDAO.findByLoginInfo(u.getPseudo(), u.getPassword());
			
			if(result.isPresent()) {
				user = result.get();
				
				response.addHeader("token", createToken(user.getId()));
			}else {
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
			}
		}
		catch(Exception ex) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		
		}
		 return user;
	}
	
	private String createToken(Integer id) throws NoSuchAlgorithmException {
		// Create a SHA1 token based on userID
		MessageDigest sha1 = MessageDigest.getInstance("SHA1");
		sha1.reset();
		sha1.update(id.toString().getBytes());	
		return sha1.digest().toString();
	}
	
	
}
