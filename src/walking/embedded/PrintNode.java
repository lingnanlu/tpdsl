package walking.embedded;

public class PrintNode extends StatNode {
	ExprNode value;
	public PrintNode(Token token, ExprNode value) {
		// TODO �Զ����ɵĹ��캯�����
		super(token);
		this.value = value;
	}
	public void print() {
		System.out.print("print ");
		value.print();
		System.out.println();
	}
}
