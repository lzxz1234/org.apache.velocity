/* Generated By:JJTree: Do not edit this line. ASTTextblock.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.apache.velocity.runtime.parser;

public
class ASTTextblock extends SimpleNode {
  public ASTTextblock(int id) {
    super(id);
  }

  public ASTTextblock(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=ba585a840c422bef86c30e274e10aeb7 (do not edit this line) */