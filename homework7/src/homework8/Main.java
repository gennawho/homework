package homework8;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int[] toBeSorted = RandomizedArray(10000000, 0, 10000000);
		//int[] forBubbleSort = CopyArray(toBeSorted);
		//int[] forSelectionSort = CopyArray(toBeSorted);
		//int[] forInsertionSort = CopyArray(toBeSorted);
		int[] forQuickSort = CopyArray(toBeSorted);
		int[] forShellSort = CopyArray(toBeSorted);
		long start = System.nanoTime();
		//BubbleSort(forBubbleSort);
		long finish = System.nanoTime();
		long timeElapsed = finish - start;
		//System.out.println("Bubble Sort took " + timeElapsed + " nanoseconds");
		//start = System.nanoTime();
		//SelectionSort(forSelectionSort);
		//finish = System.nanoTime();
		//timeElapsed = finish - start;
		//System.out.println("Selection Sort took " + timeElapsed + " nanoseconds");
		//start = System.nanoTime();
		//InsertionSort(forInsertionSort);
		//finish = System.nanoTime();
		//timeElapsed = finish - start;
		//System.out.println("Insertion Sort took " + timeElapsed + " nanoseconds");
		start = System.nanoTime();
		quickSort(forQuickSort,0,forQuickSort.length-1);
		finish = System.nanoTime();
		timeElapsed = finish - start;
		System.out.println("Quick Sort took " + timeElapsed + " nanoseconds");
		start = System.nanoTime();
		shellSort(forShellSort);
		finish = System.nanoTime();
		timeElapsed = finish - start;
		System.out.println("Shell Sort took " + timeElapsed + " nanoseconds");
		
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
	public static void InsertionSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int j = i + 1;
			while(j > 0 && arr[j - 1] > arr[j]) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
				j = j - 1;
			}
		}
	}
	public static int[] CopyArray(int[] arr) {
		int[] copy = new int[arr.length];
		for(int i = 0; i<arr.length; i++) {
			copy[i] = arr[i];
		}
		return copy;
	}
	public static void quickSort(int[] arr, int start, int end) {
		if(start < end) {
			int pivot = sortAroundPivot(arr, start,end);
			quickSort(arr,start,pivot-1);
			quickSort(arr,pivot+1,end);
		}
		
	}
	public static int sortAroundPivot(int[] arr, int start, int end) {
		int mid =(start + end)/2;
		int pivot = arr[mid];
		while(true) {
			while(arr[start] < pivot) {
				start++;
			}
			while(arr[end] > pivot) {
				end--;
			}
			if (start< end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
			if (start >= end) {
				return start;
			}
		}
	}
	public static void shellSort(int[] arr) {
		int k = 1;
		int gaps = 2;
		while (gaps < arr.length) {
			gaps = gaps * 2;
			k = k + 1;
		}
		gaps = gaps / 2; //1000 2^10=1024 k = 9 gap is 9
		k = k - 1;
		for(int i = k; i >= 0; i--) {
			int gap = pow(2, i) -1;
				for(int j = 0; j < gap; j++ ) {
					sortOnInterval(arr, j, gap);
				}
		}
		
	}
	public static void sortOnInterval(int[] arr, int start, int gap) {
		for(int i = start; i < arr.length - gap; i = i + gap) {
			int j = i + gap;
			while(j > start && arr[j - gap] >= arr[j]) {
				int temp = arr[j];
				arr[j] = arr[j - gap];
				arr[j - gap] = temp;
				j = j - gap;
			}
		}
		
	}
	public static int pow(int base, int power) {
		int result = 1;
		for(int i = 0; i < power; i++) {
			result = result * base;
		}
		return result;
	}

}
