/* Generated By:JJTree: Do not edit this line. ASTOrNode.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.apache.velocity.runtime.parser;

public
class ASTOrNode extends SimpleNode {
  public ASTOrNode(int id) {
    super(id);
  }

  public ASTOrNode(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=a0e88c3b36b6e27664eb187a56e7d6fc (do not edit this line) */