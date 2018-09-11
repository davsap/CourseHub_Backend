package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="formations")
@Table(name="formation")
public class Formation {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_formations")
	private Integer id;
	
	@Column(name="titre")
	private String titre;
	
	@Column(name="description")
	private String description;
	
	@Column(name="date")
	private String date;
	
	@Column(name="image")
	private String image;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "formations_users", 
		joinColumns = { @JoinColumn(name = "id_formation") },
		inverseJoinColumns = { @JoinColumn(name = "id_utilisateur") })
	private Set<User> users;
	
	public Formation() {
		this.users=new HashSet<>();
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_utilisateur")
	private User user;
	
	
	public void addUser (User us) {
	users.add(us);
	
}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "Formation [id=" + id + ", titre=" + titre + ", description=" + description + ", date=" + date
				+ ", image=" + image + ", users=" + users + "]";
	}

}
