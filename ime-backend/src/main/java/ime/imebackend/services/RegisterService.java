package ime.imebackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ime.imebackend.entity.Etudiant;
import ime.imebackend.repository.EtudiantRepository;

@Service
public class RegisterService {
	
	@Autowired
	private EtudiantRepository student;
	
	public Etudiant saveStudent(Etudiant etudiant) {
		return student.save(etudiant);
	}
	
	public Etudiant featchUserByMat(String matricule) {
		return student.findByMatricule(matricule);
	}

}
