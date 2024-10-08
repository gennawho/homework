package driver;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long totalHumans = 77;//this makes 7.7 billion
		totalHumans = totalHumans * 100000000;
		int i =2;
		int years = HowLongToSpread(totalHumans,i);
		System.out.println("it would take " + years + " years to convert every person into a Christian.");
		while(years>50) {
			i++;
			years = HowLongToSpread(totalHumans,i);
		}
		System.out.println("to convert all humans in 50 years or less you would have to train "+i+" at a time");
		
		
		
	}
	public static int HowLongToSpread(long total, int trainedAtATime) {
		long startDisciples = 13;
		int totalLength = 0;
		long totalDisciples = startDisciples;
		int lenghtOfTraining = 3;
		while(totalDisciples < total) {
			totalDisciples = totalDisciples * (trainedAtATime + 1);
			totalLength += lenghtOfTraining;
		}
		return totalLength;
	}
}
