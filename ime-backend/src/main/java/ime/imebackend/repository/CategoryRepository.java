package ime.imebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ime.imebackend.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
