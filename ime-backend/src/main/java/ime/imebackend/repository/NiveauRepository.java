package ime.imebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ime.imebackend.entity.niveau;

//@RepositoryRestResource(collectionResourceRel="niveau", path="niveau")
public interface NiveauRepository extends JpaRepository<niveau, Long> {

}
