/* Generated By:JJTree: Do not edit this line. OArraySingleValuesSelector.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OArraySingleValuesSelector extends SimpleNode {

  protected List<OArraySelector> items = new ArrayList<OArraySelector>();

  public OArraySingleValuesSelector(int id) {
    super(id);
  }

  public OArraySingleValuesSelector(OrientSql p, int id) {
    super(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  public void toString(Map<Object, Object> params, StringBuilder builder) {
    boolean first = true;
    for (OArraySelector item : items) {
      if (!first) {
        builder.append(",");
      }
      item.toString(params, builder);
      first = false;
    }
  }


}
/* JavaCC - OriginalChecksum=991998c77a4831184b6dca572513fd8d (do not edit this line) */