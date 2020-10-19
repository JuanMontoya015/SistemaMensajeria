package co.edu.eam.sistema_mensajeria_consumidor.services;

import ch.qos.logback.core.joran.conditional.IfAction;
import co.edu.eam.sistema_mensajeria_consumidor.exceptions.BusinessException;
import co.edu.eam.sistema_mensajeria_consumidor.model.entities.ProductStores;
import co.edu.eam.sistema_mensajeria_consumidor.repository.ProductStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductStoreService {

    @Autowired
    private ProductStoreRepository productStoreRepository;

    public void create(ProductStores ps){
        boolean productStoreExist = productStoreRepository.existsById(ps.getProductId());
        if (productStoreExist) throw new BusinessException("YA EXISTE EL PRODUCSTORE", "product_store_already_exist");
        productStoreRepository.save(ps);
    }
}
