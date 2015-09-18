package walking.visitor;

public class VarNode extends ExprNode {
	  public VarNode(Token t) { super(t); }
	    public void visit(VecMathVisitor visitor) { visitor.visit(this); }    	
}
