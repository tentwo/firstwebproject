package despina.bazar.orm.entities;

import javax.persistence.*;

/**
 * Created by ASUS on 9/11/2016.
 */
@Entity
@Table(name = "shop_center_enjoys", schema = "bazar_db", catalog = "")
@NamedQueries({
        @NamedQuery(name = "ShopCenterEnjoysEntity.DeleteById",
                query = "delete from ShopCenterEnjoysEntity e where e.id = :id"),
        @NamedQuery(name = "ShopCenterEnjoysEntity.SelectAll",
                query = "select e from ShopCenterEnjoysEntity e"),
        @NamedQuery(name = "ShopCenterEnjoysEntity.SelectById",
                query = "select e from ShopCenterEnjoysEntity e where e.id = :id"),
        @NamedQuery(name = "ShopCenterEnjoysEntity.SelectByTitle",
                query = "select e from ShopCenterEnjoysEntity e " +
                        "where e.enjoyTypeTitle = :title"),
        @NamedQuery(name = "ShopCenterEnjoysEntity.SelectByShopCenterAndEnjoyType",
                query = "select e from ShopCenterEnjoysEntity e " +
                        "where e.enjoyTypeByEnjoyTypeId.id = :enjoyTypeId " +
                        "and e.shopCenterByShopCenterId.id = :shopCenterId")
})
public class ShopCenterEnjoysEntity {
    private int id;
    private String enjoyTypeTitle;
    private Integer count;
    private ShopCenterEntity shopCenterByShopCenterId;
    private EnjoyTypeEntity enjoyTypeByEnjoyTypeId;

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
    @Column(name = "enjoy_type_title", nullable = true, length = 50)
    public String getEnjoyTypeTitle() {
        return enjoyTypeTitle;
    }

    public void setEnjoyTypeTitle(String enjoyTypeTitle) {
        this.enjoyTypeTitle = enjoyTypeTitle;
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

        ShopCenterEnjoysEntity that = (ShopCenterEnjoysEntity) o;

        if (id != that.id) return false;
        if (enjoyTypeTitle != null ? !enjoyTypeTitle.equals(that.enjoyTypeTitle) : that.enjoyTypeTitle != null)
            return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (enjoyTypeTitle != null ? enjoyTypeTitle.hashCode() : 0);
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
    @JoinColumn(name = "enjoy_type_id", referencedColumnName = "id")
    public EnjoyTypeEntity getEnjoyTypeByEnjoyTypeId() {
        return enjoyTypeByEnjoyTypeId;
    }

    public void setEnjoyTypeByEnjoyTypeId(EnjoyTypeEntity enjoyTypeByEnjoyTypeId) {
        this.enjoyTypeByEnjoyTypeId = enjoyTypeByEnjoyTypeId;
    }
}
