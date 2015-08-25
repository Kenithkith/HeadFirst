
public class Shuffle1 {
	public static void main(String[] args) {
		
		int x = 3;
		
		while (x > 0) {
			
			if (x > 2) {
				System.out.print("a"); 
			}
			
			x = x - 1;				
			System.out.print("-");  
			
			if (x == 2) {
				System.out.print("b c");
			}
			
			if ( x == 1) {
				System.out.print("d");
			
				x = x - 1;
			}
		}
	}
}

//First pass: x = 3 so print A.
//First pass: changes 3 to 2.
//First pass:  adds the - after A.
//First pass: x is now equal to 2, so print B C. 
//First pass: nothing else applies so circle for second pass.
//Second pass:  X is 2, so skip first if statement
//Second pass:  2 changes to 1.
//Second pass:  adds the - after C.
//Second pass: second if statement does not apply
//Second pass: 3rd if statement applies, print out D.
//Second pass: 1 changes to 0.
//Second pass: nothing else to compare, so circle for third pass.
//Third pass: x is now equal to 0, so while statement does not apply.
//Third pass: program ends.
//Print out reads:  a-b c-d

