package despina.market.orm.dao;

import despina.market.orm.entities.ItemEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by ASUS on 9/6/2016.
 */
@Repository
public class ItemDAO {
    @PersistenceContext(unitName = "market-pu")
    EntityManager entityManager;

    @Transactional
    public void insert(ItemEntity itemEntity) {
        this.entityManager.persist(itemEntity);
    }
}
