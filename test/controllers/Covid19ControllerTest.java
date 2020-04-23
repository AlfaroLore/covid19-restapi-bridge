package controllers;
import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.route;

public class Covid19ControllerTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Test
    public void testGetReportByCountryAndDate() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/country?date=2020-04-01&code=it");

        Result result = route(app, request);
        assertEquals(OK, result.status());
    }
}
