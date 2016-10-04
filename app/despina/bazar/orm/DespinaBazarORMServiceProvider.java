package despina.bazar.orm;

import despina.bazar.orm.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by ASUS on 9/6/2016.
 */
public class DespinaBazarORMServiceProvider {
    private final static ApplicationContext applicationContext;

    static {
        applicationContext = new AnnotationConfigApplicationContext(
                BazarServiceSpringConfig.class);
    }

    public static ContinentService getContinentService() {
        return applicationContext.getBean(ContinentService.class);
    }

    public static CountryService getCountryService() {
        return applicationContext.getBean(CountryService.class);
    }

    public static ProvinceService getProvinceService() {
        return applicationContext.getBean(ProvinceService.class);
    }

    public static CityService getCityService() {
        return applicationContext.getBean(CityService.class);
    }

    public static CityAreaService getCityAreaService() {
        return applicationContext.getBean(CityAreaService.class);
    }

    public static EnjoyTypeService getEnjoyTypeService() {
        return applicationContext.getBean(EnjoyTypeService.class);
    }

    public static StoreTypeService getStoreTypeService() {
        return applicationContext.getBean(StoreTypeService.class);
    }

    public static ShopCenterStoresService getShopCenterStoresService() {
        return applicationContext.getBean(ShopCenterStoresService.class);
    }

    public static ShopCenterEnjoysService getShopCenterEnjoysService() {
        return applicationContext.getBean(ShopCenterEnjoysService.class);
    }

    public static ShopCenterService getShopCenterService() {
        return applicationContext.getBean(ShopCenterService.class);
    }

    public static StoreService getStoreService() {
        return applicationContext.getBean(StoreService.class);
    }
}
