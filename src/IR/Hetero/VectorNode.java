package IR.Hetero;

import java.util.*;

public class VectorNode extends ExprNode {
	List<ExprNode> elements = new ArrayList<ExprNode>();
	public VectorNode(Token t, List<ExprNode> elements){
		super(t);
		this.elements = elements;
	}
}
