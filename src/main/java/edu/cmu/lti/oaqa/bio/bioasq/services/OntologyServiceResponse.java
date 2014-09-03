package edu.cmu.lti.oaqa.bio.bioasq.services;

import java.util.List;

public class OntologyServiceResponse {

  public static final class Range {

    private int begin;
    
    private int end;

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + begin;
      result = prime * result + end;
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
      Range other = (Range) obj;
      if (begin != other.begin)
        return false;
      if (end != other.end)
        return false;
      return true;
    }

    public int getBegin() {
      return begin;
    }

    public int getEnd() {
      return end;
    }

  }

  public static final class Concept {

    private String label;

    private String termId;

    private String uri;

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((label == null) ? 0 : label.hashCode());
      result = prime * result + ((termId == null) ? 0 : termId.hashCode());
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
      Concept other = (Concept) obj;
      if (label == null) {
        if (other.label != null)
          return false;
      } else if (!label.equals(other.label))
        return false;
      if (termId == null) {
        if (other.termId != null)
          return false;
      } else if (!termId.equals(other.termId))
        return false;
      if (uri == null) {
        if (other.uri != null)
          return false;
      } else if (!uri.equals(other.uri))
        return false;
      return true;
    }

    public String getLabel() {
      return label;
    }

    public String getTermId() {
      return termId;
    }

    public String getUri() {
      return uri;
    }

  }

  public static final class Finding {

    private Concept concept;

    private String matchedLabel;

    private List<Range> ranges;
    
    private double score;

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((concept == null) ? 0 : concept.hashCode());
      result = prime * result + ((matchedLabel == null) ? 0 : matchedLabel.hashCode());
      result = prime * result + ((ranges == null) ? 0 : ranges.hashCode());
      long temp;
      temp = Double.doubleToLongBits(score);
      result = prime * result + (int) (temp ^ (temp >>> 32));
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
      Finding other = (Finding) obj;
      if (concept == null) {
        if (other.concept != null)
          return false;
      } else if (!concept.equals(other.concept))
        return false;
      if (matchedLabel == null) {
        if (other.matchedLabel != null)
          return false;
      } else if (!matchedLabel.equals(other.matchedLabel))
        return false;
      if (ranges == null) {
        if (other.ranges != null)
          return false;
      } else if (!ranges.equals(other.ranges))
        return false;
      if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
        return false;
      return true;
    }

    public Concept getConcept() {
      return concept;
    }

    public String getMatchedLabel() {
      return matchedLabel;
    }

    public List<Range> getRanges() {
      return ranges;
    }

    public double getScore() {
      return score;
    }

  }
  
  public static final class Result {
    
    private List<Finding> findings;
    
    private String keywords;
    
    private int page;
    
    private int conceptsPerPage;
    
    private int timeMS;
    
    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + conceptsPerPage;
      result = prime * result + ((findings == null) ? 0 : findings.hashCode());
      result = prime * result + ((keywords == null) ? 0 : keywords.hashCode());
      result = prime * result + page;
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
      if (conceptsPerPage != other.conceptsPerPage)
        return false;
      if (findings == null) {
        if (other.findings != null)
          return false;
      } else if (!findings.equals(other.findings))
        return false;
      if (keywords == null) {
        if (other.keywords != null)
          return false;
      } else if (!keywords.equals(other.keywords))
        return false;
      if (page != other.page)
        return false;
      if (timeMS != other.timeMS)
        return false;
      return true;
    }

    public List<Finding> getFindings() {
      return findings;
    }
    
    public String getKeywords() {
      return keywords;
    }
    
    public int getPage() {
      return page;
    }
    
    public int getConceptsPerPage() {
      return conceptsPerPage;
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
    OntologyServiceResponse other = (OntologyServiceResponse) obj;
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
