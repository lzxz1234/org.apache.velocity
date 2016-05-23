package org.apache.velocity.runtime.directive;


import java.io.IOException;
import java.io.Writer;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.parser.node.Node;
import org.apache.velocity.runtime.parser.node.SimpleNode;

/**
 * @author lzxz1234
 * @version v1.0
 * @class OverrideDirective
 * @description
 */
public class OverrideDirective extends org.apache.velocity.runtime.directive.Directive{

    @Override
    public String getName() {
        return "override";
    }

    @Override
    public int getType() {
        return BLOCK;
    }

    @Override
    public boolean render(InternalContextAdapter context, Writer writer, Node node)
            throws IOException, ResourceNotFoundException, ParseErrorException,MethodInvocationException {

        String name = Utils.getRequiredArgument(context, node, 0,getName());
        OverrideNodeWrapper override = (OverrideNodeWrapper)context.get(Utils.getOverrideVariableName(name));
        Node topNode = node.jjtGetChild(1);
        if(override == null) {
            context.put(Utils.getOverrideVariableName(name), new OverrideNodeWrapper(topNode));
        }else {
            Utils.setParentForTop(new OverrideNodeWrapper(topNode),override);
        }
        return true;
    }

    static class OverrideNodeWrapper extends SimpleNode {
        Node current;
        OverrideNodeWrapper parentNode;
        public OverrideNodeWrapper(Node node) {
            super(1);
            this.current = node;
        }
        public boolean render(InternalContextAdapter context, Writer writer)
                throws IOException, MethodInvocationException,
                ParseErrorException, ResourceNotFoundException {
            OverrideNodeWrapper preNode = (OverrideNodeWrapper)context.get(Utils.OVERRIDE_CURRENT_NODE);
            try {
                context.put(Utils.OVERRIDE_CURRENT_NODE,this);
                return current.render(context, writer);
            }finally {
                context.put(Utils.OVERRIDE_CURRENT_NODE,preNode);
            }
        }
    }

}
