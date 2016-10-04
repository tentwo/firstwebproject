package despina.bazar.orm;

import despina.bazar.orm.entities.ContinentEntity;
import despina.bazar.orm.entities.StoreEntity;
import despina.bazar.orm.service.ContinentService;
import despina.bazar.orm.service.StoreService;
import despina.bazar.orm.service.StoreTypeService;
import despina.general.exceptions.ExceptionORM;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by ASUS on 9/6/2016.
 */
public class BazarStoreTest {
    @Test
    public void insert() throws UnsupportedEncodingException {
        StoreService storeService = DespinaBazarORMServiceProvider
                .getStoreService();
        StoreEntity storeEntity = storeService.insert("ماهان پیتزا", 2, 1, 1, 2,
                "02133889872", "09128855402", "علی محمدی", true, true);
        System.out.println(storeEntity.getId());
    }

    @Test
    public void deleteById() {
        StoreService storeService = DespinaBazarORMServiceProvider
                .getStoreService();
        try {
            System.out.println(storeService.deleteById(2));
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
