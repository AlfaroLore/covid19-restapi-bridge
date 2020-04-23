package config;

import com.google.inject.Inject;
import play.api.Configuration;

import static config.Constants.Conf;

public class ConfigProvider {

    private final String rapidApiUrl;
    private final String rapidApiHost;
    private final String rapidApiKey;

    @Inject
    public ConfigProvider(final Configuration configuration) {
        this.rapidApiUrl = configuration.underlying().getString(Conf.App.BASE_URL);
        this.rapidApiHost = configuration.underlying().getString(Conf.Headers.RAPIDAPI_HOST);
        this.rapidApiKey = configuration.underlying().getString(Conf.Headers.RAPIDAPI_KEY);
    }

    public String getRapidApiConfigurationServiceBaseUrl() {
        return rapidApiUrl;
    }

    public String getRapidApiConfigurationServiceHost() {
        return rapidApiHost;
    }

    public String getRapidApiConfigurationServiceKey() {
        return rapidApiKey;
    }
}
