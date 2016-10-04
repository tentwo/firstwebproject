package despina.bazar.orm.service;

import despina.bazar.orm.entities.ShopCenterEntity;
import despina.bazar.orm.entities.StoreEntity;
import despina.bazar.orm.entities.StoreTypeEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by ASUS on 9/12/2016.
 */
@Repository
public class StoreService extends BazarBaseService {
    @Override
    public Class getEntityClass() {
        return StoreEntity.class;
    }

    public StoreEntity insert(String title,
                       int ShopCenterId,
                       int storeTypeId,
                       int floor,
                       int number,
                       String tel,
                       String mobile,
                       String shopkeeperName,
                       boolean forMen,
                       boolean forWomen) {
        ShopCenterEntity shopCenterEntity = bazarBaseDao.selectById(
                ShopCenterId, ShopCenterEntity.class
        );
        StoreTypeEntity storeTypeEntity = bazarBaseDao.selectById(
                storeTypeId, StoreTypeEntity.class
        );
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setTitle(title);
        storeEntity.setFloor(floor);
        storeEntity.setNumber(number);
        storeEntity.setTel(tel);
        storeEntity.setMobile(mobile);
        storeEntity.setShopkeeperName(shopkeeperName);
        storeEntity.setShopCenterTitle(shopCenterEntity.getTitle());
        storeEntity.setShopCenterByShopCenterId(shopCenterEntity);
        storeEntity.setStoreTypeTitle(storeTypeEntity.getTitle());
        storeEntity.setStoreTypeByStoreTypeId(storeTypeEntity);
        bazarBaseDao.insert(storeEntity);
        return storeEntity;
    }
}
