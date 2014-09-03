package edu.cmu.lti.oaqa.bio.bioasq.services;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.http.client.ClientProtocolException;

public class GoPubMedServiceExample {

  public static void main(String[] args) throws ClientProtocolException, IOException,
          ConfigurationException {
    GoPubMedService service = new GoPubMedService(args[0]);
    OntologyServiceResponse.Result diseaseOntologyResult = service
            .findDiseaseOntologyEntitiesPaged("nitric oxide", 0, 10);
    System.out.println(diseaseOntologyResult.getFindings().size());
    OntologyServiceResponse.Result geneOntologyResult = service.findGeneOntologyEntitiesPaged(
            "nitric oxide synthase", 0, 10);
    System.out.println(geneOntologyResult.getFindings().size());
    OntologyServiceResponse.Result jochemResult = service.findJochemEntitiesPaged(
            "nitric oxide synthase", 0, 10);
    System.out.println(jochemResult.getFindings().size());
    OntologyServiceResponse.Result meshResult = service.findMeshEntitiesPaged(
            "nitric oxide synthase", 0, 10);
    System.out.println(meshResult.getFindings().size());
    OntologyServiceResponse.Result uniprotResult = service.findUniprotEntitiesPaged(
            "nitric oxide synthase", 0, 10);
    System.out.println(uniprotResult.getFindings().size());
    PubMedSearchServiceResponse.Result pubmedResult = service.findPubMedCitations(
            "nitric oxide synthase", 0, 10);
    System.out.println(pubmedResult.getDocuments().size());
    LinkedLifeDataServiceResponse.Result linkedLifeDataResult = service
            .findLinkedLifeDataEntitiesPaged("nitric oxide synthase", 0, 10);
    System.out.println(linkedLifeDataResult.getEntities().size());
  }

}
