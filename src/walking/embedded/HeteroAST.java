package walking.embedded;

public class HeteroAST {
	Token token;
	public HeteroAST() {;}
	public HeteroAST(Token token) {
		this.token = token;
	}
	
	public String toString() {
		return token.toString();
	}
}
