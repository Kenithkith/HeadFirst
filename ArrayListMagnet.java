import java.util.*;


public class ArrayListMagnet {
	public static void main (String[] args) {
		
		ArrayList<String> a = new ArrayList<String>();
		
		// add elements to ArrayList a
		a.add(0, "zero");
		a.add(1, "one");
		a.add(2, "two");
		a.add(3, "three");
		
		// call print method from below
		printAL(a);
		// First print pass should be:  zero one two three
		
		// if statement
		if (a.contains("three")) {
			a.add("four");
		}
		
		// remove element in position 2 from ArrayList
		a.remove(2);
		
		printAL(a);
		// Second print pass should be:  zero one three four
	
		// if statement - if object "four" is not in 4th position, add "4.2" to 4th position.
		if (a.indexOf("four") != 4) {
			a.add(4, "4.2");
		}
		
		printAL(a);
		// Third print pass should be:  zero one three four 4.2
		
		// if statement - if ArrayList contains object "two", add object "2.2"
		// without stating what position to put "2.2" in, it will be added to the end.
		if (a.contains("two")) {
			a.add("2.2");
		}
		
		printAL(a);
		// Fourth print pass should be: zero one three four 4.2
	}
		
	public static void printAL (ArrayList<String> al) {
		
		for (String element : al) {
			System.out.print(element + " ");
		}
		
		System.out.println();
			
	}

}
	
