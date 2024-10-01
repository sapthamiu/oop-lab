import java.util.Scanner;
class MatThread implements Runnable{
	String name;
	Thread t;
	int sum;
	int [] row;
	Matrix mat;
	public MatThread(String tname, int[] row){
		name = tname;
		this.row = row;
		t = new Thread(this, name);
		mat = new Matrix();
		System.out.println(t);
		t.start();
	}

	public void run(){
		try{
			sum = mat.rsum(row);
			Thread.sleep(500);
		}catch(InterruptedException e){
			System.out.print("Interrupted");
		}
	}
}
class Matrix{
	public int rsum(int[] row){
		int sum = 0;
		for(int ele:row)
			sum += ele;
		System.out.println("Rowsum: " + sum);
		return sum; 
	}
}

public class MatThreadDemo{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int [][] mat = new int[3][3];
		System.out.print("Enter matrix");
		for(int i = 0; i<3; i++)
			for(int j = 0; j<3; j++)
				mat[i][j] = sc.nextInt();
		int matsum = 0;
		MatThread []threads = new MatThread[3];
		for(int i = 0; i<mat.length; i++){ 
			threads[i] = new MatThread("Row " + i, mat[i]);
		}
		for(MatThread thread: threads){
			try{
				thread.t.join();
				matsum+= thread.sum;
				//Thread.sleep(10000);
			}catch(InterruptedException e){
				System.out.print("Interrupted");
			}
		}
		System.out.print("Sum = "+matsum);
	}
}
