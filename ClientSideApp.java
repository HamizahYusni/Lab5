import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSideApp {
	
public static void main(String[] args) {
		
		System.out.println("ClientSideApp: Demo of Object Stream\n");

		// Request data
		ItemProduct item = new ItemProduct();
		item.setName("Asus Vivobook A407U-FBV046T");
		

		try {

			// Data to establish connection to server
			int portNo = 4201;
			InetAddress serverAddress = InetAddress.getLocalHost();

			// Connect to the server at localhost, port 4200
			Socket socket = new Socket(serverAddress, portNo);

			// Open stream to send object
			ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

			// Send request to server
			System.out.println("Send object to server: " + item);
			outputStream.writeObject(item);
			outputStream.flush();
			
			// Open stream to receive object
			ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
			
			// Get object from stream and display details
			item = (ItemProduct) inputStream.readObject();
			item.setItemProductId(0);
			System.out.println ("Id for " + item.getName() + " is " + item.getItemProductId());
			
			// Close all closeable objects
			outputStream.close();
			inputStream.close();
			socket.close();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\nClientSideApp: End of application.\n");

	}

}