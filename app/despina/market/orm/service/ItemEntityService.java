package despina.market.orm.service;

import despina.market.orm.dao.ItemDAO;
import despina.market.orm.entities.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ASUS on 9/6/2016.
 */
@Repository
public class ItemEntityService {
    @Autowired
    ItemDAO itemDAO;

    public void insert(String title, int price) {
        this.itemDAO.insert(new ItemEntity(title, price));
    }
}
