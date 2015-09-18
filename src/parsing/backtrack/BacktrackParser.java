package parsing.backtrack;

import parsing.lexer.Lexer;
import parsing.lexer.ListLexer;



public class BacktrackParser extends Parser{

	public BacktrackParser(Lexer input) {
		super(input);
	}
	
	public static void main(String[] args) throws RecognitionException{
		ListLexer lexer = new ListLexer(args[0]);
		BacktrackParser parser = new BacktrackParser(lexer);
		parser.stat();
	}
	
	/*
	 * stat : list EOF | assign EOF
	 */
	public void stat() throws RecognitionException {
		if (speculate_stat_alt1()) {
			list(); match(Lexer.EOF_TYPE);
		} 
		
		else if (speculate_stat_alt2()){
			assign(); match(Lexer.EOF_TYPE);
		}
		
		else throw new NoViableAltException("expecting stat found " + LT(1));
	}
	

	public boolean speculate_stat_alt1() {
		
		boolean success = true;
		mark();
		try {
			list(); match(Lexer.EOF_TYPE);
		} catch (MismatchedTokenException e) {
			success = false;
		}
		release();
		return success;

	}
	
	public boolean speculate_stat_alt2(){
		
		boolean success = true;
		mark();
		try {
			assign(); match(Lexer.EOF_TYPE);
		} catch (MismatchedTokenException e) {

			success = false;
		}
		release();
		return success;
		
	}
	
	/*
	 * assign : list '=' list
	 */
	public void assign() throws MismatchedTokenException {
		list();
		match(ListLexer.EQUAL);
		list();
	}
	
	
	public void list() throws MismatchedTokenException {
		match(ListLexer.LBRACK);
		elements();
		match(ListLexer.RBRACK);
	}
	
	
	void elements() throws MismatchedTokenException {
		element();
		while(LA(1) == ListLexer.COMMA){
			match(ListLexer.COMMA);
			element();
		}
	}
	
	void element() throws MismatchedTokenException {
		if(LA(1) == ListLexer.NAME && LA(2) == ListLexer.EQUAL){
			match(ListLexer.NAME);
			match(ListLexer.EQUAL);
			match(ListLexer.NAME);
		}
		else if (LA(1) == ListLexer.NAME) match(ListLexer.NAME);
		else if (LA(1) == ListLexer.LBRACK) list();
		else throw new Error("expecting name or list; found " + LT(1));
	}
	
	
}
