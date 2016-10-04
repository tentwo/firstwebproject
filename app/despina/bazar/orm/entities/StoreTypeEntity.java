package despina.bazar.orm.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ASUS on 9/11/2016.
 */
@Entity
@Table(name = "store_type", schema = "bazar_db", catalog = "")
@NamedQueries({
        @NamedQuery(name = "StoreTypeEntity.DeleteById",
                query = "delete from StoreTypeEntity e where e.id = :id"),
        @NamedQuery(name = "StoreTypeEntity.SelectAll",
                query = "select e from StoreTypeEntity e"),
        @NamedQuery(name = "StoreTypeEntity.SelectById",
                query = "select e from StoreTypeEntity e where e.id = :id"),
        @NamedQuery(name = "StoreTypeEntity.SelectByTitle",
                query = "select e from StoreTypeEntity e where e.title = :title")
})
public class StoreTypeEntity {
    private int id;
    private String title;
    private Collection<ShopCenterStoresEntity> shopCenterStoresById;
    private Collection<StoreEntity> storesById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreTypeEntity that = (StoreTypeEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "storeTypeByStoreTypeId")
    public Collection<ShopCenterStoresEntity> getShopCenterStoresById() {
        return shopCenterStoresById;
    }

    public void setShopCenterStoresById(Collection<ShopCenterStoresEntity> shopCenterStoresById) {
        this.shopCenterStoresById = shopCenterStoresById;
    }

    @OneToMany(mappedBy = "storeTypeByStoreTypeId")
    public Collection<StoreEntity> getStoresById() {
        return storesById;
    }

    public void setStoresById(Collection<StoreEntity> storesById) {
        this.storesById = storesById;
    }
}
