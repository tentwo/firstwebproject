package despina.bazar.orm.service;

import despina.bazar.orm.dao.BazarBaseDao;
import despina.bazar.orm.entities.ContinentEntity;
import despina.general.exceptions.ExceptionORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ASUS on 9/14/2016.
 */
@Repository
public abstract class BazarBaseService {
    @Autowired
    protected BazarBaseDao bazarBaseDao;

    public abstract Class getEntityClass();

    public boolean deleteById(int id) throws ExceptionORM {
        return bazarBaseDao.deleteById(id, getEntityClass());
    }

    public <T> List<T> selectAll() {
        return bazarBaseDao.selectAll(getEntityClass());
    }

    public <T> T selectWithId(int id) {
        return bazarBaseDao.selectById(id, getEntityClass());
    }
}
