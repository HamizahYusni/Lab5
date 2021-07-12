import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class ServerUDP {

	public static void main(String[] args) {
		
		System.out.println("ServerSideApp: Demo of UDP");
        
        try {
        	       
        	// Port to receive and respond to request
    		int portNo = 1803;
    		
    		// Create a socket, port 1803
            DatagramSocket datagramSocket = new DatagramSocket(portNo);
            System.out.println("Ready to receive connection... ");
            
        	while (true) {
                
                // Variable to received data
                byte[] receivedBuf = new byte[65535];
          
                // Datagram to hold received packet
                DatagramPacket receivedPacket = new DatagramPacket(receivedBuf, receivedBuf.length);
                
                // Received from client
                datagramSocket.receive(receivedPacket);
				
                // Retrieve data from packet 
                String retreiveMessage = new String(receivedPacket.getData());
                System.out.println("\nText received from client: " + retreiveMessage + ".\n");
				
				
                String numOfWords = Integer.toString(countWords(retreiveMessage));
                System.out.println("Number of words in the text are " + numOfWords+ ".");
				
				
                byte sendBuffer[] = new byte[65535];				
                sendBuffer = numOfWords.getBytes();
				
                //get the client address
                InetAddress cAdd = receivedPacket.getAddress();
                int ClientPort = receivedPacket.getPort();
				
                //create object UDP packet to send to the client
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, cAdd, ClientPort);
				
                //send back the data to client by using DatagramPacket
                datagramSocket.send(sendPacket);
	            
        	}
				
		} catch (IOException e) {
				
			e.printStackTrace();
        }
        
       
    }
	
public static int countWords(String text) {
		
	int noOfWord = 0;
	
	for(int i = 0; i < text.length()-1; i++) {  
        //Counts all the spaces present in the string  
        //It doesn't include the first space as it won't be considered as a word  
        if(text.charAt(i) == ' ' && Character.isLetter(text.charAt(i+1)) && (i > 0)) {  
            noOfWord++;  
        }  
    }  
    //To count the last word present in the string, increment wordCount by 1  
    noOfWord++;  
      
    return noOfWord;
	}
}