package parsing.parse_tree;

import parsing.lexer.Token;

public class TokenNode extends ParseTree{

	public Token token;
	public TokenNode(Token value) {
		// TODO �Զ����ɵĹ��캯�����
		token = value;
	}

	public String toString() {
		return token.toString();
	}
}
