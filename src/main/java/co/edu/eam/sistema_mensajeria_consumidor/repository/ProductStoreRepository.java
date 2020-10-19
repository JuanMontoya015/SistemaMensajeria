package co.edu.eam.sistema_mensajeria_consumidor.repository;

import co.edu.eam.sistema_mensajeria_consumidor.model.entities.ProductStores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductStoreRepository extends JpaRepository<ProductStores, Integer> {

}
