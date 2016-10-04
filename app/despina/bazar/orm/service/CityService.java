package despina.bazar.orm.service;

import despina.bazar.orm.entities.CityEntity;
import despina.bazar.orm.entities.CountryEntity;
import despina.bazar.orm.entities.ProvinceEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by ASUS on 9/12/2016.
 */
@Repository
public class CityService extends BazarBaseService {
    @Override
    public Class getEntityClass() {
        return CityEntity.class;
    }

    public void insert(String title, int countryId) {
        ProvinceEntity provinceEntity = bazarBaseDao.selectById(
                countryId, ProvinceEntity.class);
        CityEntity cityEntity = new CityEntity();
        cityEntity.setTitle(title);
        cityEntity.setProvinceTitle(provinceEntity.getTitle());
        cityEntity.setCountryTitle(provinceEntity.getCountryTitle());
        cityEntity.setContinentTitle(provinceEntity.getContinentTitle());
        cityEntity.setProvinceByProvinceId(provinceEntity);
        cityEntity.setCountryByCountryId(provinceEntity.getCountryByCountryId());
        cityEntity.setContinentByContinentId(
                provinceEntity.getContinentByContinentId());
        bazarBaseDao.insert(cityEntity);
    }
}
