package walking.embedded;

public class Token {
	public static final int INVALID_TOKEN_TYPE = 0;
	public static final int PLUS = 1;
	public static final int MULT = 2;
	public static final int DOT = 3;
	public static final int INT = 4;
	public static final int VEC = 5;
	public static final int ID = 6;
	public static final int ASSIGN = 7;
	public static final int PRINT = 8;
	public static final int STAT_LIST = 9;
	
	public int type;
	public String text;
	
	public Token(int type, String text) {
		// TODO 自动生成的构造函数存根
		this.type = type;
		this.text = text;
	}
	
	public Token(int type) {
		// TODO 自动生成的构造函数存根
		this.type = type;
	}
	
	
	public String toString() {
		return text;
	}
}
