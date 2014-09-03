package edu.cmu.lti.oaqa.bio.bioasq.services;

public enum GoPubMedServiceKey {

  PUBMED_SEARCH_SERVICE("pubmed.search.service"), LINKED_LIFE_DATA_SERVICE(
          "linked.life.data.service"), DISEASE_ONTOLOGY_SERVICE("disease.ontology.service"), GENE_ONTOLOGY_SERVICE(
          "gene.ontology.service"), JOCHEM_SERVICE("jochem.service"), MESH_SERVICE("mesh.service"), UNIPROT_SERVICE(
          "uniprot.service");

  private String key;

  GoPubMedServiceKey(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }

}