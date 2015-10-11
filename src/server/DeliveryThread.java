package server;

import java.io.*;

public class DeliveryThread extends Thread {
	private Coda coda;
	private String file;
	private FileOutputStream fos;
	private BufferedOutputStream bos;
	private DataOutputStream out;
	
	public DeliveryThread(Coda c,String nome) {
		
		coda = c;
		file = nome;
		
		try {
			
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			out = new DataOutputStream(bos);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		System.out.println("[DeliveryThread]: avviato!");
	}
	
	private void chiudi(){
		try {
			out.close();
			bos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		System.out.println("[DeliveryThread]: partito!");
		
		try{
		
			while(true){
				synchronized(coda){
					while(coda.isEmpty()){
						coda.wait();
					}
					while(!coda.isEmpty()){
						int x = coda.dequeue();
						out.writeInt(x);
					}
					coda.notify();
					System.out.println("[DeliveryThread]: coda svuotata!");
				}
				out.flush();
				this.sleep(10000);
			}
		}
		catch(IOException | InterruptedException e){
			e.printStackTrace();
		}finally{
			chiudi();
		}
	}
}
