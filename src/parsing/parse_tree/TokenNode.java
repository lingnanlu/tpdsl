package parsing.parse_tree;

import parsing.lexer.Token;

public class TokenNode extends ParseTree{

	public Token token;
	public TokenNode(Token value) {
		// TODO 自动生成的构造函数存根
		token = value;
	}

	public String toString() {
		return token.toString();
	}
}
