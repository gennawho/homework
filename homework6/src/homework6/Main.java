package homework6;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int[] toBeSorted = RandomizedArray(1000, 0, 250000);
		int[] forBubbleSort = CopyArray(toBeSorted);
		int[] forSelectionSort = CopyArray(toBeSorted);
		long start = System.nanoTime();
		BubbleSort(forBubbleSort);
		long finish = System.nanoTime();
		long timeElapsed = finish - start;
		System.out.println("Bubble Sort took " + timeElapsed + " nanoseconds");
		start = System.nanoTime();
		SelectionSort(forBubbleSort);
		finish = System.nanoTime();
		timeElapsed = finish - start;
		System.out.println("Selection Sort took " + timeElapsed + " nanoseconds");
	}


	public static int[] RandomizedArray(int size, int start, int end) {
		Random r = new Random();
		int increment = (end-start)/size;
		int min = start;
		int max = increment + (end-start)%size;
		int[] array = new int[size];
		for(int i=0; i<size ; i++) {
			array[i] = r.nextInt(max-min) + min;
			min =array[i];
			max = max + increment;	
			}
		for(int i = 0; i<3; i++) {
			shuffleArray(array);
		}
		return array;
	}
	public static void shuffleArray(int[] arr) {
		int temp;
		int rand1;
		int rand2;
		Random r = new Random();
		for(int i = 0; i<arr.length/2; i++) {
			rand1 = r.nextInt(arr.length-1);
			rand2 = r.nextInt(arr.length-1);
			temp = arr[rand1];
			arr[rand1] = arr[rand2];
			arr[rand2]= temp;
		}
	}
	public static void BubbleSort(int[] arr) {
		int temp;
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr.length - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					temp =arr[j];
					arr[j]= arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	public static void SelectionSort(int[] arr) {
		int smallestIndex = 0;
		int temp;
		for(int i = 0; i<arr.length; i++) {
			smallestIndex =i;
			for(int j = i; j<arr.length; j++) {
				if(arr[j] < arr[smallestIndex]) {
					smallestIndex = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[smallestIndex];
			arr[smallestIndex]=temp;
		}
	}
	public static int[] CopyArray(int[] arr) {
		int[] copy = new int[arr.length];
		for(int i = 0; i<arr.length; i++) {
			copy[i] = arr[i];
		}
		return copy;
	}


}
