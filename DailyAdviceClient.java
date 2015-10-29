import java.io.*;
import java.net.*;

public class DailyAdviceClient {

	public void go() {
		
		// A lot can go wrong here.  ;-)
		try {
			
			// Make a Socket connection to whatever is running on port 4242,
			// on the same host this code is running on (the 'localhost').
			Socket s = new Socket("127.0.0.1", 4242);
			
			InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
			
			// Chain a BufferedReader to the InputStreamReader to in the input stream
			// from the socket
			BufferedReader reader = new BufferedReader(streamReader);
			
			// This reader.readLine() is EXACTLY the same as if you were using a
			// BufferedReader chained to a FILE.  In other words, by the time you call
			// a BufferedReader method, the reader doesn't care where the characters came from.
			String advice = reader.readLine();
			System.out.println("Today you should: " + advice);
			
			// This closes ALL the streams.
			reader.close();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public static void main (String[] args) {
		
		DailyAdviceClient client = new DailyAdviceClient();
		client.go();
	
	}
}
