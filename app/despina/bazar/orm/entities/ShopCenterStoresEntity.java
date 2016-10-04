package despina.bazar.orm.entities;

import javax.persistence.*;

/**
 * Created by ASUS on 9/11/2016.
 */
@Entity
@Table(name = "shop_center_stores", schema = "bazar_db", catalog = "")
@NamedQueries({
        @NamedQuery(name = "ShopCenterStoresEntity.DeleteById",
                query = "delete from ShopCenterStoresEntity e where e.id = :id"),
        @NamedQuery(name = "ShopCenterStoresEntity.SelectAll",
                query = "select e from ShopCenterStoresEntity e"),
        @NamedQuery(name = "ShopCenterStoresEntity.SelectById",
                query = "select e from ShopCenterStoresEntity e where e.id = :id"),
        @NamedQuery(name = "ShopCenterStoresEntity.SelectByTitle",
                query = "select e from ShopCenterStoresEntity e " +
                        "where e.storeTypeTitle = :title"),
        @NamedQuery(name = "ShopCenterStoresEntity.SelectByShopCenterAndStoreType",
                query = "select e from ShopCenterStoresEntity e " +
                        "where e.storeTypeByStoreTypeId.id = :storeTypeId " +
                        "and e.shopCenterByShopCenterId.id = :shopCenterId")
})
public class ShopCenterStoresEntity {
    private int id;
    private String storeTypeTitle;
    private Integer count;
    private ShopCenterEntity shopCenterByShopCenterId;
    private StoreTypeEntity storeTypeByStoreTypeId;

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
    @Column(name = "store_type_title", nullable = true, length = 50)
    public String getStoreTypeTitle() {
        return storeTypeTitle;
    }

    public void setStoreTypeTitle(String storeTypeTitle) {
        this.storeTypeTitle = storeTypeTitle;
    }

    @Basic
    @Column(name = "count", nullable = true)
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopCenterStoresEntity that = (ShopCenterStoresEntity) o;

        if (id != that.id) return false;
        if (storeTypeTitle != null ? !storeTypeTitle.equals(that.storeTypeTitle) : that.storeTypeTitle != null)
            return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (storeTypeTitle != null ? storeTypeTitle.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "shop_center_id", referencedColumnName = "id")
    public ShopCenterEntity getShopCenterByShopCenterId() {
        return shopCenterByShopCenterId;
    }

    public void setShopCenterByShopCenterId(ShopCenterEntity shopCenterByShopCenterId) {
        this.shopCenterByShopCenterId = shopCenterByShopCenterId;
    }

    @ManyToOne
    @JoinColumn(name = "store_type_id", referencedColumnName = "id")
    public StoreTypeEntity getStoreTypeByStoreTypeId() {
        return storeTypeByStoreTypeId;
    }

    public void setStoreTypeByStoreTypeId(StoreTypeEntity storeTypeByStoreTypeId) {
        this.storeTypeByStoreTypeId = storeTypeByStoreTypeId;
    }
}
