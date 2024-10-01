import java.util.Scanner;
interface Series{
    int getNext();
    void reset();
    void setStart(int x);
}
class ByTwos implements Series{
    private int start;
    private int current;
    public ByTwos(){
        start = 0;
        current = 0;
    }
    public int getNext(){
        current+=2;
        return current;
    }
    public void reset(){
        current = start;
    }
    public void setStart(int x){
        start = x;
        current = x;
    }
}
public class SeriesDemo{
    public static void main(String[] args){
        ByTwos series = new ByTwos();
        series.setStart(0);
        System.out.println("Enter the no. of terms in the series: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("--Menu--\n1. Display series\n2. Reset series\n3. Set Start and display\n4. Exit ");
        int choice;
        do{
            System.out.print("\nYour choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1: //display
                        System.out.print("First " + n + " terms: ");
                        for(int i = 0; i<n; i++)
                            System.out.print(series.getNext() + " ");
                        break;
                case 2: //reset
                        series.reset();
                        System.out.print("Resetting series. First " + n + " terms: ");
                        for(int i = 0; i<n; i++)
                            System.out.print(series.getNext() + " ");
                        break;
                case 3: //set start
                        System.out.println("Enter start term: ");
                        int x = sc.nextInt();
                        series.setStart(x);
                        System.out.println("Starting series from " + x + ": ");
                        for(int i = 0; i<n; i++)
                            System.out.print(series.getNext() + " ");
                        break;
                case 4: System.out.println("Exiting. ");
                        break;
                default: System.out.println("Invalid output");
            }
        }while(choice!=4);
    }
}