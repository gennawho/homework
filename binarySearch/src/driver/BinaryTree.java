package driver;
import java.util.ArrayList;

public class BinaryTree {
	Node Root;
	
	public Boolean isEmpty() {
		return Root == null;
	}
	
	public void insert(Node node) {
		if(isEmpty()) {
			Root = node;
		}
		else {
			Node curr = Root;
			while(true) {
				if(node.Payload < curr.Payload) {
					if(curr.lChild != null) {
						curr =curr.lChild;
					}
					else {
						curr.lChild = node;
						break;
					}
				}
				else {
					if(curr.rChild != null) {
						curr =curr.rChild;
					}
					else {
						curr.rChild = node;
						break;
					}
				}
			}
		}	
	}
	public Node search(int p) {
		Node node = Root;
		while(node !=null) {
			if(p == node.Payload) {
				return node;
			}
			else if(p < node.Payload) {
				node = node.lChild;
			}
			else {
				node = node.rChild;
			}
		}
		return null;
	}
	public void remove(int p) {
		Node node = Root;
		if(node.Payload == p) {
			if(node.lChild!= null) {
				insert(node.lChild);
			}
			if(node.rChild!= null) {
				insert(node.rChild);
			}
			node.lChild = null;
			node.rChild = null;
			return;
		}
		while(node !=null) {
			if(p < node.Payload) {
				if(node.lChild == null) {
					return;
				}
				else if (p == node.lChild.Payload) {
					remove(node.lChild, node);
					return;
				}
				else {
					node = node.lChild;
				}
			}
			else {
				if(node.rChild == null) {
					return;
				}
				else if (p == node.rChild.Payload) {
					remove(node.rChild, node);
					return;
				}
				else {
					node = node.rChild;
				}
			}
		}
	}
	public void remove(Node n, Node p) {
		Node left = n.lChild;
		Node right = n.rChild;
		if(p.lChild == n) {
			p.lChild = null;
		}
		else {
			p.rChild = null;
		}
		if(left!= null) {
			insert(left);
		}
		if(right!= null) {
			insert(right);
		}
	}
	public void Display() {
		String output = Root + "\n";
		ArrayList<Node> NodesAtPrev= new ArrayList<Node>();
		NodesAtPrev.add(Root);
		ArrayList<Node> NodesAtCurr= new ArrayList<Node>();
		do {
			NodesAtCurr.clear();
			for (int i = 0; i < NodesAtPrev.size(); i++) {
		      Node nodel =NodesAtPrev.get(i).lChild;
		      output = output + nodel + ", ";
		      if(nodel!= null) {
		    	  NodesAtCurr.add(nodel);
		      }
		      Node noder =NodesAtPrev.get(i).rChild;
		      output = output + noder + ", ";
		      if(noder!= null) {
		    	  NodesAtCurr.add(noder);
		      }
		    }
			output = output + "\n";
			NodesAtPrev = (ArrayList<Node>) NodesAtCurr.clone();
		}while(!NodesAtCurr.isEmpty());
		System.out.print(output);
	}
}
