package despina.bazar.orm;

import despina.bazar.orm.entities.ContinentEntity;
import despina.bazar.orm.service.ContinentService;
import despina.bazar.orm.service.EnjoyTypeService;
import despina.bazar.orm.service.StoreTypeService;
import despina.general.exceptions.ExceptionORM;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by ASUS on 9/6/2016.
 */
public class BazarEnjoyTypeTest {
    @Test
    public void insert() throws UnsupportedEncodingException {
        EnjoyTypeService enjoyTypeService = DespinaBazarORMServiceProvider
                .getEnjoyTypeService();
        int enjoyTypeId = enjoyTypeService.insert("سینما");
        System.out.println(enjoyTypeId);
    }

    @Test
    public void deleteById() {
        EnjoyTypeService enjoyTypeService = DespinaBazarORMServiceProvider
                .getEnjoyTypeService();
        try {
            System.out.println(enjoyTypeService.deleteById(2));
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
