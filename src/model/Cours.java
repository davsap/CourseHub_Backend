package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name="Courses")
@Table(name="Courses")
public class Cours implements Comparable<Cours>{

	public Cours() {}
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_cours")
	private Integer id;
	
	@Column(name="titre")
	private String titre;
	
	@Column(name="description", length = 1000)
	private String description;
	
	@Column(name="contenu", length = 6000)
	private String contenu;
	
	@Column(name="video")
	private String video;
	
	@ManyToOne
	@JoinColumn(name="id_sujet")
	@JsonIgnore
	private Sujet sujet;
	
	@JsonIgnore
	public Sujet getSujet() {
		return sujet;
	}
	@JsonProperty
	public void setSujet(Sujet sujet) {
		this.sujet = sujet;
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

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
	
	@Override
	public String toString() {
		return "Cours [id=" + id + ", titre=" + titre + ", description=" + description + ", contenu=" + contenu
				+ ", video=" + video + ", sujet=" + sujet + "]";
	}
	
	@Override
	public int compareTo(Cours cours) {
		return (this.getId()- cours.getId());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
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
		Cours other = (Cours) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}