package despina.bazar.orm.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ASUS on 9/11/2016.
 */
@Entity
@Table(name = "city", schema = "bazar_db", catalog = "")
@NamedQueries({
        @NamedQuery(name = "CityEntity.SelectAll", query = "select e from CityEntity e"),
        @NamedQuery(name = "CityEntity.SelectById",
                query = "select e from CityEntity e where e.id = :id"),
        @NamedQuery(name = "CityEntity.SelectByTitle",
                query = "select e from CityEntity e where e.title = :title")
})
public class CityEntity {
    private int id;
    private String title;
    private String continentTitle;
    private String countryTitle;
    private String provinceTitle;
    private ContinentEntity continentByContinentId;
    private CountryEntity countryByCountryId;
    private ProvinceEntity provinceByProvinceId;
    private Collection<ShopCenterEntity> shopCentersById;

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
    @Column(name = "continent_title", nullable = true, length = 50)
    public String getContinentTitle() {
        return continentTitle;
    }

    public void setContinentTitle(String continentTitle) {
        this.continentTitle = continentTitle;
    }

    @Basic
    @Column(name = "country_title", nullable = true, length = 50)
    public String getCountryTitle() {
        return countryTitle;
    }

    public void setCountryTitle(String countryTile) {
        this.countryTitle = countryTile;
    }

    @Basic
    @Column(name = "province_title", nullable = true, length = 50)
    public String getProvinceTitle() {
        return provinceTitle;
    }

    public void setProvinceTitle(String provinceTitle) {
        this.provinceTitle = provinceTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity that = (CityEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (continentTitle != null ? !continentTitle.equals(that.continentTitle) : that.continentTitle != null)
            return false;
        if (countryTitle != null ? !countryTitle.equals(that.countryTitle) : that.countryTitle != null) return false;
        if (provinceTitle != null ? !provinceTitle.equals(that.provinceTitle) : that.provinceTitle != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (continentTitle != null ? continentTitle.hashCode() : 0);
        result = 31 * result + (countryTitle != null ? countryTitle.hashCode() : 0);
        result = 31 * result + (provinceTitle != null ? provinceTitle.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "continent_id", referencedColumnName = "id")
    public ContinentEntity getContinentByContinentId() {
        return continentByContinentId;
    }

    public void setContinentByContinentId(ContinentEntity continentByContinentId) {
        this.continentByContinentId = continentByContinentId;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    public CountryEntity getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(CountryEntity countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }

    @ManyToOne
    @JoinColumn(name = "province_id", referencedColumnName = "id")
    public ProvinceEntity getProvinceByProvinceId() {
        return provinceByProvinceId;
    }

    public void setProvinceByProvinceId(ProvinceEntity provinceByProvinceId) {
        this.provinceByProvinceId = provinceByProvinceId;
    }

    @OneToMany(mappedBy = "cityByCityId")
    public Collection<ShopCenterEntity> getShopCentersById() {
        return shopCentersById;
    }

    public void setShopCentersById(Collection<ShopCenterEntity> shopCentersById) {
        this.shopCentersById = shopCentersById;
    }
}
