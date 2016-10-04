package despina.bazar.controllers.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import despina.bazar.orm.DespinaBazarORMServiceProvider;
import despina.bazar.orm.entities.ContinentEntity;
import despina.bazar.orm.entities.StoreEntity;
import despina.bazar.orm.service.ContinentService;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import java.util.List;
import java.util.Map;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's bazar page.
 */
public class ContinentController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result getAllContinent() {
        ContinentService modelService =
                DespinaBazarORMServiceProvider.getContinentService();
        List<Object> models = modelService.selectAll();

        JsonNode jsonNode = Json.toJson(models);
        return ok(jsonNode);
    }

    /**
     * Get with url param
     * @param id
     * @return
     */
    public Result getContinentById(int id) {
        ContinentService modelService =
                DespinaBazarORMServiceProvider.getContinentService();
        Object model = modelService.selectWithId(id);

        JsonNode jsonNode = Json.toJson(model);
        return ok(jsonNode);
    }

    /**
     * Get with path param
     * @param id
     * @return
     */
    public Result getContinentByIdPath(int id) {
        ContinentService modelService =
                DespinaBazarORMServiceProvider.getContinentService();
        Object model = modelService.selectWithId(id);

        JsonNode jsonNode = Json.toJson(model);
        return ok(jsonNode);
    }

    /**
     * Post with url param
     * @param id
     * @return
     */
    public Result postContinentById(int id) {
        ContinentService modelService =
                DespinaBazarORMServiceProvider.getContinentService();
        Object model = modelService.selectWithId(id);

        JsonNode jsonNode = Json.toJson(model);
        return ok(jsonNode);
    }

    /**
     * Post with path param
     * @param id
     * @return
     */
    public Result postContinentByIdPath(int id) {
        ContinentService modelService =
                DespinaBazarORMServiceProvider.getContinentService();
        Object model = modelService.selectWithId(id);

        JsonNode jsonNode = Json.toJson(model);
        return ok(jsonNode);
    }

    /**
     * Post with body
     * @return
     */
    public Result postInsertContinent() {
        String id = request().getQueryString("id");
        Map<String, String[]> stringMap = request().queryString();
        JsonNode jsonNode = request().body().asJson();
        ContinentService continentService =
                DespinaBazarORMServiceProvider.getContinentService();

        ObjectMapper mapper = new ObjectMapper();
        ContinentEntity continentEntity = null;
        try {
            continentEntity = mapper.treeToValue(jsonNode, ContinentEntity.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ok(jsonNode);
    }

    /**
     * Post with url param
     * @param id
     * @return
     */
    public Result putContinentById(int id) {
        ContinentService modelService =
                DespinaBazarORMServiceProvider.getContinentService();
        Object model = modelService.selectWithId(id);

        JsonNode jsonNode = Json.toJson(model);
        return ok(jsonNode);
    }

    /**
     * Post with path param
     * @param id
     * @return
     */
    public Result putContinentByIdPath(int id) {
        ContinentService modelService =
                DespinaBazarORMServiceProvider.getContinentService();
        Object model = modelService.selectWithId(id);

        JsonNode jsonNode = Json.toJson(model);
        return ok(jsonNode);
    }

    /**
     * Post with body
     * @return
     */
    public Result putInsertContinent() {
        String id = request().getQueryString("id");
        Map<String, String[]> stringMap = request().queryString();
        JsonNode jsonNode = request().body().asJson();
        ContinentService continentService =
                DespinaBazarORMServiceProvider.getContinentService();

        ObjectMapper mapper = new ObjectMapper();
        ContinentEntity continentEntity = null;
        try {
            continentEntity = mapper.treeToValue(jsonNode, ContinentEntity.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ok(jsonNode);
    }

    /**
     * Post with url param
     * @param id
     * @return
     */
    public Result deleteContinentById(int id) {
        ContinentService modelService =
                DespinaBazarORMServiceProvider.getContinentService();
        Object model = modelService.selectWithId(id);

        JsonNode jsonNode = Json.toJson(model);
        return ok(jsonNode);
    }

    /**
     * Post with path param
     * @param id
     * @return
     */
    public Result deleteContinentByIdPath(int id) {
        ContinentService modelService =
                DespinaBazarORMServiceProvider.getContinentService();
        Object model = modelService.selectWithId(id);

        JsonNode jsonNode = Json.toJson(model);
        return ok(jsonNode);
    }

    /**
     * Post with body
     * @return
     */
    public Result deleteInsertContinent() {
        String id = request().getQueryString("id");
        Map<String, String[]> stringMap = request().queryString();
        JsonNode jsonNode = request().body().asJson();
        ContinentService continentService =
                DespinaBazarORMServiceProvider.getContinentService();

        ObjectMapper mapper = new ObjectMapper();
        ContinentEntity continentEntity = null;
        try {
            continentEntity = mapper.treeToValue(jsonNode, ContinentEntity.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ok(jsonNode);
    }
}
