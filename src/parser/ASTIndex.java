/* Generated By:JJTree: Do not edit this line. ASTIndex.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.apache.velocity.runtime.parser;

public
class ASTIndex extends SimpleNode {
  public ASTIndex(int id) {
    super(id);
  }

  public ASTIndex(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=1af760ff71cda1f4ecdfb01c0a129ae6 (do not edit this line) */