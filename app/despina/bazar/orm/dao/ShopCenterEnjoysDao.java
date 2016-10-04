package despina.bazar.orm.dao;

import despina.bazar.orm.entities.ShopCenterEnjoysEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by ASUS on 9/11/2016.
 */
@Repository
@EnableTransactionManagement
public class ShopCenterEnjoysDao extends BazarBaseDao {
    @Transactional(propagation = Propagation.REQUIRED)
    public ShopCenterEnjoysEntity selectByShopCenterIdAndEnjoyTypeId(
            int shopCenterId, int enjoyTypeId) {
        TypedQuery<ShopCenterEnjoysEntity> q = entityManager.createNamedQuery(
                "ShopCenterEnjoysEntity.SelectByShopCenterAndEnjoyType",
                ShopCenterEnjoysEntity.class);
        q.setParameter("enjoyTypeId", enjoyTypeId);
        q.setParameter("shopCenterId", shopCenterId);
        ShopCenterEnjoysEntity singleResult = q.getSingleResult();
        return singleResult;
    }

}
