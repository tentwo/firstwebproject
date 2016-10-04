package despina.market.orm;

import despina.bazar.orm.DespinaBazarORMServiceProvider;
import despina.bazar.orm.entities.ContinentEntity;
import despina.bazar.orm.service.ContinentService;
import despina.market.orm.service.ItemEntityService;
import org.junit.Test;

import java.util.List;

/**
 * Created by ASUS on 9/6/2016.
 */
public class MarketORMTest {
    @Test
    public void insertItem() {
        ItemEntityService itemEntityService = DespinaMarketORMServiceProvider
                .getItemEntityService();
        itemEntityService.insert("پنیر", 10000);
    }
}
