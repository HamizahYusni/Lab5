import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class ClientUDP{

	public static void main(String[] args) {
		
		System.out.println("ClientSideApp: Demo of UDP");
		
		try {

			// Create the socket object to transmit the data.
			DatagramSocket datagramSocket = new DatagramSocket();

			// Get IP address
			InetAddress ipAdd = InetAddress.getLocalHost();
			
			// Declare port no
			int portNo = 1803;

			// Convert the String input into the byte array
			String text = "Hello everyone, I am Hamizah Yusni";
			byte buf[] = text.getBytes();

			// Create datagrampacket to send to the server
			DatagramPacket outPacket = new DatagramPacket(buf, buf.length, ipAdd, portNo);

			// Send datagram packet to server
			System.out.println("\nSending '" + text + "' to the server.\n");
			datagramSocket.send(outPacket);
			
			//create object UDP to receive from server
			byte receiveBuf [] = new byte [1000];
			DatagramPacket inputPacket = new DatagramPacket (receiveBuf, receiveBuf.length);
			
			//receive data from server
			datagramSocket.receive(inputPacket);
			
			//get number of words in the text
			String textCount = new String (inputPacket.getData());
			//display
			System.out.print("Received from server - Number of words in the text : " +textCount+ ".");
			
			datagramSocket.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}