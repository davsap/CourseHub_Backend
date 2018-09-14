package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name="Formations")
@Table(name="Formations")
public class Formation {
	
	public Formation() {
		this.users = new HashSet<>();
		this.sujets = new HashSet<>();
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_formation")
	private Integer id;
	
	@Column(name="titre")
	private String titre;
	
	@Column(name="description")
	private String description;
	
	@Column(name="date")
	private String date;
	
	@Column(name="image")
	private String image;
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "formations_users", 
		joinColumns = { @JoinColumn(name = "id_formation") },
		inverseJoinColumns = { @JoinColumn(name = "id_utilisateur") })
	private Set<User> users;
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public void addUser (User us) {
	users.add(us);
	}
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="id_formation")
	private Set<Sujet> sujets;
	
	public Set<Sujet> getSujets() {
		return sujets;
	}
	public void setSujets(Set<Sujet> sujets) {
		this.sujets = sujets;
	}
	public void addSujet(Sujet sujet) {
		this.sujets.add(sujet);
	}
	
	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	@JsonIgnore
	private User user;
	
	@JsonIgnore
	public User getUser() {
		return user;
	}
	@JsonProperty
	public void setUser(User user) {
		this.user = user;
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
				+ ", image=" + image + ", users=" + users + ", sujets=" + sujets + ", user=" + user + "]";
	}
	
}