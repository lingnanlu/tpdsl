package walking.visitor;

public class DotProductNode extends ExprNode{
	ExprNode left, right; // named, node-specific, irregular children
    public DotProductNode(ExprNode left, Token t, ExprNode right) {
        super(t);
        this.left = left;
        this.right = right;
    }
	@Override
	public void visit(VecMathVisitor visitor) {
		visitor.visit(this);
	}
}
