package despina.bazar.orm.service;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import despina.bazar.orm.dao.BazarBaseDao;
import despina.bazar.orm.entities.ContinentEntity;
import despina.general.exceptions.ExceptionORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ASUS on 9/12/2016.
 */
@Repository
public class ContinentService extends BazarBaseService {
//    @Autowired
//    private BazarBaseDao bazarBaseDao;

    public Class getEntityClass() {
        return ContinentEntity.class;
    }

    public int insert(String title) {
        ContinentEntity continentEntity = new ContinentEntity();
        continentEntity.setTitle(title);
        bazarBaseDao.insert(continentEntity);
        return continentEntity.getId();
    }
}
