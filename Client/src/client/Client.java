package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client {

	public static void main(String[] args) {
		Socket connessione;
		String server = "localhost";
		int porta = 3500;
                                String messaggio;
                                
		try {
                    
			connessione= new Socket(server,porta);
			System.out.println("connessione aperta");
                                                BufferedReader in= new BufferedReader(new InputStreamReader(connessione.getInputStream()));
                                                PrintWriter out=new PrintWriter(connessione.getOutputStream(), true);
                                                out.println("Hello");
                                                messaggio=in.readLine();
                                                System.out.println("Messaggio dal Server" +messaggio);
			connessione.close();
			System.out.println("connessione chiusa");
		} catch (IOException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
}
