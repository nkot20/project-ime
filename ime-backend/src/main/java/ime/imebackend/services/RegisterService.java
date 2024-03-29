package ime.imebackend.services;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ime.imebackend.entity.Etudiant;
import ime.imebackend.repository.EtudiantRepository;

@Service
public class RegisterService {
	static Scanner Lire=new Scanner(System.in);
	
	@Autowired
	private EtudiantRepository studentrepo;
	
	/*
	 * public Etudiant saveStudent(Etudiant etudiant) {
	 * System.out.println(etudiant.getNom()); return studentrepo.save(etudiant); }
	 */
	
	public Etudiant featchUserByMat(String matricule) {
		System.out.println(matricule);
		return studentrepo.findByMatricule(matricule);
	}
	
	public List<Etudiant> feacthAllStudentRegister() {
		return studentrepo.findByEtatinscriptionIs(0);
	}
	
	public Etudiant saveEtudiant(Etudiant etudiant) {
		return studentrepo.save(etudiant);
	}
	
	public Etudiant getStudentByMAtricule(String matricule) {
		return studentrepo.findByMatricule(matricule);
	}
	
	public void deleteStudent(Etudiant student) {
		studentrepo.delete(student);
	}

}
