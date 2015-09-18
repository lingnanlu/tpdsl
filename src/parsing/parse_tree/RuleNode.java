package parsing.parse_tree;

public class RuleNode extends ParseTree{

	public String name;
	RuleNode(String value) {
		// TODO 自动生成的构造函数存根
		 name = value;
	}
	
	public String toString() {
		return name;
	}

}
