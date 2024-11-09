package singleLinkSort;

public class Main {

	public static void main(String[] args) {
		System.out.println("hello, singly linked list");
		SinglyLinkedList list = new SinglyLinkedList();
		list.Append(17);
		list.Prepend(9);
		list.Append(5);
		list.Append(2);
		list.Prepend(8);
		list.Print();
		
		list.Sort(false);
		list.Print();
	}

}
