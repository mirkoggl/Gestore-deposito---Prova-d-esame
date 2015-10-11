package client;

import servizio.Servizio;
import java.net.*;
import java.io.*;

public class ServizioProxy implements Servizio {
	private Socket client;
	private DataInputStream in;
	private DataOutputStream out;
	private String ind = null;
	private int port = 0;
	
	public ServizioProxy(String s, int x){

		ind = s;
		port = x;
		
	}
	
	private void connetti(){
		
		try {
			
			client = new Socket(ind,port);
			in = new DataInputStream(client.getInputStream());
			out = new DataOutputStream(client.getOutputStream());
			
		} catch (IOException e) {
			stampa_err(e);
			e.printStackTrace();
		}
	}
	private void stampa_err(Exception e) {
		e.printStackTrace();
		System.err.println("Errore di IO!");
		}
	
	private void chiudi(){
		
		try {
			
			out.writeUTF("ciao");
			in.close();
			out.close();
			client.close();
			
		} catch (IOException e) {
			stampa_err(e);
		}
		
	}
	public boolean consegna(int id) {
		boolean b = false;
		connetti();
		try{
			
			out.writeUTF("consegna");
			out.writeInt(id);
			b = in.readBoolean();
			
		}catch(IOException e){
			stampa_err(e);
		}finally{
			chiudi();
		}
		return b;
	}

}
