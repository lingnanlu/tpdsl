package parsing.parse_tree;

public class RuleNode extends ParseTree{

	public String name;
	RuleNode(String value) {
		// TODO �Զ����ɵĹ��캯�����
		 name = value;
	}
	
	public String toString() {
		return name;
	}

}
