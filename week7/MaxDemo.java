import myPackages.p1.Maximum;
import java.util.Scanner;
public class MaxDemo{
	public static void main(String[] args){
		Maximum maximum = new Maximum();
		Scanner sc = new Scanner(System.in);
		System.out.println("--Menu--\nWhat do you want to find the maximum in?\n1. 3 integers\n2. 3 floating points\n3. 1D array\n4. 2D Matrix\n5. Exit");
		int choice;
		do{
			System.out.println("Your choice: ");
			choice = sc.nextInt();
			switch(choice){
				case 1: System.out.println("Enter 3 integers: ");
						int a = sc.nextInt();
						int b = sc.nextInt();
						int c = sc.nextInt();
						System.out.println("Maximum: " + maximum.max(a,b,c));
						break;
				case 2: System.out.println("Enter 3 floating points: ");
						float p = sc.nextFloat();
						float q = sc.nextFloat();
						float r = sc.nextFloat();
						System.out.println("Maximum: " + maximum.max(p,q,r));
						break;
				case 3: System.out.println("Enter size of array: ");
						int size = sc.nextInt();
						System.out.println("Enter the elements: ");
						int []arr = new int[size];
						for(int i = 0;i<size;i++)
							arr[i] = sc.nextInt();
						System.out.println("Maximum: " + maximum.max(arr));
						break;
			    case 4: System.out.println("Enter dimensions of the matrix: ");
			    		int m = sc.nextInt();
			    		int n = sc.nextInt();
			    		System.out.println("Enter the elements: ");
			    		int mat [][] = new int [m][n];
			    		for(int i = 0; i<m;i++)
			    			for(int j = 0; j<n;j++)
			    				mat[i][j]= sc.nextInt();
			    		System.out.println("Maximum: "+ maximum.max(mat));
			    		break;
				case 5: System.out.println("Exiting");
						break;
				default: System.out.println("Invalid input");		
			}
		}while(choice!=5);
	}
}