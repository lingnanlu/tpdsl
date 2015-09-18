package walking.visitor;

public class HeteroAST {
	Token token; // This node created from which token?

	public HeteroAST() {
		;
	}

	public HeteroAST(Token t) {
		this.token = t;
	}

	public String toString() {
		return token.toString();
	}
}
