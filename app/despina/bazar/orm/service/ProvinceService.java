package despina.bazar.orm.service;

import despina.bazar.orm.dao.BazarBaseDao;
import despina.bazar.orm.entities.CountryEntity;
import despina.bazar.orm.entities.ProvinceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ASUS on 9/12/2016.
 */
@Repository
public class ProvinceService extends BazarBaseService {
    @Override
    public Class getEntityClass() {
        return ProvinceEntity.class;
    }

    public void insert(String title, int countryId) {
        CountryEntity countryEntity = bazarBaseDao.selectById(
                countryId, CountryEntity.class);
        ProvinceEntity provinceEntity = new ProvinceEntity();
        provinceEntity.setTitle(title);
        provinceEntity.setCountryTitle(countryEntity.getTitle());
        provinceEntity.setContinentTitle(countryEntity.getContinentTitle());
        provinceEntity.setCountryByCountryId(countryEntity);
        provinceEntity.setContinentByContinentId(
                countryEntity.getContinentByContinentId());
        bazarBaseDao.insert(provinceEntity);
    }

    public void insertContinent(String title, int countryId) {
//        bazarBaseDao.insert(provinceEntity);
    }
}
