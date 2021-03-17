package ime.imebackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ime.imebackend.entity.Email;
import ime.imebackend.entity.Etudiant;
import ime.imebackend.entity.role;
import ime.imebackend.entity.user;
import ime.imebackend.services.LoginService;
import ime.imebackend.services.RegisterService;
import ime.imebackend.services.SendEmailService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("http://localhost:4200")
public class RegisterController {
	
	@Autowired
	private LoginService service;
	@Autowired
	private RegisterService serviceRegister;
	@Autowired
	private SendEmailService sendEmailService; 
	
	//get student register
		@GetMapping("/studentregister")
		public List<Etudiant> getAllStudentRegister() {
			return serviceRegister.feacthAllStudentRegister();
		}
		
		//Get filiere
		/*
		 * @GetMapping("/filiere") public List<filiere> getFiliere() { return
		 * ((JpaRepository<filiere, Long>) filiereRepository).findAll(); }
		 */
		
		//Get niveau
		/*
		 * @GetMapping("/niveaus") public List<niveau> getNiveau() { return
		 * ((JpaRepository<niveau, Long>) niveauRepository).findAll(); }
		 */
		
		//post student
		@PostMapping("/savestudent")
		public Etudiant saveStudents(@RequestBody Etudiant etudiant) throws Exception {
				
				String mat_etu = etudiant.getMatricule();
				if(mat_etu != null && !"".equals(mat_etu)) {
					Etudiant etuObj = serviceRegister.featchUserByMat(mat_etu);
					if(etuObj != null) {
						throw new Exception("Student with "+mat_etu+ "is already exist");
					}
				}
				Etudiant etuObj = null;
				etuObj = serviceRegister.saveEtudiant(etudiant);
				return etuObj;
				
		}
		
		//post email
		@PostMapping("/sendemail")
		public Email send(@Valid @RequestBody Email email) {
			return sendEmailService.sendEmail(email);
		}
		
		//Get student by matricule
		@GetMapping("/student/{matricule}")
		public ResponseEntity<Etudiant> getStudentBymatricule(@Valid @PathVariable String matricule) {
			Etudiant etudiant = serviceRegister.getStudentByMAtricule(matricule);
			return ResponseEntity.ok(etudiant);
		}
		
		//Update student and save user like a suer
		@PutMapping("/studentupdate/{matricule}")
		public ResponseEntity<Etudiant> updateStudentAfterValidation(@PathVariable String matricule, @RequestBody String mat) {
			Etudiant etudiant = serviceRegister.getStudentByMAtricule(matricule);
			etudiant.setEtatinscription(1);
			Etudiant updatedEtudiant = serviceRegister.saveEtudiant(etudiant);
			user user = new user();
			role role = new role(2,"etudiant");
			user.setIduser(etudiant.getMatricule());
			user.setNom(etudiant.getNom());
			user.setPrenom(etudiant.getPrenom());
			user.setPw(etudiant.getPw());
			//user.setRoles(role);
			user userObj = null;
			userObj = service.saveUser(user);
			return ResponseEntity.ok(updatedEtudiant);
		}
		
		@PostMapping("/studentdelete")
		public String deleteStudentInApp(@Valid @RequestBody Etudiant student) {
			//System.out.println("matricule: "+matricule.toString());
			Etudiant etudiant = serviceRegister.getStudentByMAtricule(student.getMatricule());
			serviceRegister.deleteStudent(etudiant);
			return "delete";
		}
		
		

}
