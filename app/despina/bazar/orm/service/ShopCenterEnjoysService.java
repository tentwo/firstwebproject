package despina.bazar.orm.service;

import despina.bazar.orm.dao.ShopCenterEnjoysDao;
import despina.bazar.orm.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ASUS on 9/12/2016.
 */
@Repository
public class ShopCenterEnjoysService extends BazarBaseService {
    @Autowired
    private ShopCenterEnjoysDao shopCenterEnjoysDao;

    @Override
    public Class getEntityClass() {
        return ShopCenterEnjoysEntity.class;
    }

    public ShopCenterEnjoysEntity insert(int shopCenterId, int enjoyTypeId) {
        ShopCenterEntity shopCenterEntity = bazarBaseDao.selectById(
                shopCenterId, ShopCenterEntity.class);
        EnjoyTypeEntity enjoyTypeEntity = bazarBaseDao.selectById(
                enjoyTypeId, EnjoyTypeEntity.class
        );
        ShopCenterEnjoysEntity shopCenterEnjoysEntity =
                new ShopCenterEnjoysEntity();
        shopCenterEnjoysEntity.setEnjoyTypeTitle(enjoyTypeEntity.getTitle());
        shopCenterEnjoysEntity.setEnjoyTypeByEnjoyTypeId(enjoyTypeEntity);
        shopCenterEnjoysEntity.setShopCenterByShopCenterId(shopCenterEntity);
        shopCenterEnjoysEntity.setCount(0);
        bazarBaseDao.insert(shopCenterEnjoysEntity);
        return shopCenterEnjoysEntity;
    }

    public void addCount(int shopCenterId, int enjoyTypeId) {
        ShopCenterEnjoysEntity shopCenterEnjoysEntity =
                shopCenterEnjoysDao.selectByShopCenterIdAndEnjoyTypeId(
                        shopCenterId, enjoyTypeId
                );
        if(shopCenterEnjoysEntity == null) {
            shopCenterEnjoysEntity = insert(shopCenterId, enjoyTypeId);
        }

        shopCenterEnjoysEntity.setCount(shopCenterEnjoysEntity.getCount() + 1);
        shopCenterEnjoysDao.update(shopCenterEnjoysEntity);
    }
}
