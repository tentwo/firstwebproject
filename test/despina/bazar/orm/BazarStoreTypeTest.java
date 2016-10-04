package despina.bazar.orm;

import despina.bazar.orm.entities.ContinentEntity;
import despina.bazar.orm.service.ContinentService;
import despina.bazar.orm.service.StoreTypeService;
import despina.general.exceptions.ExceptionORM;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by ASUS on 9/6/2016.
 */
public class BazarStoreTypeTest {
    @Test
    public void insert() throws UnsupportedEncodingException {
        StoreTypeService storeTypeService = DespinaBazarORMServiceProvider
                .getStoreTypeService();
        int storeTypeId = storeTypeService.insert("فست فود");
        System.out.println(storeTypeId);
    }

    @Test
    public void deleteById() {
        StoreTypeService storeTypeService = DespinaBazarORMServiceProvider
                .getStoreTypeService();
        try {
            System.out.println(storeTypeService.deleteById(2));
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
