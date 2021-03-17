package ime.imebackend.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.ToString;

@Entity
@Table(name="user")
@ToString
public class user {
	
	@Id
	private String iduser;
	private String nom;
	private String prenom;
	private String pw;
	
	
	@ManyToOne
	@JoinColumn(name = "idrole", nullable = false)	
	private role role;
	
	public user() {
		
	}

	public user(String iduser, String nom, String prenom, String pw) {
		this.iduser = iduser;
		this.nom = nom;
		this.prenom = prenom;
		this.pw = pw;
	}

	public String getIduser() {
		return iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public role getRole() {
		return role;
	}

	public void setRole(role role) {
		this.role = role;
	}
	



	

	
	

}
