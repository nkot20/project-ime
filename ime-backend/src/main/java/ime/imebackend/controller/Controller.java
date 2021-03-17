package ime.imebackend.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.validation.Valid;

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
	public Optional<user> searchUser(@Valid @RequestBody user user) throws Exception {
		String iduser = user.getIduser();
		Optional<ime.imebackend.entity.user> userObj = null;
		if(iduser != null) {
			userObj = service.featchUserById(iduser);
		}
		else {
			throw new Exception("User is not exist"+iduser);
		}
		return userObj;
	}
	
	
}
