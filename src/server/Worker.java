package server;

import java.net.*;
import java.io.*;

import servizio.Servizio;

public class Worker extends Thread {
	private Socket client;
	private DataInputStream in;
	private DataOutputStream out;
	private Servizio serv;
	
	public Worker(Socket c, Servizio s){
		
		try{
			serv = s;
			client = c;
			in = new DataInputStream(client.getInputStream());
			out = new DataOutputStream(client.getOutputStream());
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private void chiudi(){
		
		try {
			in.close();
			out.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void run(){
		String com = null;	
		int id = 0;
		try {
			do{
				
				com = in.readUTF();
				System.out.println("[Worker-"+this.getId()+"]: comando letto: "+com);
				
				if((com.compareTo("consegna"))==0){
					id = in.readInt();
					System.out.println("[Worker-"+this.getId()+"]: consegno id: "+id);
					boolean b = serv.consegna(id);
					out.writeBoolean(b);
				}
				else if((com.compareTo("ciao") == 0))
					System.out.println("[Worker-"+this.getName()+"]: chiudo connessione");
				else
					System.out.println("[Worker-"+this.getName()+"]: comando sconosciuto");
				
			}while((com.compareTo("ciao") != 0));
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			chiudi();
		}
	}
}
