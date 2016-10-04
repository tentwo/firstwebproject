package despina.bazar.controllers.views;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

/**
 * Created by ASUS on 9/25/2016.
 */
public class HomeController extends Controller {
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result bazar() {
        return ok(bazar.render("بازار"));
    }
}
