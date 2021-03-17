package ime.imebackend.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ime.imebackend.entity.user;
import ime.imebackend.repository.UserRepository;
 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	  UserRepository userRepository;
	UserDetails userDetail;
	UserPrinciple userPrinciple;
	  @Transactional
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  UserDetails userDetails;
	    user user = userRepository.findByIduser(username).orElseThrow(
	        () -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
	    return  UserPrinciple.build(user);
	  }
	
}
