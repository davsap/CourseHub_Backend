package model;

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
import javax.persistence.Table;
import javax.persistence.OneToMany;


@Entity(name="Sujets")
@Table(name="Sujets")
public class Sujet {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_sujet")
	private Integer id;
	
	@Column(name="titre")
	private String titre;
	
	@OneToMany(mappedBy = "sujet",cascade = CascadeType.ALL)
	Set<Cours> cours;

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

	public Set<Cours> getCours() {
		return cours;
	}

	public void setCours(Set<Cours> cours) {
		this.cours = cours;
	}
	
public Sujet() {}
}
