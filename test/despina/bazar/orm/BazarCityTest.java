package despina.bazar.orm;

import despina.bazar.orm.entities.ContinentEntity;
import despina.bazar.orm.service.CityService;
import despina.bazar.orm.service.ContinentService;
import despina.bazar.orm.service.CountryService;
import despina.general.exceptions.ExceptionORM;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by ASUS on 9/6/2016.
 */
public class BazarCityTest {
    @Test
    public void insert() throws UnsupportedEncodingException {
        CityService cityService = DespinaBazarORMServiceProvider
                .getCityService();
        cityService.insert("تهران", 2);
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
