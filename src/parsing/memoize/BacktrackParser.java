package parsing.memoize;

import java.util.HashMap;
import java.util.Map;

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
	

	public boolean speculate_stat_alt1() throws RecognitionException {
		
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
	
	public boolean speculate_stat_alt2() throws RecognitionException{
		
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
	public void assign() throws RecognitionException {
		list();
		match(ListLexer.EQUAL);
		list();
	}
	
	
	public void _list() throws RecognitionException {
		System.out.println("parse list rule at token index: " + index());
		match(ListLexer.LBRACK);
		elements();
		match(ListLexer.RBRACK);
	}
	
    Map<Integer, Integer> list_memo = new HashMap<Integer, Integer>();
	public void list() throws RecognitionException {
		boolean failed = false;
		int startTokenIndex = index();
		
		if (isSpeculating() && alreadyParsedRule(list_memo)) return;
		
		try {
			_list();
		} catch (RecognitionException re) {
			failed = true;
			throw re;
		} finally {
			if (isSpeculating())
				memoize(list_memo, startTokenIndex, failed);
		}
		
	}
	
	void elements() throws RecognitionException {
		element();
		while(LA(1) == ListLexer.COMMA){
			match(ListLexer.COMMA);
			element();
		}
	}
	
	void element() throws RecognitionException {
		if(LA(1) == ListLexer.NAME && LA(2) == ListLexer.EQUAL){
			match(ListLexer.NAME);
			match(ListLexer.EQUAL);
			match(ListLexer.NAME);
		}
		else if (LA(1) == ListLexer.NAME) match(ListLexer.NAME);
		else if (LA(1) == ListLexer.LBRACK) list();
		else throw new Error("expecting name or list; found " + LT(1));
	}

	@Override
	public void clearMemo() {
		list_memo.clear();
	}
	
	
}
