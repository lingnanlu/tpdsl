package walking.visitor;

public class AddNode extends ExprNode {
	ExprNode left, right; // named, node-specific, irregular children

	public AddNode(ExprNode left, Token t, ExprNode right) {
		super(t);
		this.left = left;
		this.right = right;
	}

	public void visit(VecMathVisitor visitor) {
		visitor.visit(this);
	}
}
