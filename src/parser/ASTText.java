/* Generated By:JJTree: Do not edit this line. ASTText.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.apache.velocity.runtime.parser;

public
class ASTText extends SimpleNode {
  public ASTText(int id) {
    super(id);
  }

  public ASTText(Parser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=d28e6be96684775e39c7b4b27e10c464 (do not edit this line) */
