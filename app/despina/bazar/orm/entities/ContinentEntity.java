package despina.bazar.orm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ASUS on 9/11/2016.
 */
@Entity
@Table(name = "continent", schema = "bazar_db", catalog = "")
@NamedQueries({
        @NamedQuery(name = "ContinentEntity.DeleteById",
                query = "delete from ContinentEntity e where e.id = :id"),
        @NamedQuery(name = "ContinentEntity.SelectAll",
                query = "select e from ContinentEntity e"),
        @NamedQuery(name = "ContinentEntity.SelectById",
                query = "select e from ContinentEntity e where e.id = :id"),
        @NamedQuery(name = "ContinentEntity.SelectByTitle",
                query = "select e from ContinentEntity e where e.title = :title")
})
public class ContinentEntity {
    private int id;
    private String title;
    private Collection<CityEntity> citiesById;
    private Collection<CountryEntity> countriesById;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContinentEntity that = (ContinentEntity) o;

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

    @JsonIgnore
    @OneToMany(mappedBy = "continentByContinentId")
    public Collection<CityEntity> getCitiesById() {
        return citiesById;
    }

    public void setCitiesById(Collection<CityEntity> citiesById) {
        this.citiesById = citiesById;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "continentByContinentId")
    public Collection<CountryEntity> getCountriesById() {
        return countriesById;
    }

    public void setCountriesById(Collection<CountryEntity> countriesById) {
        this.countriesById = countriesById;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "continentByContinentId")
    public Collection<ProvinceEntity> getProvincesById() {
        return provincesById;
    }

    public void setProvincesById(Collection<ProvinceEntity> provincesById) {
        this.provincesById = provincesById;
    }
}
