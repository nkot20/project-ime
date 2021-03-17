package ime.imebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ime.imebackend.entity.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {

}
