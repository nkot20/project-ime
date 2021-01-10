package ime.imebackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name="role")
@ToString
public class role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idrole;
	private String intitule;
	
	/*
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy="role") private Set<user>
	 * user;
	 */

	public int getIdrole() {
		return idrole;
	}

	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public role(int idrole, String intitule) {
		super();
		this.idrole = idrole;
		this.intitule = intitule;
	}

	public role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	

	
	
	/*
	 * public Set<user> getUser() { return user; }
	 * 
	 * public void setUser(Set<user> user) { this.user = user; }
	 */
	
	

}
