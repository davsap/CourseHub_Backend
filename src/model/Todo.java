package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity(name="Taches")
@Table(name="Taches")
public class Todo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tache")
	private int id;
	
	@Column(name="description")
	private String desc;
	
	@ManyToOne
	@JoinColumn(name="id_humain")
    @JsonIgnore
	private Humain h;
	
	@JsonIgnore
	public Humain getH() {
		return h;
	}

	@JsonProperty
	public void setH(Humain h) {
		this.h = h;
	}

	public Todo() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
