/* Generated By:JJTree: Do not edit this line. ASTEscape.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.apache.velocity.runtime.parser;

public
class ASTEscape extends SimpleNode {
  public ASTEscape(int id) {
    super(id);
  }

  public ASTEscape(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=19455ff28bd0f12c9ad971cd1eae2c9f (do not edit this line) */
