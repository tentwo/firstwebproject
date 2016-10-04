package despina.bazar.orm.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ASUS on 9/11/2016.
 */
@Entity
@Table(name = "country", schema = "bazar_db", catalog = "")
@NamedQueries({
        @NamedQuery(name = "CountryEntity.SelectAll",
                query = "select e from CountryEntity e"),
        @NamedQuery(name = "CountryEntity.SelectById",
                query = "select e from CountryEntity e where e.id = :id"),
        @NamedQuery(name = "CountryEntity.SelectByTitle",
                query = "select e from CountryEntity e where e.title = :title")
})
public class CountryEntity {
    private int id;
    private String title;
    private String continentTitle;
    private Collection<CityEntity> citiesById;
    private ContinentEntity continentByContinentId;
    private Collection<ProvinceEntity> provincesById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryEntity that = (CountryEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (continentTitle != null ? !continentTitle.equals(that.continentTitle) : that.continentTitle != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (continentTitle != null ? continentTitle.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "countryByCountryId")
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

    @OneToMany(mappedBy = "countryByCountryId")
    public Collection<ProvinceEntity> getProvincesById() {
        return provincesById;
    }

    public void setProvincesById(Collection<ProvinceEntity> provincesById) {
        this.provincesById = provincesById;
    }
}
