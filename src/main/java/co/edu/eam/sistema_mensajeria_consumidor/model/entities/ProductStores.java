package co.edu.eam.sistema_mensajeria_consumidor.model.entities;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="product_stores")
public class ProductStores implements Serializable {

    @Id
    @Column(name="product_id")
    private Integer productId;

    @Column(name="store_id")
    private Integer storeId;

    @Column(name="product_price")
    @NotNull
    private String productPrice;

    public ProductStores(){}


    public ProductStores(Integer productId, Integer storeId, String productPrice) {
        this.productId = productId;
        this.storeId = storeId;
        this.productPrice = productPrice;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
