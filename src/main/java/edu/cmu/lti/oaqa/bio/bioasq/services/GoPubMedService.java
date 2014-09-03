package edu.cmu.lti.oaqa.bio.bioasq.services;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;

public final class GoPubMedService {

  private CloseableHttpClient httpClient;

  private Gson gson;

  private GoPubMedPropertiesConfiguration config;

  public GoPubMedService(String gopubmedPropertiesFilepath) throws IOException,
          ConfigurationException {
    httpClient = HttpClients.createSystem();
    gson = new Gson();
    config = new GoPubMedPropertiesConfiguration(gopubmedPropertiesFilepath);
  }

  public LinkedLifeDataServiceResponse.Result findLinkedLifeDataEntitiesPaged(String keywords,
          int page, int entitiesPerPage) throws ClientProtocolException, IOException {
    Map<String, Object[]> request = ImmutableMap.<String, Object[]> builder()
            .put("findEntitiesPaged", new Object[] { keywords, page, entitiesPerPage }).build();
    String response = postRequest(config.getUrl(GoPubMedServiceKey.LINKED_LIFE_DATA_SERVICE),
            gson.toJson(request));
    return gson.fromJson(response, LinkedLifeDataServiceResponse.class).getResult();
  }

  public PubMedSearchServiceResponse.Result findPubMedCitations(String keywords, int page,
          int articlesPerPage) throws ClientProtocolException, IOException {
    Map<String, Object[]> request = ImmutableMap.<String, Object[]> builder()
            .put("findPubMedCitations", new Object[] { keywords, page, articlesPerPage }).build();
    String response = postRequest(config.getUrl(GoPubMedServiceKey.PUBMED_SEARCH_SERVICE),
            gson.toJson(request));
    return gson.fromJson(response, PubMedSearchServiceResponse.class).getResult();
  }

  public OntologyServiceResponse.Result findUniprotEntitiesPaged(String keywords, int page,
          int conceptsPerPage) throws ClientProtocolException, IOException {
    return findOntologyEntitiesPaged(config.getUrl(GoPubMedServiceKey.UNIPROT_SERVICE), keywords,
            page, conceptsPerPage);
  }

  public OntologyServiceResponse.Result findMeshEntitiesPaged(String keywords, int page,
          int conceptsPerPage) throws ClientProtocolException, IOException {
    return findOntologyEntitiesPaged(config.getUrl(GoPubMedServiceKey.MESH_SERVICE), keywords,
            page, conceptsPerPage);
  }

  public OntologyServiceResponse.Result findJochemEntitiesPaged(String keywords, int page,
          int conceptsPerPage) throws ClientProtocolException, IOException {
    return findOntologyEntitiesPaged(config.getUrl(GoPubMedServiceKey.JOCHEM_SERVICE), keywords,
            page, conceptsPerPage);
  }

  public OntologyServiceResponse.Result findGeneOntologyEntitiesPaged(String keywords, int page,
          int conceptsPerPage) throws ClientProtocolException, IOException {
    return findOntologyEntitiesPaged(config.getUrl(GoPubMedServiceKey.GENE_ONTOLOGY_SERVICE),
            keywords, page, conceptsPerPage);
  }

  public OntologyServiceResponse.Result findDiseaseOntologyEntitiesPaged(String keywords, int page,
          int conceptsPerPage) throws ClientProtocolException, IOException {
    return findOntologyEntitiesPaged(config.getUrl(GoPubMedServiceKey.DISEASE_ONTOLOGY_SERVICE),
            keywords, page, conceptsPerPage);
  }

  private OntologyServiceResponse.Result findOntologyEntitiesPaged(String serviceSessionUrl,
          String keywords, int page, int conceptsPerPage) throws ClientProtocolException,
          IOException {
    Map<String, Object[]> request = ImmutableMap.<String, Object[]> builder()
            .put("findEntitiesPaged", new Object[] { keywords, page, conceptsPerPage }).build();
    String response = postRequest(serviceSessionUrl, gson.toJson(request));
    return gson.fromJson(response, OntologyServiceResponse.class).getResult();
  }

  private String postRequest(String serviceSessionUrl, String jsonString) throws IOException {
    HttpEntity entity = MultipartEntityBuilder
            .create()
            .addTextBody("json", jsonString, ContentType.create("application/json", Charsets.UTF_8))
            .build();
    HttpPost post = new HttpPost(serviceSessionUrl);
    post.setEntity(entity);
    CloseableHttpResponse response = httpClient.execute(post);
    try {
      return EntityUtils.toString(response.getEntity());
    } finally {
      response.close();
    }
  }

  public void close() throws IOException {
    httpClient.close();
  }

}