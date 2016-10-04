package despina.bazar.controllers.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import despina.bazar.orm.DespinaBazarORMServiceProvider;
import despina.bazar.orm.entities.ContinentEntity;
import despina.bazar.orm.entities.CountryEntity;
import despina.bazar.orm.service.ContinentService;
import despina.bazar.orm.service.CountryService;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's bazar page.
 */
public class CountryController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result getAllModels() {
        CountryService modelService =
                DespinaBazarORMServiceProvider.getCountryService();
        List<CountryEntity> models = modelService.selectAll();

        JsonNode jsonNode = Json.toJson(models);
        return ok(jsonNode);
    }

    /**
     * Get with url param
     * @param id
     * @return
     */
    public Result getModelById(int id) {
        CountryService modelService =
                DespinaBazarORMServiceProvider.getCountryService();
        CountryEntity model = modelService.selectWithId(id);

        JsonNode jsonNode = Json.toJson(model);
        return ok(jsonNode);
    }

    /**
     * Get with path param
     * @param id
     * @return
     */
    public Result getContinentByIdPath(int id) {
        ContinentService continentService =
                DespinaBazarORMServiceProvider.getContinentService();
        ContinentEntity continentEntity = continentService.selectWithId(id);

        JsonNode jsonNode = Json.toJson(continentEntity);
        return ok(jsonNode);
    }

    /**
     * Post with url param
     * @param id
     * @return
     */
    public Result postContinentById(int id) {
        ContinentService continentService =
                DespinaBazarORMServiceProvider.getContinentService();
        ContinentEntity continentEntity = continentService.selectWithId(id);

        JsonNode jsonNode = Json.toJson(continentEntity);
        return ok(jsonNode);
    }

    /**
     * Post with path param
     * @param id
     * @return
     */
    public Result postContinentByIdPath(int id) {
        ContinentService continentService =
                DespinaBazarORMServiceProvider.getContinentService();
        ContinentEntity continentEntity = continentService.selectWithId(id);

        JsonNode jsonNode = Json.toJson(continentEntity);
        return ok(jsonNode);
    }

    /**
     * Post with body
     * @return
     */
    public Result postInsertContinent() {
        JsonNode json = request().body().asJson();
        ContinentService continentService =
                DespinaBazarORMServiceProvider.getContinentService();

        ObjectMapper mapper = new ObjectMapper();
        ContinentEntity continentEntity = null;
        try {
            continentEntity = mapper.treeToValue(json, ContinentEntity.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ok();
    }
}
