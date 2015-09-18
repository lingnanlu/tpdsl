package parsing.parse_tree;
import parsing.lexer.Token;
import java.util.*;

public abstract class ParseTree {
	public List<ParseTree> children;
	
	public void addChild(ParseTree t)  {
		if (children == null){
			children = new ArrayList<ParseTree>();
		}
		
		children.add(t);
	}
	
	public RuleNode addChild(String value) {
		RuleNode r = new RuleNode(value);
		addChild(r);
		return r;
	}
	
	public TokenNode addChild(Token value) {
		TokenNode t = new TokenNode(value) ;
		addChild(t);
		return t;
	}
	
	public void travel(String prefix){
		
		System.out.println(prefix + this);
		prefix = prefix + prefix;
		
		if (children != null) {
			for(ParseTree child : children){
				child.travel(prefix);
			}
		}

	}
}
