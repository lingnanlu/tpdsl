package IR.Normalized;

import java.util.List;

import IR.Homo.Token;

public class VectorNode extends ExprNode{

	public VectorNode(Token t, List<ExprNode> elements) {
		super(t);
		// TODO �Զ����ɵĹ��캯�����
		evalType = tVECTOR;
		for(ExprNode e : elements){
			addChild(e);
		}
	}

}
