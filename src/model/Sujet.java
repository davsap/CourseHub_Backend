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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name="Sujets")
@Table(name="Sujets")
public class Sujet implements Comparable<Sujet> {
	
	public Sujet() {
		courses = new HashSet<>();
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_sujet")
	private Integer id;
	
	@Column(name="titre")
	private String titre;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_formation")
	@JsonIgnore
	private Formation formation;
	
	@JsonIgnore
	public Formation getFormation() {
		return formation;
	}
	@JsonProperty
	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="id_sujet")
	private Set<Cours> courses;

	public Set<Cours> getCourses() {
		return courses;
	}
	public void setCourses(Set<Cours> courses) {
		this.courses = courses;
	}
	public void addCours(Cours cours) {
		this.courses.add(cours);
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
	
	@Override
	public String toString() {
		return "Sujet [id=" + id + ", titre=" + titre + ", formation=" + formation + ", courses=" + courses + "]";
	}
	
	
	 @Override
	    public int compareTo(Sujet sujet) {
	        return (int) (this.getId() - sujet.getId());
	    }
	@Override
	public int hashCode() {
		final int prime = 17;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sujet other = (Sujet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	 
}