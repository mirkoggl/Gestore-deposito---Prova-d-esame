package server;

public class MainServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coda c = new Coda(20);
		DeliveryThread d = new DeliveryThread(c,"./coda.txt");
		ServImpl serv = new ServImpl(8000,c);
		
		d.start();
		serv.runskeleton();
	

	}

}
