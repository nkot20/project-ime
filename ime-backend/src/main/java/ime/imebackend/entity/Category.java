package ime.imebackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name="categorie")
@ToString
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_categorie;
	private String intitule;

	public Long getId_categorie() {
		return id_categorie;
	}

	public void setId_categorie(Long id_categorie) {
		this.id_categorie = id_categorie;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	
	
	

}
