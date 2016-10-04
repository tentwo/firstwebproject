package despina.bazar.orm.service;

import despina.bazar.orm.dao.BazarBaseDao;
import despina.bazar.orm.entities.ContinentEntity;
import despina.bazar.orm.entities.CountryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ASUS on 9/12/2016.
 */
@Repository
public class CountryService extends BazarBaseService {
    @Override
    public Class getEntityClass() {
        return CountryEntity.class;
    }

    public void insert(String title, int continentId) {
        ContinentEntity o = bazarBaseDao.selectById(continentId, ContinentEntity.class);
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setTitle(title);
        countryEntity.setContinentTitle(o.getTitle());
        countryEntity.setContinentByContinentId(o);
        bazarBaseDao.insert(countryEntity);
    }
}
