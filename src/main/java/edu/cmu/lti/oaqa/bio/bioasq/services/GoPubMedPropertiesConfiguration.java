package edu.cmu.lti.oaqa.bio.bioasq.services;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.google.common.io.CharStreams;

class GoPubMedPropertiesConfiguration {

  private Configuration config;

  private static final String REQUIRE_SESSION_URL = "require.session.url";

  private static final String SESSION_REFRESH_INTERVAL = "session.refresh.interval";

  GoPubMedPropertiesConfiguration(String gopubmedPropertiesFilepath)
          throws ConfigurationException {
    this.config = new PropertiesConfiguration(gopubmedPropertiesFilepath);
  }

  GoPubMedPropertiesConfiguration(Configuration config) {
    this.config = config;
  }

  String getUrl(GoPubMedServiceKey service) throws IOException {
    String serviceUrl = config.getString(service.getKey());
    if (config.getBoolean(REQUIRE_SESSION_URL)) {
      return timeout(serviceUrl) ? updateSessionUrl(serviceUrl) : getSessionUrl(serviceUrl);
    } else {
      return serviceUrl;
    }
  }

  private Map<String, String> service2session = new HashMap<>();

  private Map<String, Calendar> service2timeout = new HashMap<>();

  private boolean timeout(String serviceUrl) {
    return !service2timeout.containsKey(serviceUrl)
            || Calendar.getInstance().after(service2timeout.get(serviceUrl));
  }

  private String updateSessionUrl(String serviceUrl) throws IOException {
    String sessionUrl = CharStreams
            .toString(new InputStreamReader(new URL(serviceUrl).openStream()));
    service2session.put(serviceUrl, sessionUrl);
    Calendar timeout = Calendar.getInstance();
    timeout.add(Calendar.MINUTE, config.getInt(SESSION_REFRESH_INTERVAL, 9));
    service2timeout.put(serviceUrl, timeout);
    return sessionUrl;
  }

  private String getSessionUrl(String serviceUrl) {
    return service2session.get(serviceUrl);
  }

}
