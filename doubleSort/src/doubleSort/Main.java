package doubleSort;

public class Main {

	public static void main(String[] args) {
			System.out.println("Doubly Linked List");
			Node<Integer> a = new Node();
			a.Payload = 5;
			Node<Integer> b  = new Node();
			b.Payload = 23;
			Node<Integer> c  = new Node();
			b.Payload = 9;
			Node<Integer> d  = new Node();
			b.Payload = 7;
			DoublyLinkedList<Integer> list =new DoublyLinkedList();
			list.pend(a);
			list.Append(b);
			list.Append(c);
			list.Append(d);
			System.out.println(list);
			list.Sort(true);
			System.out.println(list);
	}

}
