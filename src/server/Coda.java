package server;

public class Coda {
	private int dim = 0;
	private int num_el = 0;
	private int testa = 0;
	private int coda = 0;
	private int lista[];
	
	public Coda(int x){
		
		dim = x;
		lista = new int[dim];
		
	}
	
	public boolean isEmpty(){
		boolean b = false;
		
		if(num_el == 0){
			b = true;
			System.out.println("Coda vuota!");
		}
		return b;
	}
	
	public boolean isFull(){
		boolean b = false;
		
		if(num_el == dim){
			b = true;
			System.out.println("Coda piena!");
		}
		
		return b;
	}
	
	public void enqueue(int x){
		if (!isFull()){
			lista[coda] = x;
			coda = (coda+1)%dim;
			num_el++;
		}
	}
	
	public int dequeue(){
		int x = -1;
		if(!isEmpty()){
			x = lista[testa];
			testa = (testa+1)%dim;
			num_el--;
		}
		return x;
	}
	
	public void stampa(){
		int temp = testa;
		
		if(!isEmpty()){
			System.out.println("Stampa Coda: ");
			for (int i=0; i<num_el; i++){
				System.out.println("["+i+"]: "+lista[temp]);
				temp = (temp+1)%dim;
			}
		}
	}

}
