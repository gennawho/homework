package homework4;
import java.util.Random;

public class MAin {

	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		Random r = new Random();
		int searched = r.nextInt(12);
		int[] location = MatrixSearch(matrix,searched);
		
		if (location[0] == -1 || location[1] == -1) {
			System.out.println("The number " + searched + " is not in the matrix");
		}
		else {
			System.out.println("The number " + searched + " is in row " + location[0] + " and column " + location[1]);
		}
	
		
	}
	public static int[] MatrixSearch(int[][] arr, int target) {
		for(int i=0; i< arr.length;i++) {
			for(int j =  0; j< arr[0].length; j++) {
				if(target == arr[i][j]) {
					return new int[] {i,j};
				}
			}
		}
		return new int[] {-1,-1};
	}

	
	public static int[] BinaryMatrixSearch(int[][] arr, int target){
		int row = -1;
		int column = -1;
		int startr= 0;
		int endr = arr.length-1;
		int midr;
		int numColumns = arr[0].length -1;
		int startc = 0;
		int endc = numColumns;
		int midc;
		while(startr <= endr) {
			midr = (startr+endr)/2;
			int rowMax = arr[midr][numColumns];
			int rowMin = arr[midr][0];
			System.out.println("row " + midr +", "+ rowMax+ ", " + rowMin);
			if(rowMax >= target  && target >=rowMin){//tried to get this to work error seems to be on this line
				row = midr;
				System.out.println("row is "+ row);
				startr = endr + 1;
			}
			else if (rowMax < target) {//second half
				startr= midr+1;
			}
			else {
				endr= midr-1;
			}
		}
		if(row != -1) {
			while(startc < endc) {
				midc = (startc+endc)/2;
				System.out.println("column " + midc);
				if(target == arr[row][midc]) {
					column = midc;
					startc=endc;
				}
				else if(target > arr[row][midc]) {
					startc =midc+1;
				}
				else {
					endc=midc-1;
				}
			}
		}
		return new int[] {row,column};
	}
}
	