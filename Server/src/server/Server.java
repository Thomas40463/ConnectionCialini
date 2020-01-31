package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server {

	public static void main(String[] args)  {
	
	
		ServerSocket sSocket = null;
		Socket connessione=null;
		int porta=3500;
		int time=6;
                                String messaggio;
                               
		
		
		try { 
			sSocket = new ServerSocket(porta);
		} catch (IOException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
		}
		//while(true) {
			try {
		
			sSocket.setSoTimeout(time*1000);
			System.out.println("in attesa di connessioni...");
			CountDown cd=new CountDown(time);
			Thread t=new Thread(cd);
			t.start();
			connessione= sSocket.accept();
                                                BufferedReader in= new BufferedReader(new InputStreamReader(connessione.getInputStream()));
                                                PrintWriter out=new PrintWriter(connessione.getOutputStream(),true);
                                                messaggio=in.readLine();
                                                System.out.println("Messaggio dal client: " + messaggio);
                                                out.println("Ciao");
			cd.setFlag();
			System.out.println("Connessione stabilita");			
			System.out.println("connessione chiusa");
		}
			
		catch(SocketTimeoutException ste){
			System.err.println("connessione scaduta");
			
		}
		catch (IOException ex) {
			System.err.println("errore");	
		}finally{
				try {
					if(connessione != null){
					connessione.close();}
				} catch (IOException ex) {
					Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		 
		// }
	}
	
}
