package homework14;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTableChaining table = new HashTableChaining(10);
		Random r = new Random();
		for(int i = 0; i<18;i++) {
			int key = r.nextInt(100);
			String value = ""+r.nextInt(1000);
			table.Insert(key, value);
		}
		int keyr1 = r.nextInt(100);
		String value = ""+r.nextInt(1000);
		table.Insert(keyr1, value);
		int keyr2 = r.nextInt(100);
		value = ""+r.nextInt(1000);
		table.Insert(keyr2, value);
		table.Display();
		System.out.println();
		table.Remove(keyr1);
		table.Remove(keyr2);
		table.Display();
	}

}
