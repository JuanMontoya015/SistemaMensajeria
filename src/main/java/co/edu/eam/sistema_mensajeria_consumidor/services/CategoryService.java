package co.edu.eam.sistema_mensajeria_consumidor.services;

import co.edu.eam.sistema_mensajeria_consumidor.exceptions.BusinessException;
import co.edu.eam.sistema_mensajeria_consumidor.model.entities.Category;
import co.edu.eam.sistema_mensajeria_consumidor.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void create(Category c){
        Category categoryExist = categoryRepository.findByName(c.getCategoryName());
        if (categoryExist != null) throw new BusinessException("YA EXISTE LA CATEGORIA", "category_already_exist");
        categoryRepository.save(c);
    }

    public Category findByName(String categoryName){
        return categoryRepository.findByName(categoryName);
    }

}
