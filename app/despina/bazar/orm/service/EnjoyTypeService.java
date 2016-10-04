package despina.bazar.orm.service;

import despina.bazar.orm.dao.BazarBaseDao;
import despina.bazar.orm.entities.EnjoyTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ASUS on 9/12/2016.
 */
@Repository
public class EnjoyTypeService extends BazarBaseService {
    @Override
    public Class getEntityClass() {
        return EnjoyTypeEntity.class;
    }

    public int insert(String title) {
        EnjoyTypeEntity enjoyTypeEntity = new EnjoyTypeEntity();
        enjoyTypeEntity.setTitle(title);
        bazarBaseDao.insert(enjoyTypeEntity);
        return enjoyTypeEntity.getId();
    }
}
