package despina.bazar.orm.service;

import despina.bazar.orm.dao.BazarBaseDao;
import despina.bazar.orm.entities.CityAreaEntity;
import despina.bazar.orm.entities.CityEntity;
import despina.bazar.orm.entities.ShopCenterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ASUS on 9/12/2016.
 */
@Repository
public class ShopCenterService extends BazarBaseService {
    @Autowired
    private BazarBaseDao bazarBaseDao;

    @Override
    public Class getEntityClass() {
        return ShopCenterEntity.class;
    }

    public int insert(String title, int cityId, int cityAreaId) {
        CityEntity cityEntity = bazarBaseDao.selectById(
                cityId, CityEntity.class);
        CityAreaEntity cityAreaEntity = bazarBaseDao.selectById(
                cityAreaId, CityAreaEntity.class
        );
        ShopCenterEntity shopCenterEntity = new ShopCenterEntity();
        shopCenterEntity.setTitle(title);
        shopCenterEntity.setCityTitle(cityEntity.getTitle());
        shopCenterEntity.setCityByCityId(cityEntity);
        shopCenterEntity.setCityAreaTitle(cityAreaEntity.getTitle());
        shopCenterEntity.setCityAreaByCityAreaId(cityAreaEntity);
        shopCenterEntity.setNegativeVote(0);
        shopCenterEntity.setPositiveVote(0);
        bazarBaseDao.insert(shopCenterEntity);
        return shopCenterEntity.getId();
    }
}
