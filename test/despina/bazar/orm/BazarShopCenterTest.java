package despina.bazar.orm;

import despina.bazar.orm.entities.ContinentEntity;
import despina.bazar.orm.service.ContinentService;
import despina.bazar.orm.service.ShopCenterService;
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
public class BazarShopCenterTest {
    @Test
    public void insert() throws UnsupportedEncodingException {
        ShopCenterService shopCenterService = DespinaBazarORMServiceProvider
                .getShopCenterService();
        int shopCenterId = shopCenterService.insert("تیراژه", 2, 1);
        System.out.println(shopCenterId);
    }

    @Test
    public void deleteById() {
        ShopCenterService shopCenterService = DespinaBazarORMServiceProvider
                .getShopCenterService();
        try {
            System.out.println(shopCenterService.deleteById(1));
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
