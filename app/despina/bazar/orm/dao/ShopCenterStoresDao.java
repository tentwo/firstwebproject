package despina.bazar.orm.dao;

import despina.bazar.orm.entities.ShopCenterStoresEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;

/**
 * Created by ASUS on 9/11/2016.
 */
@Repository
@EnableTransactionManagement
public class ShopCenterStoresDao extends BazarBaseDao {
    @Transactional(propagation = Propagation.REQUIRED)
    public ShopCenterStoresEntity selectByShopCenterIdAndStoreTypeId(
            int shopCenterId, int enjoyTypeId) {
        TypedQuery<ShopCenterStoresEntity> q = entityManager.createNamedQuery(
                "ShopCenterStoresEntity.SelectByShopCenterAndStoreType",
                ShopCenterStoresEntity.class);
        q.setParameter("storeTypeId", enjoyTypeId);
        q.setParameter("shopCenterId", shopCenterId);
        ShopCenterStoresEntity singleResult = q.getSingleResult();
        return singleResult;
    }

}
