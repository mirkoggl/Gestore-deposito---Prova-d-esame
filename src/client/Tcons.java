package client;

public class Tcons extends Thread{
	private ServizioProxy serv;
	
	public Tcons(){
		
		serv = new ServizioProxy("127.0.0.1",8000);
		
	}
	
	public void run(){
		int id = 0;
		boolean b = false;
		for (int i=0; i<4; i++){
			id = ((int) (Math.random()*100))%3;
			System.out.println("[Thread-"+this.getName()+"]: Generato id: "+id);
			b = serv.consegna(id);
			if (b==true)
				System.out.println("[Thread-"+this.getName()+"]: id "+id+" spedito!");
			else 
				System.out.println("[Thread-"+this.getName()+"]: invio id fallito! ");	
		}
	}

}
