package edu.cmu.lti.oaqa.bio.bioasq.services;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.google.common.io.CharStreams;

public class GoPubMedPropertiesConfiguration {

  private Configuration config;

  public static final String REQUIRE_SESSION_URL = "require.session.url";

  public GoPubMedPropertiesConfiguration(String gopubmedPropertiesFilepath)
          throws ConfigurationException {
    this.config = new PropertiesConfiguration(gopubmedPropertiesFilepath);
  }

  public GoPubMedPropertiesConfiguration(Configuration config) {
    this.config = config;
  }

  public String getUrl(GoPubMedServiceKey service) throws MalformedURLException, IOException {
    String serviceUrl = config.getString(service.getKey());
    if (config.getBoolean(REQUIRE_SESSION_URL)) {
      return CharStreams.toString(new InputStreamReader(new URL(serviceUrl).openStream()));
    } else {
      return serviceUrl;
    }
  }

}
