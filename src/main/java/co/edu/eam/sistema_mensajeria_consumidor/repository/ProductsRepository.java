package co.edu.eam.sistema_mensajeria_consumidor.repository;

import co.edu.eam.sistema_mensajeria_consumidor.model.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
