package driver;
import java.util.Random;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int[] testArray = new int[10];
		for(int i = 0; i<testArray.length; i++) {
			testArray[i]=r.nextInt(100);
			System.out.print(testArray[i]+", ");
		}
		mergeSort(testArray, 0, testArray.length-1);
		System.out.println();
		for(int i = 0; i<testArray.length; i++) {
			System.out.print(testArray[i]+", ");
		}
	}
	public static void mergeSort(int[] arr, int start, int end) {
		if(start != end) {
		int mid = (start + end)/2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1,end);
		
		merge(arr, start, mid+1, mid, end);
		}
	}
	public static void merge(int[] arr, int lCursor, int rCursor, int seperator, int end) {
		while(lCursor< end && seperator<end) {
			if(arr[lCursor]>arr[rCursor]) {
				int temp = arr[rCursor];
				for(int i = seperator;i>=lCursor; i--) {
					arr[i+1] = arr[i];
				}
				arr[lCursor] = temp;
				lCursor++;
				rCursor++;
				if(rCursor>end) {
					rCursor = end;
				}
				seperator++;
			}
			else {
				lCursor++;
			}
		}
		
	}

}
