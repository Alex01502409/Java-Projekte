package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	
	public void start() {
		try {
			
			socket = new Socket("127.0.0.1", 12345);
			// 127.0.0.1 -> Rechner selbst
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
	}
	
	public void stop() {
		try {
			
			in.close();
			out.close();
			socket.close();
			
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
		
	}
	
	public void senden(String nachricht) {
		try {
			
			out.println(nachricht);
			System.out.println(in.readLine());
			
		} catch(IOException ioex) {
			ioex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Client c = new Client();
		c.start();
		c.senden("Hallo liebe Studierende");
		c.senden("Heute ist Dienstag");
		c.senden("ende");
		c.stop();
	}

}
