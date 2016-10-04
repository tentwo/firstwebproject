package despina.bazar.orm;

import despina.bazar.orm.entities.ContinentEntity;
import despina.bazar.orm.entities.ShopCenterEnjoysEntity;
import despina.bazar.orm.service.ContinentService;
import despina.bazar.orm.service.ShopCenterEnjoysService;
import despina.bazar.orm.service.ShopCenterService;
import despina.general.exceptions.ExceptionORM;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by ASUS on 9/6/2016.
 */
public class BazarShopCenterEnjoysTest {
    @Test
    public void insert() throws UnsupportedEncodingException {
        ShopCenterEnjoysService shopCenterEnjoysService =
                DespinaBazarORMServiceProvider.getShopCenterEnjoysService();
        ShopCenterEnjoysEntity shopCenterEnjoysEntity =
                shopCenterEnjoysService.insert(2, 1);
        System.out.println(shopCenterEnjoysEntity.getId());
    }

    @Test
    public void deleteById() {
        ShopCenterEnjoysService shopCenterEnjoysService = DespinaBazarORMServiceProvider
                .getShopCenterEnjoysService();
        try {
            System.out.println(shopCenterEnjoysService.deleteById(2));
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
