package walking.visitor;

public class PrintNode extends StatNode {
	ExprNode value;

	public PrintNode(Token t, ExprNode value) {
		super(t);
		this.value = value;
	}

	public void visit(VecMathVisitor visitor) {
		visitor.visit(this);
	}
}
