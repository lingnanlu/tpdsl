package walking.visitor;

public class IntNode extends ExprNode {
	 public IntNode(Token t) { super(t); }
	    public void visit(VecMathVisitor visitor) { visitor.visit(this); }
}
