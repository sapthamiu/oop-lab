import java.util.Scanner;
class ncr{
	public static void main(String args[]){
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a number: ");
		int a= sc.nextInt();
		System.out.println("Factorial = "+fact(a));
		System.out.println("Enter n: ");
		int n= sc.nextInt();
		System.out.println("Enter r: ");
		int r= sc.nextInt();
		int ncr= fact(n)/(fact(r)*fact(n-r));
		System.out.println("nCr= "+ncr);
	}
		public static int fact(int a){
			int f=1;
			for(int i=1;i<=a;i++)
				f*=i;
			return f;
		}
		
}