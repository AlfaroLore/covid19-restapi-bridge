package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import facades.Covid19Facade;
import play.mvc.*;
import play.libs.Json;
import com.google.inject.Inject;
import models.Country;
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    public Covid19Facade covid19Facade;

    @Inject
    public HomeController(Covid19Facade covid19Facade){
        this.covid19Facade = covid19Facade;

    }
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render());
    }


    public Result returnCountryReport(String date, String code) {
        List<Country> countryList = this.covid19Facade.getCountryDailyReportByCode(date, code);
        JsonNode content = Json.toJson(countryList);
        return ok(content);
    }

}
