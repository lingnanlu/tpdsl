package walking.visitor;
import java.util.*;
public class StatListNode extends VecMathNode {
	  List<StatNode> elements = new ArrayList<StatNode>();
	    public StatListNode(List<StatNode> elements) {
	        super(new Token(Token.STAT_LIST)); // create imaginary token
	        this.elements = elements;
	    }
	    public void visit(VecMathVisitor visitor) { visitor.visit(this); }    
}
