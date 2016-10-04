package despina.bazar.orm.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ASUS on 9/11/2016.
 */
@Entity
@Table(name = "shop_center", schema = "bazar_db", catalog = "")
@NamedQueries({
        @NamedQuery(name = "ShopCenterEntity.DeleteById",
                query = "delete from ShopCenterEntity e where e.id = :id"),
        @NamedQuery(name = "ShopCenterEntity.SelectAll",
                query = "select e from ShopCenterEntity e"),
        @NamedQuery(name = "ShopCenterEntity.SelectById",
                query = "select e from ShopCenterEntity e where e.id = :id"),
        @NamedQuery(name = "ShopCenterEntity.SelectByTitle",
                query = "select e from ShopCenterEntity e where e.title = :title")
})
public class ShopCenterEntity {
    private int id;
    private String title;
    private Integer positiveVote;
    private Integer negativeVote;
    private Integer modernityLevel;
    private Integer facilityLevel;
    private String cityTitle;
    private String cityAreaTitle;
    private String picture;
    private CityEntity cityByCityId;
    private CityAreaEntity cityAreaByCityAreaId;
    private Collection<ShopCenterEnjoysEntity> shopCenterEnjoysesById;
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
    @Column(name = "modernity_level", nullable = true)
    public Integer getModernityLevel() {
        return modernityLevel;
    }

    public void setModernityLevel(Integer modernityLevel) {
        this.modernityLevel = modernityLevel;
    }

    @Basic
    @Column(name = "facility_level", nullable = true)
    public Integer getFacilityLevel() {
        return facilityLevel;
    }

    public void setFacilityLevel(Integer facilityLevel) {
        this.facilityLevel = facilityLevel;
    }

    @Basic
    @Column(name = "city_title", nullable = true, length = 50)
    public String getCityTitle() {
        return cityTitle;
    }

    public void setCityTitle(String cityTitle) {
        this.cityTitle = cityTitle;
    }

    @Basic
    @Column(name = "city_area_title", nullable = true, length = 50)
    public String getCityAreaTitle() {
        return cityAreaTitle;
    }

    public void setCityAreaTitle(String cityAreaTitle) {
        this.cityAreaTitle = cityAreaTitle;
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

        ShopCenterEntity that = (ShopCenterEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (positiveVote != null ? !positiveVote.equals(that.positiveVote) : that.positiveVote != null) return false;
        if (negativeVote != null ? !negativeVote.equals(that.negativeVote) : that.negativeVote != null) return false;
        if (modernityLevel != null ? !modernityLevel.equals(that.modernityLevel) : that.modernityLevel != null)
            return false;
        if (facilityLevel != null ? !facilityLevel.equals(that.facilityLevel) : that.facilityLevel != null)
            return false;
        if (cityTitle != null ? !cityTitle.equals(that.cityTitle) : that.cityTitle != null) return false;
        if (cityAreaTitle != null ? !cityAreaTitle.equals(that.cityAreaTitle) : that.cityAreaTitle != null)
            return false;
        if (picture != null ? !picture.equals(that.picture) : that.picture != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (positiveVote != null ? positiveVote.hashCode() : 0);
        result = 31 * result + (negativeVote != null ? negativeVote.hashCode() : 0);
        result = 31 * result + (modernityLevel != null ? modernityLevel.hashCode() : 0);
        result = 31 * result + (facilityLevel != null ? facilityLevel.hashCode() : 0);
        result = 31 * result + (cityTitle != null ? cityTitle.hashCode() : 0);
        result = 31 * result + (cityAreaTitle != null ? cityAreaTitle.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    public CityEntity getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(CityEntity cityByCityId) {
        this.cityByCityId = cityByCityId;
    }

    @ManyToOne
    @JoinColumn(name = "city_area_id", referencedColumnName = "id")
    public CityAreaEntity getCityAreaByCityAreaId() {
        return cityAreaByCityAreaId;
    }

    public void setCityAreaByCityAreaId(CityAreaEntity cityAreaByCityAreaId) {
        this.cityAreaByCityAreaId = cityAreaByCityAreaId;
    }

    @OneToMany(mappedBy = "shopCenterByShopCenterId")
    public Collection<ShopCenterEnjoysEntity> getShopCenterEnjoysesById() {
        return shopCenterEnjoysesById;
    }

    public void setShopCenterEnjoysesById(Collection<ShopCenterEnjoysEntity> shopCenterEnjoysesById) {
        this.shopCenterEnjoysesById = shopCenterEnjoysesById;
    }

    @OneToMany(mappedBy = "shopCenterByShopCenterId")
    public Collection<ShopCenterStoresEntity> getShopCenterStoresById() {
        return shopCenterStoresById;
    }

    public void setShopCenterStoresById(Collection<ShopCenterStoresEntity> shopCenterStoresById) {
        this.shopCenterStoresById = shopCenterStoresById;
    }

    @OneToMany(mappedBy = "shopCenterByShopCenterId")
    public Collection<StoreEntity> getStoresById() {
        return storesById;
    }

    public void setStoresById(Collection<StoreEntity> storesById) {
        this.storesById = storesById;
    }
}
