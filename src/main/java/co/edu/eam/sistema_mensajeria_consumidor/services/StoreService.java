package co.edu.eam.sistema_mensajeria_consumidor.services;

import co.edu.eam.sistema_mensajeria_consumidor.exceptions.BusinessException;
import co.edu.eam.sistema_mensajeria_consumidor.repository.StoreRepository;
import co.edu.eam.sistema_mensajeria_consumidor.model.entities.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public boolean create(Store st){
        boolean storeExist = storeRepository.existsById(st.getStoreId());
        if (storeExist){
            return false;
        }
        storeRepository.save(st);
        return true;
    }
}
