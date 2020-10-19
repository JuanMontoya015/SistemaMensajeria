package co.edu.eam.sistema_mensajeria_consumidor.services;

import co.edu.eam.sistema_mensajeria_consumidor.exceptions.BusinessException;
import co.edu.eam.sistema_mensajeria_consumidor.model.entities.Products;
import co.edu.eam.sistema_mensajeria_consumidor.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public boolean create(Products p){
        boolean productsExist = productsRepository.existsById(p.getProductId());
        if (productsExist){
            return false;
        }
        productsRepository.save(p);
        return true;
    }
}
