package ime.imebackend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name="etudiant")
@ToString
public class Etudiant {

	@Id
	private String matricule;
	private String nom; 
	private String prenom;
	private Date datenais;
	private String lieu;
	private String email;
	private int tel;
	private String pw;
	
	@Column(name="etatinscription")
	private int etatinscription;
	private String anneeaca;
	
	
	@ManyToOne
	@JoinColumn(name = "idfiliere", nullable = false)
	private filiere filiere;
	
	@ManyToOne
	@JoinColumn(name = "idniveau", nullable = false)
	private niveau niveau;

	public String getMatricule() {
		return matricule;
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


	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}



	public Date getDatenais() {
		return datenais;
	}

	public void setDatenais(Date datenais) {
		this.datenais = datenais;
	}

	public String getAnneeaca() {
		return anneeaca;
	}

	public void setAnneeaca(String anneeaca) {
		this.anneeaca = anneeaca;
	}

	public filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(filiere filiere) {
		this.filiere = filiere;
	}

	public niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(niveau niveau) {
		this.niveau = niveau;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public int getEtatinscription() {
		return etatinscription;
	}

	public void setEtatinscription(int etatinscription) {
		this.etatinscription = etatinscription;
	}

	public Etudiant(String matricule, String nom, String prenom, Date datenais, String lieu, String email, int tel,
			String pw, int etatinscription, String anneeaca, ime.imebackend.entity.filiere filiere,
			ime.imebackend.entity.niveau niveau) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.datenais = datenais;
		this.lieu = lieu;
		this.email = email;
		this.tel = tel;
		this.pw = pw;
		this.etatinscription = etatinscription;
		this.anneeaca = anneeaca;
		this.filiere = filiere;
		this.niveau = niveau;
	}

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
