package walking.embedded;
import java.util.*;

public class VectorNode extends ExprNode {
	List<ExprNode> elements = new ArrayList<ExprNode>();
	public VectorNode(Token token, List<ExprNode> elements) {
		// TODO 自动生成的构造函数存根
		super(token);
		this.elements = elements;
	}
	
	public void print() {
		System.out.print("[");
		if (elements != null) {
			for(int i = 0; i < elements.size(); i++) {
				ExprNode child = elements.get(i);
				if (i > 0){
					System.out.print(", ");
				}
				child.print();
			}
		}
		System.out.print("]");
	}

}
