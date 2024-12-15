package driver;
import java.util.Random;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Random r = new Random();
		int[] randArray = new int[10];
		for(int i =0; i<10; i++) {
			randArray[i] = i;
		}
		shuffle(randArray);
		BinaryTree tree = new BinaryTree();
		for(int i =0; i<10; i++) {
			Node node = new Node(randArray[i]);
			tree.insert(node);
		}
		tree.Display();
		System.out.println();
		for(int i = 0; i<3; i++) {
			tree.remove(r.nextInt(10));
		}
		tree.Display();
		System.out.println();
		System.out.println();
		for(int i = 0; i<3; i++) {
			int rand = r.nextInt(10);
			Node searched =tree.search(rand);
			System.out.println(rand +","+searched);
		}
		
	}
	
	public static void shuffle(int[] arr) {
		Random r = new Random();
		for(int i =0; i<arr.length/2; i++) {
			int r1 = r.nextInt(arr.length);
			int r2 = r.nextInt(arr.length);
			int temp = arr[r1];
			arr[r1] = arr[r2];
			arr[r2] = temp;
		}
	}

}
