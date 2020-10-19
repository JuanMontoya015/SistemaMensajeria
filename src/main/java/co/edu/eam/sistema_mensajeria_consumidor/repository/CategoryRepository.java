package co.edu.eam.sistema_mensajeria_consumidor.repository;

import co.edu.eam.sistema_mensajeria_consumidor.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT c FROM Category c WHERE lower(c.categoryName) like lower(:name)")
    Category findByName(String name);

}
