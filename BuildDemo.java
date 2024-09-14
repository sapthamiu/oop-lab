import java.util.Scanner;
import com.course.structure.Building;
import com.course.structure.House;
import com.course.structure.School;
public class BuildDemo{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//General Building
		System.out.println("Enter square footage: ");
		double sqft = sc.nextDouble();
		System.out.println("Enter no. of stories: ");
		int stories = sc.nextInt();
		System.out.println("--Menu--\n1. House\n2. School\n3. Exit");
		int choice;
		do{
			System.out.println("Your choice: ");
			choice = sc.nextInt();
			if(choice==1){
				System.out.println("Enter no. of bedrooms: ");
				int bed = sc.nextInt();
				System.out.println("Enter no. of bathrooms: ");
				int bath = sc.nextInt();
				House house = new House(sqft,stories,bed,bath);
				System.out.println("--House Details--");
				house.display();
			}
			else if(choice == 2){
				System.out.println("Enter no. of classrooms: ");
				int clroom = sc.nextInt();
				System.out.println("Enter grade: ");
				String grade = sc.next();
				//sc.next();
				School school = new School(sqft, stories, clroom, grade);
				System.out.println("--School Details--");
				school.display();
			}
			else System.out.println("Exiting.");
		}while(choice == 1 || choice == 2);
		sc.close();
	}
}