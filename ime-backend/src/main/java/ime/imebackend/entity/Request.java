package ime.imebackend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name="requete")
@ToString
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_requete;
	private String contenu;
	private String annee_aca;
	private Date date_enre;
	private int etat_requete;
	
	@ManyToOne
	@JoinColumn(name = "matricule", nullable = false)
	private Etudiant etudiant;
	
	@ManyToOne
	@JoinColumn(name = "id_categorie", nullable = false)
	private Category categorie;

	public Request(String contenu, String annee_aca, Date date_enre, Etudiant etudiant, Category categorie) {
		super();
		this.contenu = contenu;
		this.annee_aca = annee_aca;
		this.date_enre = date_enre;
		this.etudiant = etudiant;
		this.categorie = categorie;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public int getEtat_requete() {
		return etat_requete;
	}

	public void setEtat_requete(int etat_requete) {
		this.etat_requete = etat_requete;
	}

	public String getAnnee_aca() {
		return annee_aca;
	}

	public void setAnnee_aca(String annee_aca) {
		this.annee_aca = annee_aca;
	}

	public Date getDate_enre() {
		return date_enre;
	}

	public void setDate_enre(Date date_enre) {
		this.date_enre = date_enre;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Category getCategorie() {
		return categorie;
	}

	public void setCategorie(Category categorie) {
		this.categorie = categorie;
	}
	
	
	
	
}
