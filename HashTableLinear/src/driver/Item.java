package driver;

public class Item {
	public Flag flag;
	public int Key;
	public String Value;
	
	public Item(int Key, String Value) {
		this.Key = Key;
		this.Value = Value;
		this.flag = Flag.normal;
	}
	
	public Item() {
		this.Key = 0;
		this.Value = "";
		this.flag = Flag.empty_since_start;
	}
	
	@Override
	public String toString() {
		if(flag == Flag.normal) {
			return "{" +Key + ":" + Value+"}";
		}
		return "{" + flag + "}";
	}

}
