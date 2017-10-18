/*
 *  Given a list of people with their birth and end years (all between 1900 and 2000),
 *  find the year with the most number of people alive.
 */
public class AlivePeople {
	public static class People{
		String name;
		int born;
		int died;
		People(String n, int b, int d){
			this.name = n;
			this.born = b;
			this.died = d;
		}
	}
	
	public static void getAlivePeopleArray(People[] people){
		int[] years = new int[101];
		
		// Sum one for every year alive
		for(int i=0; i<people.length; i++){
			for(int j=people[i].born; j<=people[i].died; j++){
				years[j-1900]++;
			}
		}
		
		// found max value
		//	Years  = [1,2,3,4,5,6,7,8,9,10]		--> from 1901 to 1910
		//  Amount = [1,3,2,2,2,4,5,2,1,2]		--> amount of people living in that year
		// Result --> year = 7 + 1900 = 1907 is the year with most people alive
		int maxValue = 0;
		int year = 0;
		for(int k=0; k<years.length; k++){
			if(years[k] > maxValue){
				maxValue = years[k];
				year = k;
			}
		}
		
		year += 1900;
		
		System.out.println("the year with the most number of people alive was " + year);
	}
	
	public static void main(String[] args) {
		People[] people = {
			new People("Joe", 1935, 1988),
			new People("Bob", 1955, 1978),
			new People("Dylan", 1900, 1999),
			new People("Chelsey", 1905, 1944),
			new People("Greg", 1935, 1950),
			new People("Joe", 1970, 1998),
			new People("Bob", 1995, 1998),
			new People("Dylan", 1950, 1979),
			new People("Chelsey", 1985, 1954),
			new People("Greg", 1980, 1930)
			
		};
		
		getAlivePeopleArray(people);
	}
}
