package walking.visitor;

public class IndependentPrintVisitor {
	
	/*
	 * 这是一个分派函数，必须需要这个函数
	 * 因为Java是动态单分派语言，在运行时，只支持如下这种动态分派
	 * obj.method()
	 * obj在类型在运行时再确定。
	 * 而这里的情况是，print(arg)，根据运行时，参数的实际类型来确定所调用的函数
	 * ，Java不支持这种运行时动态分派，所以得有这个分派函数。
	 */
	public void print(VecMathNode n) {
		switch (n.token.type) {
		case Token.ID:
			print((VarNode) n);
			break;
		case Token.ASSIGN:
			print((AssignNode) n);
			break;
		case Token.PRINT:
			print((PrintNode) n);
			break;
		case Token.PLUS:
			print((AddNode) n);
			break;
		case Token.MULT:
			print((MultNode) n);
			break;
		case Token.DOT:
			print((DotProductNode) n);
			break;
		case Token.INT:
			print((IntNode) n);
			break;
		case Token.VEC:
			print((VectorNode) n);
			break;
		case Token.STAT_LIST:
			print((StatListNode) n);
			break;
		default:
			// catch unhandled node types
			throw new UnsupportedOperationException("Node "
					+ n.getClass().getName() + " not handled");
		}
	}

	public void print(StatListNode n) {
		for (StatNode p : n.elements)
			print(p);
	}

	public void print(AssignNode n) {
		print(n.id); // walk left child
		System.out.print("="); // print operator
		print(n.value); // walk right child
		System.out.println(); // print newline
	}

	public void print(PrintNode n) {
		System.out.print("print ");
		print(n.value);
		System.out.println();
	}

	public void print(AddNode n) {
		print(n.left); // walk left child
		System.out.print("+"); // print operator
		print(n.right); // walk right child
	}

	public void print(DotProductNode n) {
		print(n.left);
		System.out.print(".");
		print(n.right);
	}

	public void print(MultNode n) {
		print(n.left);
		System.out.print("*");
		print(n.right);
	}

	public void print(IntNode n) {
		System.out.print(n.toString());
	}

	public void print(VarNode n) {
		System.out.print(n.toString());
	}

	public void print(VectorNode n) {
		System.out.print("[");
		if (n.elements != null) {
			for (int i = 0; i < n.elements.size(); i++) {
				ExprNode child = n.elements.get(i);
				if (i > 0)
					System.out.print(", ");
				print(child);
			}
		}
		System.out.print("]");
	}
}
