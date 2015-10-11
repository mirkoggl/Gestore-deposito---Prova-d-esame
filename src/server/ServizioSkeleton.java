package server;

import servizio.Servizio;

import java.io.IOException;
import java.net.*;

public abstract class ServizioSkeleton implements Servizio {
	private ServerSocket server;
	private int port = 0;
	
	public ServizioSkeleton (int x){
		
		port = x;
		try {
			
			server = new ServerSocket(port);
			System.out.println("[Server]: in ascolto su port "+port);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void runskeleton(){
		
		try {
			while(true){
				
				Socket client = server.accept();
				Worker t = new Worker(client,this);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
