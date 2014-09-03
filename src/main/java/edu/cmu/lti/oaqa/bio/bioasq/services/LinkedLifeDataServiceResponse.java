package edu.cmu.lti.oaqa.bio.bioasq.services;

import java.util.List;

public class LinkedLifeDataServiceResponse {

  public static final class Relation {

    private List<String> labels;

    private String pred;

    private String subj;

    private String obj;

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((labels == null) ? 0 : labels.hashCode());
      result = prime * result + ((obj == null) ? 0 : obj.hashCode());
      result = prime * result + ((pred == null) ? 0 : pred.hashCode());
      result = prime * result + ((subj == null) ? 0 : subj.hashCode());
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
      Relation other = (Relation) obj;
      if (labels == null) {
        if (other.labels != null)
          return false;
      } else if (!labels.equals(other.labels))
        return false;
      if (this.obj == null) {
        if (other.obj != null)
          return false;
      } else if (!this.obj.equals(other.obj))
        return false;
      if (pred == null) {
        if (other.pred != null)
          return false;
      } else if (!pred.equals(other.pred))
        return false;
      if (subj == null) {
        if (other.subj != null)
          return false;
      } else if (!subj.equals(other.subj))
        return false;
      return true;
    }

    public List<String> getLabels() {
      return labels;
    }

    public String getPred() {
      return pred;
    }

    public String getSubj() {
      return subj;
    }

    public String getObj() {
      return obj;
    }

  }

  public static final class Entity {

    private String entity;

    private List<Relation> relations;

    private double score;

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((entity == null) ? 0 : entity.hashCode());
      result = prime * result + ((relations == null) ? 0 : relations.hashCode());
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
      Entity other = (Entity) obj;
      if (entity == null) {
        if (other.entity != null)
          return false;
      } else if (!entity.equals(other.entity))
        return false;
      if (relations == null) {
        if (other.relations != null)
          return false;
      } else if (!relations.equals(other.relations))
        return false;
      if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
        return false;
      return true;
    }

    public String getEntity() {
      return entity;
    }

    public List<Relation> getRelations() {
      return relations;
    }

    public double getScore() {
      return score;
    }

  }

  public static final class Result {

    private List<Entity> entities;

    private String query;

    private int timeMS;

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((entities == null) ? 0 : entities.hashCode());
      result = prime * result + ((query == null) ? 0 : query.hashCode());
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
      if (entities == null) {
        if (other.entities != null)
          return false;
      } else if (!entities.equals(other.entities))
        return false;
      if (query == null) {
        if (other.query != null)
          return false;
      } else if (!query.equals(other.query))
        return false;
      if (timeMS != other.timeMS)
        return false;
      return true;
    }

    public List<Entity> getEntities() {
      return entities;
    }

    public String getQuery() {
      return query;
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
    LinkedLifeDataServiceResponse other = (LinkedLifeDataServiceResponse) obj;
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
