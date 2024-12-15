package driver;

public class Node {
	public int Payload;
	public Node lChild;
	public Node rChild;
	
	public Node(int p) {
		this.Payload =p;
		this.lChild = null;
		this.rChild = null;
	}
	
	@Override
	public String toString() {
		return "" + Payload;
	}
}
