package co.edu.eam.sistema_mensajeria_consumidor.consumers;

import co.edu.eam.sistema_mensajeria_consumidor.model.entities.Category;
import co.edu.eam.sistema_mensajeria_consumidor.model.entities.ProductStores;
import co.edu.eam.sistema_mensajeria_consumidor.model.entities.Products;
import co.edu.eam.sistema_mensajeria_consumidor.model.entities.Store;
import co.edu.eam.sistema_mensajeria_consumidor.repository.CategoryRepository;
import co.edu.eam.sistema_mensajeria_consumidor.services.CategoryService;
import co.edu.eam.sistema_mensajeria_consumidor.services.ProductStoreService;
import co.edu.eam.sistema_mensajeria_consumidor.services.ProductsService;
import co.edu.eam.sistema_mensajeria_consumidor.services.StoreService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    private CategoryService categoryService;

    private CategoryRepository categoryRepository;

    @Autowired
    private ProductsService productsService;

    @Autowired
    private ProductStoreService productStoreService;

    @Autowired
    private StoreService storeService;

    @RabbitListener(queues = "#{MiTienda.name}")
    public void listenTiendaQueue(String message){

        //System.out.println(message);
        String miArreglo[] = message.split(",");
        Integer product_id = Integer.parseInt(miArreglo[0]);
        String product_name = miArreglo[1];
        String product_price = miArreglo[2];
        String category = miArreglo[3];
        Integer store_id = Integer.parseInt(miArreglo[5]);
        String store_name = miArreglo[6];

        Category category1 = categoryService.findByName(category);
        if (category1 == null){
            category1 = new Category(category);
            categoryService.create(category1);
            category1 = categoryService.findByName(category);
        }

        Products products = new Products(product_id, product_name, category1.getCategoryId());
        productsService.create(products);

        Store store = new Store(store_id, store_name);
        storeService.create(store);

        ProductStores productStores = new ProductStores(product_id, store_id, product_price);
        productStoreService.create(productStores);

    }
}
