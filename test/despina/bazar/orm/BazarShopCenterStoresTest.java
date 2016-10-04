package despina.bazar.orm;

import despina.bazar.orm.entities.ContinentEntity;
import despina.bazar.orm.entities.ShopCenterEnjoysEntity;
import despina.bazar.orm.entities.ShopCenterStoresEntity;
import despina.bazar.orm.service.ContinentService;
import despina.bazar.orm.service.ShopCenterEnjoysService;
import despina.bazar.orm.service.ShopCenterStoresService;
import despina.general.exceptions.ExceptionORM;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by ASUS on 9/6/2016.
 */
public class BazarShopCenterStoresTest {
    @Test
    public void insert() throws UnsupportedEncodingException {
        ShopCenterStoresService shopCenterStoresService =
                DespinaBazarORMServiceProvider.getShopCenterStoresService();
        ShopCenterStoresEntity shopCenterStoresEntity =
                shopCenterStoresService.insert(2, 1);
        System.out.println(shopCenterStoresEntity.getId());
    }

    @Test
    public void deleteById() {
        ShopCenterStoresService shopCenterStoresService = DespinaBazarORMServiceProvider
                .getShopCenterStoresService();
        try {
            System.out.println(shopCenterStoresService.deleteById(2));
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
