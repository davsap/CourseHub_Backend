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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="Utilisateurs")
@Table(name="Utilisateurs")
public class User {
	
	public User() {}
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_utilisateur")
	private Integer id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="email")
	private String email;
	
	@Column(name="pseudo")
	private String pseudo;
	
	@Column(name="situation") 
	private String situation;
	
	@Column(name="password")
	private String password;
	
	@Column(name="ville")
	private String ville;
	
	@Column(name="zip")
	private String zip;
	
	@Column(name="pays")
	private String pays;
	
	private String token;
	
	@ManyToMany(mappedBy="users", fetch=FetchType.EAGER)
	private Set<Formation> formations;
	
	public Set<Formation> getFormations() {
		return formations;
	}
	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}
	public void addFormation (Formation formation) {
	formations.add(formation);
	}
	
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="id_utilisateur")
	private Set<Formation> creations;
	
	public Set<Formation> getCreations() {
		return creations;
	}
	public void setCreations(Set<Formation> creations) {
		this.creations = creations;
	}
	public void addCreation (Formation formation) {
	creations.add(formation);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", pseudo=" + pseudo
				+ ", situation=" + situation + ", password=" + password + ", ville=" + ville + ", zip=" + zip
				+ ", pays=" + pays + ", token=" + token + ", formations=" + formations + ", creations=" + creations
				+ "]";
	}

}