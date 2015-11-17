
public class Weather {
	public static void main(String[] args) {
		
		float fah = 86;
		System.out.println(fah + " degrees Fahrenheit is...");
		
		// To convert fahrenheit into celsius
		// begin by subractin 32
		fah -= 32;
		// Divide the answer by 9
		fah /= 9;
		// Multiply that answer by 5
		fah *= 5;
		System.out.println(fah + " degrees Celsius\n");
		
		float cel = 33;
		System.out.println(cel + " degrees Celsius is...");
		
		// To convert celsius int fahrenheit
		// Begin by multiplying by 9
		cel *= 9;
		// Divide the answer by 5
		cel /= 5;
		// Add 32 to the answer
		cel += 32;
		System.out.println(cel + " degrees in Fahrenheit\n");
		
		// ints are declared
		int x = 0;
		int y = 0;
		int z = 0;
		System.out.println("X equals " + x + ", Y equals " + y + ", and Z equals " + z + ".");		
		
		// X is given the value of 42.
		x = 42;
		System.out.println("X is given the value of 42.");
		System.out.println("Now X equals " + x + ", Y equals " + y + ", and Z equals " + z + ".");
		
		// Y is given X's value (42) before it is incremented; 
		// X is then incremented and is now 43.
		y = x++;
		System.out.println("Y is given the value of X++.");
		System.out.println("Now X equals " + x + ", Y equals " + y + ", and Z equals " + z + ".");
		
		// X is incremented to 44, and then Z is given X's value,
		// so Z is 44.  
		z = ++x;		
		System.out.println("Z is given the value of ++X.");
		System.out.println("Now X equals " + x + ", Y equals " + y + ", and Z equals " + z + ".");
	}
}
