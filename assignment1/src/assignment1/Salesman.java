package assignment1;


public class Salesman {
	public String Name;
	public int Revenue;

	//constructor
	public Salesman(String n, int Revenue) {
		this.Name = n;
		this.Revenue = Revenue;
	}

	//methods
	//getter
	public String getName() {
		return this.Name;
	}

	//setter
	public void setName(String Name) {
		this.Name = Name;
	}

	public String display() {
		return this.Name + ": " + this.Revenue;
	}

	public static Salesman[] topFive(Salesman[] sales) {
		Salesman[] TopFive = new Salesman[5];
		Salesman temp = sales[0];
		Salesman temp2 = sales[0];
		int cursor=0;
		for(int i = 0; i<5; i++) {
			for(int j = 0; j<sales.length-i; j++) {
				if(temp.Revenue<sales[j].Revenue) {
					temp = sales[j];
					cursor = j;
				}
			}
			TopFive[i] = temp;
			temp2 = sales[sales.length-i-1];
			sales[sales.length-i-1] = temp;
			sales[cursor] = temp2;
			temp = sales[0];
		}
		return TopFive;
	}
}
