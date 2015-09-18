package IR.Normalized;

import IR.Homo.Token;

public class AddNode extends ExprNode{

	public AddNode(ExprNode left, Token addToken, ExprNode right) {
		// TODO 自动生成的构造函数存根
		super(addToken);
		addChild(left);
		addChild(right);
	}
	
	public int getEvalType() {
		ExprNode left = (ExprNode) children.get(0);
		ExprNode right = (ExprNode) children.get(1);
		
		if (left.getEvalType() == tINTEGER && right.getEvalType() == tINTEGER) {
			return tINTEGER;
		}
		
		if (left.getEvalType() == tVECTOR && right.getEvalType() == tVECTOR) {
			return tVECTOR;
		}
		
		return tINVALID;
	}
	
}
