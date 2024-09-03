import java.util.Scanner;
class trimat{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		int[][] a= new int [10][];
		for(int i=0;i<10;i++)
			a[i]= new int[i+1];
		for(int i=0;i<10;i++)
			for(int j=0;j<i+1;j++)
				a[i][j]= i+j;
		System.out.println("Matrix: ");
		for(int x[]:a){
			for(int y: x)
				System.out.print(y+ " ");
			System.out.println();
		}
	}
}