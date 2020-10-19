package co.edu.eam.sistema_mensajeria_consumidor.model.entities;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Store")
public class Store implements Serializable {

    @Id
    @Column(name = "store_id")
    private Integer storeId;

    @Column(name="store_name")
    private String storeName;

    public Store(){}

    public Store(Integer storeId, String storeName) {
        this.storeId = storeId;
        this.storeName = storeName;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
