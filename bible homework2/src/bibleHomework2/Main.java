package bibleHomework2;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random r = new Random();
		long[] totalPopByAge = new long[23];
		//each index holds the number of people of that age. 
		//age can be found by the index times 3
		long[] ChristianPopByAge = new long[23];
		/*for(int i = 0; i < 1100000000; i++) {
			int rand = r.nextInt(22-6)+6;// randomly chooses age 
			totalPopByAge[rand] += 7;
		}*/
		long totalPop=7700000000l;
		
		
		/*for(int i = 0; i < 13; i++) {
			int rand = r.nextInt(23-7)+7;//gives minimum age of 21
			ChristianPopByAge[rand] += 1;
		}*/
		long disciples = 13;
		totalPopByAge[6] = totalPop-disciples;
		totalPopByAge[10] = disciples;
		ChristianPopByAge[10] = disciples;
		int years = SpreadChristianity(totalPopByAge, ChristianPopByAge,totalPop, disciples);
		System.out.println(years);
	}
	public static int SpreadChristianity(long[] Total, long[] Christian, long totalPop, long StartDisciples) {
		int years = 2024;
		while((StartDisciples) < totalPop-StartDisciples) {
			long newDisciples = StartDisciples * 2;
			for(int i = 22; i>6; i--) {
				if(Christian[i]<Total[i]) {
					long diff = Total[i]-Christian[i];
					if(diff> newDisciples) {
						Christian[i] += newDisciples;
						StartDisciples += newDisciples;
						newDisciples = 0;
						break;
					}
					else {
						Christian[i] += diff;
						newDisciples = newDisciples- diff;
						StartDisciples += diff;
					}
				}
			}
			years += 3;
			StartDisciples = AgeUp(Christian,StartDisciples);
			totalPop = AgeUp(Total,totalPop);	
			long born = Total[10];
			Total[0] = born;
			totalPop += Total[6];
			System.out.println("Year is: " + years);
			System.out.println("total disciples: " + StartDisciples);
			System.out.println("total Population: " + totalPop);
			System.out.println();
		}
		return years;
		
	}
	public static long AgeUp(long[] population, long total) {
		total = total - population[population.length -1];
		for(int i = population.length -1; i>0 ; i--) {
			population[i] = population[i-1];
		}
		population[0] = 0;
		return total;
	}

}
