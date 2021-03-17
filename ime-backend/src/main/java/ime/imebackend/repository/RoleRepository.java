package ime.imebackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ime.imebackend.entity.RoleName;
import ime.imebackend.entity.role;

public interface RoleRepository extends JpaRepository<role, Long> {
	
	public role findByIdrole(Long Id);
	
	role findByIntitule(String roleName);

}
