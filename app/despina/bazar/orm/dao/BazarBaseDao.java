package despina.bazar.orm.dao;

import despina.general.exceptions.ExceptionORM;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by ASUS on 9/11/2016.
 */
@Repository
@EnableTransactionManagement
public class BazarBaseDao {
    @PersistenceContext(unitName = "bazar-pu")
    EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED)
    public void insert(Object object) {
        entityManager.persist(object);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Object object) {
        entityManager.remove(object);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteById(int id, Class entityClazz) throws ExceptionORM {
        TypedQuery typedQuery = entityManager.createNamedQuery(
                entityClazz.getSimpleName() + ".DeleteById", entityClazz);
        typedQuery.setParameter("id", id);
        int i;
        try {
            i = typedQuery.executeUpdate();
        } catch (Exception e) {
            throw new ExceptionORM(e);
        }
        return i == 0? false : true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Object object) {
        entityManager.merge(object);
    }

//    @Transactional(propagation = Propagation.REQUIRED)
//    public <T, V> List<T> selectAll(V entityClazz) {
//        Class entityClazz1 = (Class) entityClazz;
//        StringBuilder selectBuilder = new StringBuilder("select p from ")
//                .append(entityClazz1.getName())
//                .append(" p;");
//        TypedQuery typedQuery = entityManager.createQuery(
//                selectBuilder.toString(), entityClazz1);
//        List<T> objects = typedQuery.getResultList();
//        return objects;
//    }

    @Transactional(propagation = Propagation.REQUIRED)
    public <T> List<T> selectAll(Class entityClazz) {
        TypedQuery<T> typedQuery = entityManager.createNamedQuery(
                entityClazz.getSimpleName() + ".SelectAll", entityClazz);
        List<T> objects = typedQuery.getResultList();
        return objects;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public <T> T selectById(int id, Class entityClazz) {
        return (T)entityManager.find(
                entityClazz, id);
    }

//    @Transactional(propagation = Propagation.REQUIRED)
//    public <T> T selectById(int id, Class entityClazz) {
//        TypedQuery<T> typedQuery = entityManager.createNamedQuery(
//                entityClazz.getSimpleName() + ".SelectById", entityClazz);
//        typedQuery.setParameter("id", id);
//        T singleResult = typedQuery.getSingleResult();
//        return singleResult;
//    }
}
