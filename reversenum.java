import java.util.Scanner;
class reversenum{
	public static void main(String args[]){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n=sc.nextInt();
		System.out.println("Reversed number= "+reversed(n));
	}
	public static int reversed(int n){
		int temp=n;
		int rev=0;
		int dig;
		while(temp>0){
			dig= temp%10;
			rev= rev*10 + dig;
			temp/=10;
		}
		return rev;
	}
}
