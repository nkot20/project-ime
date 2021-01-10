package ime.imebackend.controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ime.imebackend.services.LoginService;
import ime.imebackend.services.RegisterService;
import ime.imebackend.services.SendEmailService;
import ime.imebackend.entity.Email;
import ime.imebackend.entity.Etudiant;
import ime.imebackend.entity.filiere;
import ime.imebackend.entity.niveau;
import ime.imebackend.entity.role;
import ime.imebackend.entity.user;
import ime.imebackend.repository.EtudiantRepository;
import ime.imebackend.repository.FiliereRepository;
import ime.imebackend.repository.NiveauRepository;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("http://localhost:4200")
public class Controller {
	
	static Scanner Lire=new Scanner(System.in);
	@Autowired
	private LoginService service;
	@Autowired
	private EtudiantRepository EtudiantRepository;
	@Autowired
	private RegisterService serviceRegister;
	@Autowired
	private FiliereRepository filiereRepository;
	@Autowired
	private NiveauRepository niveauRepository;
	@Autowired
	private SendEmailService sendEmailService; 
	
	//register
	@PostMapping("/registeruser")
	public user registerUser(@RequestBody user user) throws Exception {
		String IdUser = user.getIduser();
		if(IdUser != null && !"".equals(IdUser)) {
			user userObj = service.featchUserById(IdUser);
			if(userObj != null) {
				throw new Exception("user with "+IdUser+ "is already exist");
			}
		}
		user userObj = null;
		userObj = service.saveUser(user);
		return userObj;
	}
	
	//login
	@PostMapping("/login")
	public user loginUser(@RequestBody user user) throws Exception {
		
		String idUser = user.getIduser();
		String pw = user.getPw();
		user userObj = null;
		System.out.println(""+idUser+"");
		if(idUser != null && pw != null) {
			userObj = service.featchUserByIdAndPw(idUser, pw);
		}
		
		if(userObj == null) {
			throw new Exception("User is not exist");
		}
		
		return userObj;
		
	}
	
	//get user
	@PostMapping("/searchUser")
	public user searchUser(@RequestBody user user) throws Exception {
		String iduser = user.getIduser();
		user userObj = null;
		if(iduser != null) {
			userObj = service.featchUserById(iduser);
		}
		else {
			throw new Exception("User is not exist"+iduser);
		}
		return userObj;
	}
	
	//get student register
	@GetMapping("/studentregister")
	public List<Etudiant> getAllStudentRegister() {
		return EtudiantRepository.findByEtatinscriptionIs(0);
	}
	
	//Get filiere
	@GetMapping("/filiere")
	public List<filiere> getFiliere() {
		return ((JpaRepository<filiere, Long>) filiereRepository).findAll();
	}
	
	//Get niveau
	/*
	 * @GetMapping("/niveaus") public List<niveau> getNiveau() { return
	 * ((JpaRepository<niveau, Long>) niveauRepository).findAll(); }
	 */
	
	//post student
	@PostMapping("/savestudent")
	public Etudiant saveStudents(@RequestBody Etudiant etudiant) throws Exception {
			
			String mat_etu = etudiant.getMatricule();
			Date date = etudiant.getDatenais();
			System.out.println(""+mat_etu+"");
			System.out.println(""+date+"");
			if(mat_etu != null && !"".equals(mat_etu)) {
				Etudiant etuObj = serviceRegister.featchUserByMat(mat_etu);
				if(etuObj != null) {
					throw new Exception("Student with "+mat_etu+ "is already exist");
				}
			}
			Etudiant etuObj = null;
			etuObj = EtudiantRepository.save(etudiant);
			return etuObj;
			
	}
	
	//post email
	@PostMapping("/sendemail")
	public Email send(@RequestBody Email email) {
		return sendEmailService.sendEmail(email);
	}
	
	//Get student by matricule
	@GetMapping("/student/{matricule}")
	public ResponseEntity<Etudiant> getStudentBymatricule(@PathVariable String matricule) {
		System.out.println(matricule);
		Etudiant etudiant = EtudiantRepository.findByMatricule(matricule);
		return ResponseEntity.ok(etudiant);
	}
	
	//Update student and save user like a suer
	@PutMapping("/studentupdate/{matricule}")
	public ResponseEntity<Etudiant> updateStudentAfterValidation(@PathVariable String matricule, @RequestBody String mat) {
		Etudiant etudiant = EtudiantRepository.findByMatricule(matricule);
		etudiant.setEtatinscription(1);
		Etudiant updatedEtudiant = EtudiantRepository.save(etudiant);
		user user = new user();
		role role = new role(2,"etudiant");
		user.setIduser(etudiant.getMatricule());
		user.setNom(etudiant.getNom());
		user.setPrenom(etudiant.getPrenom());
		user.setPw(etudiant.getPw());
		user.setRole(role);
		System.out.println(user.getIduser());
		System.out.println(user.getNom());
		System.out.println(user.getPrenom());
		System.out.println(user.getRole().getIntitule());
		user userObj = null;
		userObj = service.saveUser(user);
		return ResponseEntity.ok(updatedEtudiant);
	}
	
}
