package walking.embedded;
import java.util.*;

public class StatListNode extends VecMathNode {
	List<StatNode> elements = new ArrayList<StatNode>();
	public StatListNode(List<StatNode> elements) {
		super(new Token(Token.STAT_LIST));
		this.elements = elements;
	}
	
	public void print() {
		for(VecMathNode n : elements)
			n.print();
	}
}
