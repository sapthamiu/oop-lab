import java.util.Scanner;
class addmat{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter dimensions of the matrices: ");
		int m= sc.nextInt();
		int n= sc.nextInt();
		int[][] a= new int[m][n];
		int[][] b= new int[m][n];
		System.out.println("Enter the elements of first matrix: ");
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				a[i][j]= sc.nextInt();
		System.out.println("Enter the elements of second matrix: ");
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				b[i][j]= sc.nextInt();
		System.out.println("Resultant matrix: ");
		int[][] c= new int[m][n];
		for(int i=0;i<m;i++)
		{	for(int j=0;j<n;j++)
				c[i][j]=a[i][j]+b[i][j];
		}
		for(int x[]: c)
		{	for(int y: x)
				System.out.print(y+ " ");
			System.out.println();
		}
	}
}