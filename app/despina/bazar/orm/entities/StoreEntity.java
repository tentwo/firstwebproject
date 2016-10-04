package despina.bazar.orm.entities;

import javax.persistence.*;

/**
 * Created by ASUS on 9/11/2016.
 */
@Entity
@Table(name = "store", schema = "bazar_db", catalog = "")
@NamedQueries({
        @NamedQuery(name = "StoreEntity.DeleteById",
                query = "delete from StoreEntity e where e.id = :id"),
        @NamedQuery(name = "StoreEntity.SelectAll",
                query = "select e from StoreEntity e"),
        @NamedQuery(name = "StoreEntity.SelectById",
                query = "select e from StoreEntity e where e.id = :id"),
        @NamedQuery(name = "StoreEntity.SelectByTitle",
                query = "select e from StoreEntity e where e.title = :title")
})
public class StoreEntity {
    private int id;
    private String title;
    private String shopCenterTitle;
    private String storeTypeTitle;
    private Integer floor;
    private Integer number;
    private String tel;
    private String mobile;
    private String shopkeeperName;
    private Integer positiveVote;
    private Integer negativeVote;
    private Integer forMen;
    private Integer forWomen;
    private String picture;
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
    @Column(name = "title", nullable = false, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "shop_center_title", nullable = true, length = 50)
    public String getShopCenterTitle() {
        return shopCenterTitle;
    }

    public void setShopCenterTitle(String shopCenterTitle) {
        this.shopCenterTitle = shopCenterTitle;
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
    @Column(name = "floor", nullable = true)
    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    @Basic
    @Column(name = "number", nullable = true)
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 11)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 11)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "shopkeeper_name", nullable = true, length = 50)
    public String getShopkeeperName() {
        return shopkeeperName;
    }

    public void setShopkeeperName(String shopkeeperName) {
        this.shopkeeperName = shopkeeperName;
    }

    @Basic
    @Column(name = "positive_vote", nullable = true)
    public Integer getPositiveVote() {
        return positiveVote;
    }

    public void setPositiveVote(Integer positiveVote) {
        this.positiveVote = positiveVote;
    }

    @Basic
    @Column(name = "negative_vote", nullable = true)
    public Integer getNegativeVote() {
        return negativeVote;
    }

    public void setNegativeVote(Integer negativeVote) {
        this.negativeVote = negativeVote;
    }

    @Basic
    @Column(name = "for_men", nullable = true)
    public Integer getForMen() {
        return forMen;
    }

    public void setForMen(Integer forMen) {
        this.forMen = forMen;
    }

    @Basic
    @Column(name = "for_women", nullable = true)
    public Integer getForWomen() {
        return forWomen;
    }

    public void setForWomen(Integer forWomen) {
        this.forWomen = forWomen;
    }

    @Basic
    @Column(name = "picture", nullable = true, length = 255)
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreEntity that = (StoreEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (shopCenterTitle != null ? !shopCenterTitle.equals(that.shopCenterTitle) : that.shopCenterTitle != null)
            return false;
        if (storeTypeTitle != null ? !storeTypeTitle.equals(that.storeTypeTitle) : that.storeTypeTitle != null)
            return false;
        if (floor != null ? !floor.equals(that.floor) : that.floor != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (shopkeeperName != null ? !shopkeeperName.equals(that.shopkeeperName) : that.shopkeeperName != null)
            return false;
        if (positiveVote != null ? !positiveVote.equals(that.positiveVote) : that.positiveVote != null) return false;
        if (negativeVote != null ? !negativeVote.equals(that.negativeVote) : that.negativeVote != null) return false;
        if (forMen != null ? !forMen.equals(that.forMen) : that.forMen != null) return false;
        if (forWomen != null ? !forWomen.equals(that.forWomen) : that.forWomen != null) return false;
        if (picture != null ? !picture.equals(that.picture) : that.picture != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (shopCenterTitle != null ? shopCenterTitle.hashCode() : 0);
        result = 31 * result + (storeTypeTitle != null ? storeTypeTitle.hashCode() : 0);
        result = 31 * result + (floor != null ? floor.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (shopkeeperName != null ? shopkeeperName.hashCode() : 0);
        result = 31 * result + (positiveVote != null ? positiveVote.hashCode() : 0);
        result = 31 * result + (negativeVote != null ? negativeVote.hashCode() : 0);
        result = 31 * result + (forMen != null ? forMen.hashCode() : 0);
        result = 31 * result + (forWomen != null ? forWomen.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
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
