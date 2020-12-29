package ime.imebackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ime.imebackend.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
	/*
	 * @RestResource(path = "email") Page<Etudiant> findByEmail(@Param("email")
	 * String email, Pageable pageable);
	 */
	
	public List<Etudiant> findByEtatinscriptionIs(int etat);
	
	public Etudiant findByMatricule(String matricule);
}
