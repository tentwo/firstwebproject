package despina.bazar.orm.service;

import despina.bazar.orm.dao.ShopCenterStoresDao;
import despina.bazar.orm.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ASUS on 9/12/2016.
 */
@Repository
public class ShopCenterStoresService extends BazarBaseService {
    @Autowired
    private ShopCenterStoresDao shopCenterStoresDao;

    @Override
    public Class getEntityClass() {
        return ShopCenterStoresEntity.class;
    }

    public ShopCenterStoresEntity insert(int shopCenterId, int storeTypeId) {
        ShopCenterEntity shopCenterEntity = shopCenterStoresDao.selectById(
                shopCenterId, ShopCenterEntity.class);
        StoreTypeEntity storeTypeEntity = shopCenterStoresDao.selectById(
                storeTypeId, StoreTypeEntity.class
        );
        ShopCenterStoresEntity shopCenterStoresEntity =
                new ShopCenterStoresEntity();
        shopCenterStoresEntity.setStoreTypeTitle(storeTypeEntity.getTitle());
        shopCenterStoresEntity.setStoreTypeByStoreTypeId(storeTypeEntity);
        shopCenterStoresEntity.setShopCenterByShopCenterId(shopCenterEntity);
        shopCenterStoresEntity.setCount(0);
        shopCenterStoresDao.insert(shopCenterStoresEntity);
        return shopCenterStoresEntity;
    }

    public void addCount(int shopCenterId, int enjoyTypeId) {
        ShopCenterStoresEntity shopCenterStoresEntity =
                shopCenterStoresDao.selectByShopCenterIdAndStoreTypeId(
                        shopCenterId, enjoyTypeId
                );
        if(shopCenterStoresEntity == null) {
            shopCenterStoresEntity = insert(shopCenterId, enjoyTypeId);
        }

        shopCenterStoresEntity.setCount(shopCenterStoresEntity.getCount() + 1);
        shopCenterStoresDao.update(shopCenterStoresEntity);
    }
}
