// Serializable is in the java package so you need to import.
import java.io.*;

// No methods to implement, but when you say "implements Serializable",
// it says to the JVM that it's okay to serialize objects of this type.
public class Box implements Serializable {

	// These two values will be saved.
	private int width;
	private int height;
	
	public void setWidth(int w) {
		this.width = w;
		
	}
	
	public void setHeight(int h) {
		this.height = h;
		
	}
	
	public static void main(String[] args) {
		Box myBox = new Box();
		myBox.setWidth(50);
		myBox.setHeight(20);
		
		// I/O operations can throw exceptions.
		try {
			
			// Connect to a file named "foo.ser" if it exists.
			// If it doesn't, make a new file named "foo.ser".
			FileOutputStream fs = new FileOutputStream("foo.ser");
			
			// Make an ObjectOutputStream chained to the connection stream.
			ObjectOutputStream os = new ObjectOutputStream(fs);
			
			// Tell it to write the object "myBox".
			os.writeObject(myBox);
			os.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
