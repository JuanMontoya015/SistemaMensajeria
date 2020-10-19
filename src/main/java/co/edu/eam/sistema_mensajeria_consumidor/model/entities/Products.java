package co.edu.eam.sistema_mensajeria_consumidor.model.entities;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="products")
public class Products implements Serializable {

    @Id
    @Column(name="product_id")
    private Integer productId;

    @Column(name="product_name")
    @NotNull
    private String productName;

    @Column(name="category_id")
    @NotNull
    private Integer categoryId;

    public Products(){}

    public Products(String productName){
        this.productName = productName;
    }

    public Products(Integer productId, String productName, Integer categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
