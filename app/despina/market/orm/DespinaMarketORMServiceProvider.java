package despina.market.orm;

import despina.market.orm.service.ItemEntityService;
import despina.market.orm.service.MarketServiceSpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by ASUS on 9/6/2016.
 */
public class DespinaMarketORMServiceProvider {
    private final static ApplicationContext applicationContext;

    static {
        applicationContext = new AnnotationConfigApplicationContext(MarketServiceSpringConfig.class);
    }

    ItemEntityService itemEntityService;

    public static ItemEntityService getItemEntityService() {
        return applicationContext.getBean(ItemEntityService.class);
    }
}
