/* Generated By:JJTree: Do not edit this line. OSelectStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import com.orientechnologies.orient.core.exception.OQueryParsingException;
import com.orientechnologies.orient.core.sql.OCommandSQLParsingException;

import java.util.List;
import java.util.Map;

public class OSelectStatement extends OStatement {

  protected OFromClause  target;

  protected OProjection  projection;

  protected OWhereClause whereClause;

  protected OGroupBy     groupBy;

  protected OOrderBy     orderBy;

  protected OUnwind      unwind;

  protected OSkip        skip;

  protected OLimit       limit;

  protected Boolean      lockRecord;

  protected OFetchPlan   fetchPlan;

  protected OLetClause   letClause;

  protected OTimeout       timeout;

  protected Boolean      parallel;

  protected Boolean      noCache;

  public OSelectStatement(int id) {
    super(id);
  }

  public OSelectStatement(OrientSql p, int id) {
    super(p, id);
  }

  private String getAlias(OProjectionItem item) {
    if (item.getAlias() != null) {
      return item.getAlias();
    } else {
      return item.getDefaultAlias();
    }

  }

  public OProjection getProjection() {
    return projection;
  }

  public void setProjection(OProjection projection) {
    this.projection = projection;
  }

  public OFromClause getTarget() {
    return target;
  }

  public void setTarget(OFromClause target) {
    this.target = target;
  }

  public OWhereClause getWhereClause() {
    return whereClause;
  }

  public void setWhereClause(OWhereClause whereClause) {
    this.whereClause = whereClause;
  }

  public OGroupBy getGroupBy() {
    return groupBy;
  }

  public void setGroupBy(OGroupBy groupBy) {
    this.groupBy = groupBy;
  }

  public OOrderBy getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(OOrderBy orderBy) {
    this.orderBy = orderBy;
  }

  public OSkip getSkip() {
    return skip;
  }

  public void setSkip(OSkip skip) {
    this.skip = skip;
  }

  public OLimit getLimit() {
    return limit;
  }

  public void setLimit(OLimit limit) {
    this.limit = limit;
  }

  public Boolean getLockRecord() {
    return lockRecord;
  }

  public void setLockRecord(Boolean lockRecord) {
    this.lockRecord = lockRecord;
  }

  public OFetchPlan getFetchPlan() {
    return fetchPlan;
  }

  public void setFetchPlan(OFetchPlan fetchPlan) {
    this.fetchPlan = fetchPlan;
  }

  public OLetClause getLetClause() {
    return letClause;
  }

  public void setLetClause(OLetClause letClause) {
    this.letClause = letClause;
  }

  public void toString(Map<Object, Object> params, StringBuilder builder){

    builder.append("SELECT");
    if (projection != null) {
      builder.append(" ");
      projection.toString(params, builder);
    }
    if (target != null) {
      builder.append(" FROM ");
      target.toString(params, builder);
    }

    if (letClause != null) {
      builder.append(" ");
      letClause.toString(params, builder);
    }

    if (whereClause != null) {
      builder.append(" WHERE ");
      whereClause.toString(params, builder);
    }

    if (groupBy != null) {
      builder.append(" ");
      groupBy.toString(params, builder);
    }

    if (orderBy != null) {
      builder.append(" ");
      orderBy.toString(params, builder);
    }

    if (unwind != null) {
      builder.append(" ");
      unwind.toString(params, builder);
    }

    if (skip != null) {
      skip.toString(params, builder);
    }

    if (limit != null) {
      limit.toString(params, builder);
    }

    if (Boolean.TRUE.equals(lockRecord)) {
      builder.append(" LOCK RECORD");
    }

    if (fetchPlan != null) {
      builder.append(" ");
      fetchPlan.toString(params, builder);
    }

    if (timeout != null) {
      timeout.toString(params, builder);
    }

    if (Boolean.TRUE.equals(parallel)) {
      builder.append(" PARALLEL");
    }

    if (Boolean.TRUE.equals(noCache)) {
      builder.append(" NOCACHE");
    }
  }


  public void validate(OrientSql.ValidationStats stats) throws OCommandSQLParsingException {
    if (this.target == null || this.target.item == null || this.target.item.cluster != null || this.target.item.clusterList != null
        || this.target.item.metadata != null || this.target.item.modifier != null || this.target.item.rids.size() > 0
        || this.target.item.statement != null || !(isClassTarget(this.target) || isIndexTarget(this.target))) {
      if (stats.luceneCount > 0) {
        throw new OQueryParsingException("LUCENE condition is allowed only when query target is a Class or an Index");
      }
    }

    if (whereClause != null && whereClause.baseExpression.getNumberOfExternalCalculations() > 1) {
      StringBuilder exceptionText = new StringBuilder();
      exceptionText.append("Incompatible conditions found: \n");
      List<Object> conditions = whereClause.baseExpression.getExternalCalculationConditions();
      for (Object condition : conditions) {
        exceptionText.append(condition.toString() + "\n");
      }
      throw new OQueryParsingException(exceptionText.toString());
    }
  }

  private boolean isClassTarget(OFromClause target) {

    return target != null && target.item != null && target.item.identifier != null && target.item.identifier.suffix != null
        && target.item.identifier.suffix.identifier != null;
  }

  private boolean isIndexTarget(OFromClause target) {
    return target != null && target.item != null && target.item.index != null;
  }

}
/* JavaCC - OriginalChecksum=b26959b9726a8cf35d6283eca931da6b (do not edit this line) */