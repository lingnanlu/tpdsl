package walking.embedded;

public class DotProductNode extends ExprNode {
	ExprNode left, right;
	public DotProductNode(ExprNode left, Token t, ExprNode right) {
		super(t);
		this.left = left;
		this.right = right;
	}
	
	public void print() {
		left.print();
		System.out.print(".");
		right.print();
	}
}
