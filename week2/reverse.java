import java.util.Scanner;
class reverse{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the size of array: ");
		int n= sc.nextInt();
		int[] a= new int [n];
		System.out.println("Enter the elements: ");
		for(int i=0;i<n;i++){
			a[i]= sc.nextInt();
		}
		System.out.println("Reversed Elements: ");
		for(int i=n-1;i>=0;i--)
			System.out.print(a[i]+" ");
	}
}