package walking.embedded;

public class MultNode extends ExprNode{
	ExprNode left, right;
	public MultNode(ExprNode left, Token t, ExprNode right) {
		// TODO 自动生成的构造函数存根
		super(t);
		this.left = left;
		this.right = right;
	}
	
	public void print() {
		left.print();
		System.out.print("*");
		right.print();
	}
}
