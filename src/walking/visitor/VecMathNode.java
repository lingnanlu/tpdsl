package walking.visitor;

public abstract class VecMathNode extends HeteroAST{
	 public VecMathNode() {;}
	 public VecMathNode(Token t) { this.token = t; }
	 public abstract void visit(VecMathVisitor visitor);
}
