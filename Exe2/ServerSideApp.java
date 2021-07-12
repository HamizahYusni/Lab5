import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSideApp {
	public static void main(String[] args) {
		
		try {
			
			// Port to receive and respond to request
			int portNo = 4201;
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			System.out.println("Ready for request");
			
			// Server need to be alive forever thus the while(true)
			while (true) {
				
				// Accept client request for connection
				Socket socket = serverSocket.accept();
				
				// Create input stream to read object
				ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
				
				// Read object from stream and cast to Location
				ItemProduct item = (ItemProduct) inputStream.readObject();
				
				// Process object
				item.setItemProductId(1);
				
				// Create output stream to send object
				ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
				outputStream.writeObject(item);
				
				
				System.out.println("Ready for next request");
				
				// Close all streams
				inputStream.close();
				outputStream.close();
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}