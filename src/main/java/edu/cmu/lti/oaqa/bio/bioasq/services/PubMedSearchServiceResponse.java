package edu.cmu.lti.oaqa.bio.bioasq.services;

import java.util.List;

public class PubMedSearchServiceResponse {

  public static final class Uri {

    private String id;

    private String namespace;

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((namespace == null) ? 0 : namespace.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Uri other = (Uri) obj;
      if (id == null) {
        if (other.id != null)
          return false;
      } else if (!id.equals(other.id))
        return false;
      if (namespace == null) {
        if (other.namespace != null)
          return false;
      } else if (!namespace.equals(other.namespace))
        return false;
      return true;
    }

    public String getId() {
      return id;
    }

    public String getNamespace() {
      return namespace;
    }

  }

  public static final class MeshAnnotation {

    private String termLabel;

    private Uri uri;

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((termLabel == null) ? 0 : termLabel.hashCode());
      result = prime * result + ((uri == null) ? 0 : uri.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      MeshAnnotation other = (MeshAnnotation) obj;
      if (termLabel == null) {
        if (other.termLabel != null)
          return false;
      } else if (!termLabel.equals(other.termLabel))
        return false;
      if (uri == null) {
        if (other.uri != null)
          return false;
      } else if (!uri.equals(other.uri))
        return false;
      return true;
    }

    public String getTermLabel() {
      return termLabel;
    }

    public Uri getUri() {
      return uri;
    }

  }

  public static final class Document {

    private String documentAbstract;

    private boolean fulltextAvailable;

    private String journal;

    private List<MeshAnnotation> meshAnnotations;

    private List<String> meshHeading;

    private String pmid;

    private String title;

    private String year;

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((documentAbstract == null) ? 0 : documentAbstract.hashCode());
      result = prime * result + (fulltextAvailable ? 1231 : 1237);
      result = prime * result + ((journal == null) ? 0 : journal.hashCode());
      result = prime * result + ((meshAnnotations == null) ? 0 : meshAnnotations.hashCode());
      result = prime * result + ((meshHeading == null) ? 0 : meshHeading.hashCode());
      result = prime * result + ((pmid == null) ? 0 : pmid.hashCode());
      result = prime * result + ((title == null) ? 0 : title.hashCode());
      result = prime * result + ((year == null) ? 0 : year.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Document other = (Document) obj;
      if (documentAbstract == null) {
        if (other.documentAbstract != null)
          return false;
      } else if (!documentAbstract.equals(other.documentAbstract))
        return false;
      if (fulltextAvailable != other.fulltextAvailable)
        return false;
      if (journal == null) {
        if (other.journal != null)
          return false;
      } else if (!journal.equals(other.journal))
        return false;
      if (meshAnnotations == null) {
        if (other.meshAnnotations != null)
          return false;
      } else if (!meshAnnotations.equals(other.meshAnnotations))
        return false;
      if (meshHeading == null) {
        if (other.meshHeading != null)
          return false;
      } else if (!meshHeading.equals(other.meshHeading))
        return false;
      if (pmid == null) {
        if (other.pmid != null)
          return false;
      } else if (!pmid.equals(other.pmid))
        return false;
      if (title == null) {
        if (other.title != null)
          return false;
      } else if (!title.equals(other.title))
        return false;
      if (year == null) {
        if (other.year != null)
          return false;
      } else if (!year.equals(other.year))
        return false;
      return true;
    }

    public String getDocumentAbstract() {
      return documentAbstract;
    }

    public boolean isFulltextAvailable() {
      return fulltextAvailable;
    }

    public String getJournal() {
      return journal;
    }

    public List<MeshAnnotation> getMeshAnnotations() {
      return meshAnnotations;
    }

    public List<String> getMeshHeading() {
      return meshHeading;
    }

    public String getPmid() {
      return pmid;
    }

    public String getTitle() {
      return title;
    }

    public String getYear() {
      return year;
    }

  }

  public static final class Result {

    private int articlesPerPage;

    private List<Document> documents;

    private String fullPubmedQuery;

    private String keywords;

    private String maxDate;

    private int page;

    private int size;

    private int timeMS;

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + articlesPerPage;
      result = prime * result + ((documents == null) ? 0 : documents.hashCode());
      result = prime * result + ((fullPubmedQuery == null) ? 0 : fullPubmedQuery.hashCode());
      result = prime * result + ((keywords == null) ? 0 : keywords.hashCode());
      result = prime * result + ((maxDate == null) ? 0 : maxDate.hashCode());
      result = prime * result + page;
      result = prime * result + size;
      result = prime * result + timeMS;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Result other = (Result) obj;
      if (articlesPerPage != other.articlesPerPage)
        return false;
      if (documents == null) {
        if (other.documents != null)
          return false;
      } else if (!documents.equals(other.documents))
        return false;
      if (fullPubmedQuery == null) {
        if (other.fullPubmedQuery != null)
          return false;
      } else if (!fullPubmedQuery.equals(other.fullPubmedQuery))
        return false;
      if (keywords == null) {
        if (other.keywords != null)
          return false;
      } else if (!keywords.equals(other.keywords))
        return false;
      if (maxDate == null) {
        if (other.maxDate != null)
          return false;
      } else if (!maxDate.equals(other.maxDate))
        return false;
      if (page != other.page)
        return false;
      if (size != other.size)
        return false;
      if (timeMS != other.timeMS)
        return false;
      return true;
    }

    public int getArticlesPerPage() {
      return articlesPerPage;
    }

    public List<Document> getDocuments() {
      return documents;
    }

    public String getFullPubmedQuery() {
      return fullPubmedQuery;
    }

    public String getKeywords() {
      return keywords;
    }

    public String getMaxDate() {
      return maxDate;
    }

    public int getPage() {
      return page;
    }

    public int getSize() {
      return size;
    }

    public int getTimeMS() {
      return timeMS;
    }

  }

  private Result result;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    PubMedSearchServiceResponse other = (PubMedSearchServiceResponse) obj;
    if (result == null) {
      if (other.result != null)
        return false;
    } else if (!result.equals(other.result))
      return false;
    return true;
  }

  public Result getResult() {
    return result;
  }

}
