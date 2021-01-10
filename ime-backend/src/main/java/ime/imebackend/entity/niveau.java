package ime.imebackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name="niveau")
@ToString
public class niveau {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idniveau;
	private String intitule;
	public Long getIdniveau() {
		return idniveau;
	}
	public void setIdniveau(Long idniveau) {
		this.idniveau = idniveau;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	
	
}
