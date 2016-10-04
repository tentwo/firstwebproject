package controllers;

import despina.bazar.orm.entities.StoreEntity;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's bazar page.
 */
public class StoreController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result getStore() {
        List<StoreEntity> storeEntities = new ArrayList<>();
        StoreEntity storeEntity1 = new StoreEntity();
        storeEntity1.setId(1);
        storeEntity1.setFloor(1);
        storeEntity1.setNumber(2);
        storeEntity1.setPicture("assets/images/1.png");
        storeEntity1.setTitle("two");
        storeEntities.add(storeEntity1);

        StoreEntity storeEntity2 = new StoreEntity();
        storeEntity2.setId(2);
        storeEntity2.setFloor(1);
        storeEntity2.setNumber(2);
        storeEntity2.setPicture("assets/images/2.jpg");
        storeEntity2.setTitle("two");
        storeEntities.add(storeEntity2);

        StoreEntity storeEntity3 = new StoreEntity();
        storeEntity3.setId(3);
        storeEntity3.setFloor(1);
        storeEntity3.setNumber(2);
        storeEntity3.setPicture("assets/images/3.jpg");
        storeEntity3.setTitle("three");
        storeEntities.add(storeEntity3);

        StoreEntity storeEntity4 = new StoreEntity();
        storeEntity4.setId(4);
        storeEntity4.setFloor(1);
        storeEntity4.setNumber(2);
        storeEntity4.setPicture("assets/images/4.jpg");
        storeEntity4.setTitle("four");
        storeEntities.add(storeEntity4);

        StoreEntity storeEntity5 = new StoreEntity();
        storeEntity5.setId(5);
        storeEntity5.setFloor(1);
        storeEntity5.setNumber(2);
        storeEntity5.setPicture("assets/images/5.jpg");
        storeEntity5.setTitle("five");
        storeEntities.add(storeEntity5);

        return ok(Json.toJson(storeEntities));
    }

}
