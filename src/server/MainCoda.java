package server;

public class MainCoda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coda c = new Coda(5);
		
		c.stampa();
		c.dequeue();
		c.enqueue(5);
		c.stampa();
		c.enqueue(11);
		c.enqueue(12);
		c.stampa();
		c.enqueue(3);
		c.enqueue(611);
		c.enqueue(41);
		c.enqueue(12);
		c.enqueue(11);
		c.enqueue(12);
		c.stampa();
		c.dequeue();
		c.stampa();
		c.dequeue();
		c.stampa();
		c.enqueue(49);
		c.stampa();
		c.enqueue(90);
		c.stampa();

	}

}
