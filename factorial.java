import java.util.Scanner;
class factorial{
	public static void main(String args[]){
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a number: ");
		int a= sc.nextInt();
		System.out.println("Factorial = "+fact(a));
	}
		public static int fact(int a){
			int f=1;
			for(int i=1;i<=a;i++)
				f*=i;
			return f;
		}
		
}