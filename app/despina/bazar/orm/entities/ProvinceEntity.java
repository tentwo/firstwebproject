package despina.bazar.orm.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ASUS on 9/11/2016.
 */
@Entity
@Table(name = "province", schema = "bazar_db", catalog = "")
@NamedQueries({
        @NamedQuery(name = "ProvinceEntity.SelectAll",
                query = "select e from ProvinceEntity e"),
        @NamedQuery(name = "ProvinceEntity.SelectById",
                query = "select e from ProvinceEntity e where e.id = :id"),
        @NamedQuery(name = "ProvinceEntity.SelectByTitle",
                query = "select e from ProvinceEntity e where e.title = :title")
})
public class ProvinceEntity {
    private int id;
    private String title;
    private String continentTitle;
    private String countryTitle;
    private Collection<CityEntity> citiesById;
    private ContinentEntity continentByContinentId;
    private CountryEntity countryByCountryId;

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

    public void setCountryTitle(String countryTitle) {
        this.countryTitle = countryTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProvinceEntity that = (ProvinceEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (continentTitle != null ? !continentTitle.equals(that.continentTitle) : that.continentTitle != null)
            return false;
        if (countryTitle != null ? !countryTitle.equals(that.countryTitle) : that.countryTitle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (continentTitle != null ? continentTitle.hashCode() : 0);
        result = 31 * result + (countryTitle != null ? countryTitle.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "provinceByProvinceId")
    public Collection<CityEntity> getCitiesById() {
        return citiesById;
    }

    public void setCitiesById(Collection<CityEntity> citiesById) {
        this.citiesById = citiesById;
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
}
