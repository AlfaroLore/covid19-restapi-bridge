package controllers;

import play.mvc.*;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */

public class HomeController extends Controller {

    public Result redirectDocs() {
        Result result= redirect("/assets/lib/swagger-ui/index.html");
        return result;

    }

}
