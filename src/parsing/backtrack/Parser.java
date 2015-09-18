package parsing.backtrack;
import java.util.ArrayList;
import java.util.List;

import parsing.lexer.*;


public abstract class Parser {
	Lexer input;
	List<Integer> markers = new ArrayList<Integer>();
	List<Token> lookahead = new ArrayList<Token>();
	int p = 0;
	
	public Parser(Lexer input) {
		this.input = input;
		//sync(1);
	}
	public Token LT(int i) {
		sync(i);
		return lookahead.get(p + i - 1);
	}
	
	public int LA(int i) {
		return LT(i).type;
	}
	
	public void match(int x) throws MismatchedTokenException {
		if (LA(1) == x) consume();
		else throw new MismatchedTokenException("expecting " + input.getTokenName(x) + " found " + LT(1));
	}
	public void sync(int i) {
		if ((p + i - 1) > (lookahead.size() - 1)) {
			int n = (p + i - 1) - (lookahead.size() - 1);
			fill(n);
		}
	}
	
	public void fill(int n) {
		for(int i = 0; i < n; i++){
			lookahead.add(input.nextToken());
		}
	}
	
	public int mark() {
		markers.add(p);
		return p;
	}
	
	public void release() {
		int marker = markers.get(markers.size() - 1);
		markers.remove(markers.size() - 1);
		p = marker;
	}
	public void consume(){
		
		p++;
		if ( p == lookahead.size() && !isSpeculating()) {
			p = 0; 
			lookahead.clear();
		}
		
		sync(1);
		
	}
	

	
	public boolean isSpeculating() {
		return markers.size() > 0;
	}

}
