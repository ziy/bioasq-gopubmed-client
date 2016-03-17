package edu.cmu.lti.oaqa.bio.bioasq.services;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;

public final class GoPubMedService {

  private static final int DEFAULT_ENTITIES_PER_PAGE = 100;

  private static final int DEFAULT_ARTICLES_PER_PAGE = 100;

  private static final int DEFAULT_CONCEPTS_PER_PAGE = 100;

  private CloseableHttpClient httpClient;

  private Gson gson;

  private GoPubMedPropertiesConfiguration config;

  private DefaultHttpRequestRetryHandler retryHandler;

  public GoPubMedService(String gopubmedPropertiesFilepath) throws ConfigurationException {
    this(new GoPubMedPropertiesConfiguration(gopubmedPropertiesFilepath));
  }

  public GoPubMedService(Configuration gopubmedConfiguration) {
    this(new GoPubMedPropertiesConfiguration(gopubmedConfiguration));
  }

  private GoPubMedService(GoPubMedPropertiesConfiguration config) {
    retryHandler = new DefaultHttpRequestRetryHandler(10, true);
    httpClient = HttpClientBuilder.create().useSystemProperties().setRetryHandler(retryHandler)
            .build();
    gson = new Gson();
    this.config = config;
  }

  public LinkedLifeDataServiceResponse.Result findLinkedLifeDataEntitiesPaged(String keywords,
          int page, int entitiesPerPage) throws IOException {
    Map<String, ?> request = ImmutableMap
            .of("findEntitiesPaged", new Object[] { keywords, page, entitiesPerPage });
    String response = postRequest(config.getUrl(GoPubMedServiceKey.LINKED_LIFE_DATA_SERVICE),
            gson.toJson(request));
    return gson.fromJson(response, LinkedLifeDataServiceResponse.class).getResult();
  }

  public LinkedLifeDataServiceResponse.Result findLinkedLifeDataEntitiesPaged(String keywords,
          int page) throws IOException {
    return findLinkedLifeDataEntitiesPaged(keywords, page, DEFAULT_ENTITIES_PER_PAGE);
  }

  public PubMedSearchServiceResponse.Result findPubMedCitations(String keywords, int page,
          int articlesPerPage) throws IOException {
    Map<String, ?> request = ImmutableMap
            .of("findPubMedCitations", new Object[] { keywords, page, articlesPerPage });
    String response = postRequest(config.getUrl(GoPubMedServiceKey.PUBMED_SEARCH_SERVICE),
            gson.toJson(request));
    return gson.fromJson(response, PubMedSearchServiceResponse.class).getResult();
  }

  public PubMedSearchServiceResponse.Result findPubMedCitations(String keywords, int page)
          throws IOException {
    return findPubMedCitations(keywords, page, DEFAULT_ARTICLES_PER_PAGE);
  }

  public OntologyServiceResponse.Result findUniprotEntitiesPaged(String keywords, int page,
          int conceptsPerPage) throws IOException {
    return findOntologyEntitiesPaged(config.getUrl(GoPubMedServiceKey.UNIPROT_SERVICE), keywords,
            page, conceptsPerPage);
  }

  public OntologyServiceResponse.Result findUniprotEntitiesPaged(String keywords, int page)
          throws IOException {
    return findUniprotEntitiesPaged(keywords, page, DEFAULT_CONCEPTS_PER_PAGE);
  }

  public OntologyServiceResponse.Result findMeshEntitiesPaged(String keywords, int page,
          int conceptsPerPage) throws IOException {
    return findOntologyEntitiesPaged(config.getUrl(GoPubMedServiceKey.MESH_SERVICE), keywords, page,
            conceptsPerPage);
  }

  public OntologyServiceResponse.Result findMeshEntitiesPaged(String keywords, int page)
          throws IOException {
    return findMeshEntitiesPaged(keywords, page, DEFAULT_CONCEPTS_PER_PAGE);
  }

  public OntologyServiceResponse.Result findJochemEntitiesPaged(String keywords, int page,
          int conceptsPerPage) throws IOException {
    return findOntologyEntitiesPaged(config.getUrl(GoPubMedServiceKey.JOCHEM_SERVICE), keywords,
            page, conceptsPerPage);
  }

  public OntologyServiceResponse.Result findJochemEntitiesPaged(String keywords, int page)
          throws IOException {
    return findJochemEntitiesPaged(keywords, page, DEFAULT_CONCEPTS_PER_PAGE);
  }

  public OntologyServiceResponse.Result findGeneOntologyEntitiesPaged(String keywords, int page,
          int conceptsPerPage) throws IOException {
    return findOntologyEntitiesPaged(config.getUrl(GoPubMedServiceKey.GENE_ONTOLOGY_SERVICE),
            keywords, page, conceptsPerPage);
  }

  public OntologyServiceResponse.Result findGeneOntologyEntitiesPaged(String keywords, int page)
          throws IOException {
    return findGeneOntologyEntitiesPaged(keywords, page, DEFAULT_CONCEPTS_PER_PAGE);
  }

  public OntologyServiceResponse.Result findDiseaseOntologyEntitiesPaged(String keywords, int page,
          int conceptsPerPage) throws IOException {
    return findOntologyEntitiesPaged(config.getUrl(GoPubMedServiceKey.DISEASE_ONTOLOGY_SERVICE),
            keywords, page, conceptsPerPage);
  }

  public OntologyServiceResponse.Result findDiseaseOntologyEntitiesPaged(String keywords, int page)
          throws IOException {
    return findDiseaseOntologyEntitiesPaged(keywords, page, DEFAULT_CONCEPTS_PER_PAGE);
  }

  private OntologyServiceResponse.Result findOntologyEntitiesPaged(String serviceSessionUrl,
          String keywords, int page, int conceptsPerPage) throws IOException {
    Map<String, ?> request = ImmutableMap
            .of("findEntitiesPaged", new Object[] { keywords, page, conceptsPerPage });
    String response = postRequest(serviceSessionUrl, gson.toJson(request));
    return gson.fromJson(response, OntologyServiceResponse.class).getResult();
  }

  private String postRequest(String serviceSessionUrl, String jsonString) throws IOException {
    HttpEntity entity = MultipartEntityBuilder.create()
            .addTextBody("json", jsonString, ContentType.create("application/json", Charsets.UTF_8))
            .build();
    HttpPost post = new HttpPost(serviceSessionUrl);
    post.setEntity(entity);
    String result = null;
    try (CloseableHttpResponse response = httpClient.execute(post)) {
      result = EntityUtils.toString(response.getEntity());
    } catch (IOException e) {
      throwClientSideException(jsonString, serviceSessionUrl, e);
    }
    throwServerSideException(result, jsonString, serviceSessionUrl);
    return result;
  }

  private void throwClientSideException(String request, String url, IOException e)
          throws IOException {
    System.out.println("[ERROR] Client side error");
    System.out.println("  Request: " + request);
    System.out.println("  Server URL: " + url);
    System.out.println("  Retry count: " + retryHandler.getRetryCount());
    throw e;
  }

  @SuppressWarnings("unchecked")
  private void throwServerSideException(String result, String request, String url)
          throws IOException {
    Map<String, String> resultMap = null;
    try {
      resultMap = gson.fromJson(result, Map.class);
    } catch (Exception e) {
      System.out.println("result string: " + result);
    }
    String exceptionString = resultMap.get("exception");
    if (exceptionString != null) {
      String[] segs = exceptionString.split(":", 2);
      Exception exception;
      try {
        exception = Class.forName(segs[0]).asSubclass(Exception.class).getConstructor(String.class)
                .newInstance(segs[1]);
      } catch (Exception e) {
        exception = new Exception(exceptionString);
      }
      System.out.println("[ERROR] Server side error");
      System.out.println("  Request: " + request);
      System.out.println("  Server URL: " + url);
      System.out.println("  Retry count: " + retryHandler.getRetryCount());
      throw new IOException(exception);
    }
  }

  public void close() throws IOException {
    httpClient.close();
  }

}