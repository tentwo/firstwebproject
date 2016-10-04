package controllers;

//import despina.market.orm.DespinaMarketORMServiceProvider;
//import despina.market.orm.service.ItemEntityService;
import play.mvc.*;

import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's bazar page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
//        ItemEntityService itemEntityService = DespinaMarketORMServiceProvider.getItemEntityService();
//        itemEntityService.insert("پنیر آمل", 10000);
        return ok(index.render("Your new application is ready."));
    }

    public Result home() {
//        ItemEntityService itemEntityService = DespinaMarketORMServiceProvider.getItemEntityService();
//        itemEntityService.insert("پنیر آمل", 10000);
        return ok(home.render("Your new application is ready."));
    }

}
