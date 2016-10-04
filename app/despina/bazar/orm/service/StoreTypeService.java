package despina.bazar.orm.service;

import despina.bazar.orm.dao.BazarBaseDao;
import despina.bazar.orm.entities.StoreTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ASUS on 9/12/2016.
 */
@Repository
public class StoreTypeService extends BazarBaseService {
    @Override
    public Class getEntityClass() {
        return StoreTypeEntity.class;
    }

    public int insert(String title) {
        StoreTypeEntity storeTypeService = new StoreTypeEntity();
        storeTypeService.setTitle(title);
        bazarBaseDao.insert(storeTypeService);
        return storeTypeService.getId();
    }
}
