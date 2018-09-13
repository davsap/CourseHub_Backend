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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="Sujets")
@Table(name="Sujets")
public class Sujet {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_sujet")
	private Integer id;
	
	@Column(name="titre")
	private String titre;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_formation")
	private Formation formation;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_sujet")
	private Set<Cours> courses;

	public Sujet() {
		courses = new HashSet<>();
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

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	@Override
	public String toString() {
		return "Sujet [id=" + id + ", titre=" + titre + ", formation=" + formation + "]";
	}
	
	public void addCours(Cours cours) {
		this.courses.add(cours);
	}
	
	
	
	
	
	
	

}
