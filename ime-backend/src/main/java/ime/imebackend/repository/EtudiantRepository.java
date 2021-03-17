package ime.imebackend.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ime.imebackend.entity.Etudiant;

@CrossOrigin("http://localhost:4200")
public interface EtudiantRepository extends JpaRepository<Etudiant, String> {
	
	  @RestResource(path = "email") 
	  Page<Etudiant> findByEmail(@Param("email")String email, Pageable pageable);
	 
	
	public List<Etudiant> findByEtatinscriptionIs(int etat);
	
	public Etudiant findByMatricule(String matricule);
	
}
