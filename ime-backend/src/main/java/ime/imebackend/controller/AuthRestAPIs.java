package ime.imebackend.controller;

import java.util.HashSet;
import java.util.Set;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ime.imebackend.entity.RoleName;
import ime.imebackend.entity.role;
import ime.imebackend.entity.user;
import ime.imebackend.messages.request.LoginForm;
import ime.imebackend.messages.request.SignUpForm;
import ime.imebackend.messages.response.JwtResponse;
import ime.imebackend.messages.response.ResponseMessage;
import ime.imebackend.repository.RoleRepository;
import ime.imebackend.repository.UserRepository;
import ime.imebackend.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
public class AuthRestAPIs {
 
  @Autowired
  AuthenticationManager authenticationManager;
 
  @Autowired
  UserRepository userRepository;
 
  @Autowired
  RoleRepository roleRepository;
 
  @Autowired
  PasswordEncoder encoder;
 
  @Autowired
  JwtProvider jwtProvider;
 
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
 
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
 
    SecurityContextHolder.getContext().setAuthentication(authentication);
 
    String jwt = jwtProvider.generateJwtToken(authentication);
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
 
    return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
  }
 
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
    if (userRepository.existsByNom(signUpRequest.getIdUser())) {
      return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
          HttpStatus.BAD_REQUEST);
    }
 
    // Creating user's account
    user user = new user(signUpRequest.getIdUser(), signUpRequest.getName(), signUpRequest.getLastName(),
        encoder.encode(signUpRequest.getPw()));
 
    String strRoles = signUpRequest.getRole();
    System.out.println(strRoles);
    role roles = new role();
 
		/*
		 * switch (strRoles) { case "administrateur": roles =
		 * roleRepository.findByIntitule(RoleName.administrateur); break; default: roles
		 * = roleRepository.findByIntitule(RoleName.etudiant); }
		 */
 
      //RoleName administrateur = RoleName.administrateur;
	if (strRoles.equals("administrateur")) {
    	  roles = roleRepository.findByIntitule("administrateur");  
      }
      if (strRoles.equals("etudiant")) {
    	  roles = roleRepository.findByIntitule("etudiant"); 
      }
      
      String srole = roles.getIntitule();
      System.out.println(srole);
      
    user.setRole(roles);
    userRepository.save(user);
 
    return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
  }
}
