package facades;


import play.libs.Json;
import org.apache.http.HttpResponse;
import org.apache.http.HttpHost;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.*;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.inject.Inject;
import play.Logger;

import java.util.List;
import java.util.ArrayList;
import models.Country;
import config.ConfigProvider;

public class Covid19Facade {

    private final ConfigProvider conf;

    @Inject
    public Covid19Facade(ConfigProvider conf){ this.conf = conf; }

    public List<Country> getCountryDailyReportByCode(String date, String code) {

        //TODO. Add Handle Exception to return HTTP Missing params status

        HttpClient httpclient = HttpClientBuilder.create().build();
        try {

            HttpGet getRequest = new HttpGet(String.format("%s/report/country/code?format=json&date-format=YYYY-MM-DD&date=%s&code=%s",
                    this.conf.getRapidApiConfigurationServiceBaseUrl(),
                    date,
                    code));

            getRequest.addHeader("x-rapidapi-host", this.conf.getRapidApiConfigurationServiceHost());
            getRequest.addHeader("x-rapidapi-key", this.conf.getRapidApiConfigurationServiceKey());


            HttpResponse httpResponse = httpclient.execute(getRequest);
            HttpEntity entity = httpResponse.getEntity();

            if (entity != null) {
                String body = EntityUtils.toString(entity);

                List<Country> list = Json.mapper().readValue(body, new TypeReference<List<Country>>(){});

                Logger.info(">>> Report retrieved: " + list.size());

                return list;
            }

        } catch (Exception e) {
            e.printStackTrace();
            //TODO. Add Handler Exception to return HTTP Bad Request status
        } finally {
            httpclient.getConnectionManager().shutdown();
        }

        return new ArrayList<>();

    }

}
