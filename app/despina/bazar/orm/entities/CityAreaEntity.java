package despina.bazar.orm.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ASUS on 9/11/2016.
 */
@Entity
@Table(name = "city_area", schema = "bazar_db", catalog = "")
@NamedQueries({
    @NamedQuery(name = "CityAreaEntity.DeleteById",
                query = "delete from CityAreaEntity e where e.id = :id"),
    @NamedQuery(name = "CityAreaEntity.SelectAll", query = "select e from CityAreaEntity e"),
    @NamedQuery(name = "CityAreaEntity.SelectById",
            query = "select e from CityAreaEntity e where e.id = :id"),
    @NamedQuery(name = "CityAreaEntity.SelectByTitle",
            query = "select e from CityAreaEntity e where e.title = :title")
})
public class CityAreaEntity {
    private int id;
    private String title;
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
    @Column(name = "title", nullable = true, length = 50)
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

        CityAreaEntity that = (CityAreaEntity) o;

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

    @OneToMany(mappedBy = "cityAreaByCityAreaId")
    public Collection<ShopCenterEntity> getShopCentersById() {
        return shopCentersById;
    }

    public void setShopCentersById(Collection<ShopCenterEntity> shopCentersById) {
        this.shopCentersById = shopCentersById;
    }
}
