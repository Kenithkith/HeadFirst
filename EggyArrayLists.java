import java.util.ArrayList;


public class EggyArrayLists {
	public static void main(String[] args) {
		
		Egg s = new Egg("Yolkie");
		Egg b = new Egg("Sunnyside Up");
		Egg d = new Egg("Denver Omelette");
		
		System.out.println("Hi, my name is " + s.name + "!");
		s.cluck();
		System.out.println("Hi, my name is " + b.name + "!");
		s.cluck();
		System.out.println("Hi, my name is " + d.name + "!");
		s.cluck();
		System.out.println();
		
		
		ArrayList<Egg> myList = new ArrayList<Egg>();
		
		myList.add(s);
		myList.add(b);
		myList.add(d);
		
		int theSize = myList.size();
		System.out.println("The number of eggs currently in myList array are:  " + theSize);
		
		boolean isIn = myList.contains(s);
		System.out.println("Is Yolkie in myList?  My sources say " + isIn + ".");
		
		int idx = myList.indexOf(b);
		System.out.println("Where is Sunnyside Up?  You can find her in myList in slot number " + idx + ".");
		
		boolean empty = myList.isEmpty();
		System.out.println("Is the myList chicken coop empty?  My sources say " + empty + ".");
		
		myList.remove(s);
		int newSize = myList.size();
		System.out.println("Sunny is away on vacation.  The number of eggs currently in myList array are:  " + newSize);
		
		
		
	}

}
