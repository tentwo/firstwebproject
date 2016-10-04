package despina.bazar.orm.service;

import despina.bazar.orm.entities.CityAreaEntity;
import despina.bazar.orm.entities.ContinentEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by ASUS on 9/12/2016.
 */
@Repository
public class CityAreaService extends BazarBaseService {
    @Override
    public Class getEntityClass() {
        return CityAreaEntity.class;
    }

    public int insert(String title) {
        CityAreaEntity cityAreaEntity = new CityAreaEntity();
        cityAreaEntity.setTitle(title);
        bazarBaseDao.insert(cityAreaEntity);
        return cityAreaEntity.getId();
    }
}
