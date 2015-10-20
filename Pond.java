import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Pond  implements Serializable {

	private Duck duck = new Duck();
	
	// Because the class Duck has not implemented Serializable, Pond's
	// duck instance variable cannot be saved, and thus fails the attempt
	// to save myPond.
	
	// To make myPond saveable in this case, mark the Duck instance variable 
	// as "transient" as in:
	// transient Duck duck = new Duck();
	
	public static void main(String[] args) {
		Pond myPond = new Pond();
		
		try {
			FileOutputStream fs = new FileOutputStream("Pond.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			
			os.writeObject(myPond);
			os.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}


class Duck {
	
	// Various Duck Code here.
}
