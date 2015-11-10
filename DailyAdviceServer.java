import java.io.*;
import java.net.*;

public class DailyAdviceServer {

	// Daily advice comes from this array.
	String[] adviceList = { "Take larger bites.  No one's watching.",
			"Go for the tight jeans. No, they do not make you look fat.",
			"One word: inappropriate.",
			"Just for today, be honest. Tell your boss how you really feel.",
			"You might want to rethink that haircut." };
	
	public void go() {
		
		try{
			// ServerSocket makes this server application 'listen' for client requests
			// on Port 4242 on the machine the code is running on.
			ServerSocket serverSock = new ServerSocket(4242);
			
			// The server goes into a permanent loop, waiting for 
			// (and servicing) client requests.
			while(true) {
				
				// The accept method blocks (just sits there) until a request comes in, 
				// and then the method returns a socket (on some anonymous port) for 
				// communication with the client.
				Socket sock = serverSock.accept();
				
				// Now we use the Socket connection to the client to make a PrintWriter
				// and send it (println()) a String advice message. Then we close the Socket
				// because we're done with the client.
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);
			}
			
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	} // close go

	private String getAdvice() {
		int random = (int) (Math.random() * adviceList.length);
		return adviceList[random];
	}
	
	public static void main(String[] args) {
		
		DailyAdviceServer server = new DailyAdviceServer();
		
		server.go();
		
	}
}
