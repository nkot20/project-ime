package ime.imebackend.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import ime.imebackend.entity.user;


public interface UserRepository extends JpaRepository<user, Long> {
	
	Optional<user> findByIduser(String iduser);
	
	public user findByIduserAndPw(String iduser, String pw);
	
	Optional<user> findByNom(String userName);
	
	Boolean existsByNom(String userName);

}
