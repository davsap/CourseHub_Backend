
import dao.FormationsDAO;
import dao.UserDAO;
import model.Formation;
import model.User;


public class Main {
	public static void main (String[] args) {
		
		User u = new User();
		u.setEmail("rl@gmail.com");
		u.setPassword("Formation");
		UserDAO.create(u);
		
		
		Formation f = new Formation();
		f.setDescription("bnnnebbbje");
		f.setTitre("block");
		f.setImage("kjkj");
		
		f.addUser(u);
		FormationsDAO.create(f);
		
	FormationsDAO.delete(f);
	UserDAO.delete(u);
	
		UserDAO.list().forEach(System.out::println);
		
	}

}
