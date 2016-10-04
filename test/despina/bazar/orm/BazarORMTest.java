package despina.bazar.orm;

import despina.bazar.orm.entities.ContinentEntity;
import despina.bazar.orm.service.ContinentService;
import despina.general.exceptions.ExceptionORM;
import org.junit.Test;

import java.util.List;

/**
 * Created by ASUS on 9/6/2016.
 */
public class BazarORMTest {
    @Test
    public void insert() {
        ContinentService continentService = DespinaBazarORMServiceProvider
                .getContinentService();
        continentService.insert("اقیانوسیه");
    }

    @Test
    public void deleteById() {
        ContinentService continentService = DespinaBazarORMServiceProvider
                .getContinentService();
        try {
            System.out.println(continentService.deleteById(6));
        } catch (ExceptionORM exceptionORM) {
            exceptionORM.printStackTrace();
        }
    }

    @Test
    public void selectAll() {
        ContinentService continentService = DespinaBazarORMServiceProvider
                .getContinentService();
        List<ContinentEntity> continentEntities = continentService.selectAll();
        for(ContinentEntity e : continentEntities) {
            System.out.println(e.getTitle());
        }
    }

    @Test
    public void selectById() {
        ContinentService continentService = DespinaBazarORMServiceProvider
                .getContinentService();
        ContinentEntity continentEntity = continentService.selectWithId(5);
        System.out.println(continentEntity.getTitle());
    }
}
