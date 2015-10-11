package server;

import servizio.Servizio;

public class ServImpl extends ServizioSkeleton{
	private Coda coda;
	
	public ServImpl(int x, Coda c) {
		
		super(x);
		coda = c;
		
	}

	public boolean consegna(int id) {
		
		synchronized(coda){
			while(coda.isFull()){
				try {
					coda.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			coda.enqueue(id);
			coda.notify();
		}
		
		return true;
	}
	
}
