package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="Humains")
@Table(name="Humains")
public class Humain {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_humain")
	private int id;
	
	@Column(name="prenom")
	private String prenom;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="id_humain")
    private Set<Todo> t;
	
	public Set<Todo> getT() {
		return t;
	}

	public void setT(Set<Todo> t) {
		this.t = t;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Humain() {
		
	}
}
