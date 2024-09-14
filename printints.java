import java.util.Scanner;
class printints{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter no. of elements: ");
		int n= sc.nextInt();
		int[] a= new int [n];
		for(int i=0;i<n;i++){
			a[i]= i+1;
		}
		System.out.println("First "+ n + " elements: ");
		for(int k:a)
			System.out.print(k+" ");
	}
}