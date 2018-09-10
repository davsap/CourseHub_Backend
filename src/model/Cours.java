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

@Entity(name="cours")
@Table(name="cours")
public class Cours {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_cours")
	private Integer id;

	@Column(name="titre")
	private String titre;
	
	@Column(name="description")
	private String description;
	
	@Column(name="contenu")
	private String contenu;
	
	@Column(name="video")
	private String video;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_cours")
	@JsonIgnore
	private Sujet sujet;

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

	public Sujet getSujet() {
		return sujet;
	}

	public void setSujet(Sujet sujet) {
		this.sujet = sujet;
	}
	
	
	
}
