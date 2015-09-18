package parsing.parse_tree;

import parsing.lexer.Lexer;
import parsing.lexer.ListLexer;
import parsing.recursive_descent.ListParser;

public class MyParser extends Parser{

	ParseTree root;
	ParseTree currentNode;
	
	public MyParser(Lexer input) {
		super(input);
	}
	
	
	public void match(int x) {
		currentNode.addChild(lookahead);
		super.match(x);
	}
	
	
	public void list() {
		RuleNode r = new RuleNode("list");
		if (root == null) {
			root = r;
		} else {
			currentNode.addChild(r);
		}
		
		ParseTree _save = currentNode;
		currentNode = r;
		
		match(ListLexer.LBRACK);
		elements();
		match(ListLexer.RBRACK);
		
		currentNode = _save;
		
	}
	
	
	void elements() {
		
		RuleNode r = new RuleNode("elements");
		if (root == null) {
			root = r;
		} else {
			currentNode.addChild(r);
		}
		
		ParseTree _save = currentNode;
		currentNode = r;
		
		
		element();
		while(lookahead.type == ListLexer.COMMA){
			match(ListLexer.COMMA);
			element();
		}
		
		
		currentNode = _save;
	}
	
	void element() {
		
		RuleNode r = new RuleNode("element");
		if (root == null) {
			root = r;
		} else {
			currentNode.addChild(r);
		}
		
		ParseTree _save = currentNode;
		currentNode = r;
		
		
		if (lookahead.type == ListLexer.NAME) {
			match(ListLexer.NAME);
		} else if(lookahead.type == ListLexer.LBRACK){
			list();
		} else {
			throw new Error("expecting name or list; found " + lookahead);
		}
		
		
		currentNode = _save;
	}
	
	public static void main(String[] args) {
		ListLexer lexer = new ListLexer("[a,b]");
		MyParser parser = new MyParser(lexer);
		parser.list();
		parser.travel("-");
	}

	public void travel(String prefix) {
		root.travel(prefix);
	}
}
