import java.util.Scanner;
class primes{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int n= sc.nextInt();
		int[] a= new int [n];
		System.out.println("Enter the elements: ");
		for(int i=0;i<n;i++){
			a[i]= sc.nextInt();
		}
		System.out.println("Prime numbers present: ");
		int count=0;
		for(int i=0;i<n;i++){
			int flag=1;
			for(int j=2;j*j<=a[i];j++){
				if(a[i]%j==0){
					flag=0;
					break;
				}
			}
			if(flag==1){
			System.out.print(a[i]+" ");
			count++;
			}
		}
		if(count==0)
			System.out.println("No primes");
	}
}