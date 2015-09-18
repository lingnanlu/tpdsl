package walking.embedded;

public class PrintNode extends StatNode {
	ExprNode value;
	public PrintNode(Token token, ExprNode value) {
		// TODO 自动生成的构造函数存根
		super(token);
		this.value = value;
	}
	public void print() {
		System.out.print("print ");
		value.print();
		System.out.println();
	}
}
