package driver;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		HashTableLinearProbing table = new HashTableLinearProbing(10);
		Random r = new Random();
		int[] keys = new int[10];
		for(int i = 0; i<10;i++) {
			int key = r.nextInt(100);
			for(int j = 0; j<i-1; j++) {
				if(key == keys[j]) {
					key = r.nextInt(100);
					j=0;
				}
			}
			String value = ""+r.nextInt(1000);
			table.Insert(key, value);
		}
		table.display();
		System.out.println();
		int randStart = r.nextInt(10);
		int keyr = table.Table[randStart].Key;
		table.Remove(keyr);
		randStart = r.nextInt(10);
		keyr = table.Table[randStart].Key;
		table.Remove(keyr);
		table.display();
		System.out.println();
		randStart = r.nextInt(10);
		keyr = table.Table[randStart].Key;
		Item searched = table.Search(keyr);
		System.out.println(searched);
		randStart = r.nextInt(10);
		keyr = table.Table[randStart].Key;
		searched = table.Search(keyr);
		System.out.println(searched);

	}

}
