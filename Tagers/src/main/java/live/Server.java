package live;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	int port = 6666;

	public void live() {

		try (ServerSocket serverSocket = new ServerSocket(port)) {

			System.out.println("Server is listening on port " + port);
			
			
			
			while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
 
                new ServerThread(socket).start();
			}	

		} catch (IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}


	}
}
