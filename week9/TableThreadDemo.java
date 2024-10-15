class TableThread extends Thread{
	int n;
	Table m;
	public TableThread(int n){
		m = new Table();
		this.n = n;
		start();
	}
	public void run(){
		try{
			m.multiply(n);
			sleep(500);
		}catch(InterruptedException e){
			System.out.print("Interrupted");
		}
	}
}

class Table{
	final int lim = 10;
	public void multiply(int n){
		for(int i = 1; i <= lim; i++)
			System.out.println(n + " x " + i + " = " + n*i);
	}
}

public class TableThreadDemo{
	public static void main(String[] args){
		TableThread T1 = new TableThread(5);
		TableThread T2 = new TableThread(7);
	}
}