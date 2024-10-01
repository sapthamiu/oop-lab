import java.util.Scanner;
class Student7 {
    private int rollno;
    private int marks;
    public void getNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Roll no.: ");
        rollno = sc.nextInt();
    }
    public void putNumber(){
        System.out.println("Roll No.: " + rollno);
    }
    public void getMarks(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks: ");
        marks = sc.nextInt();
    }
    public void putMarks(){
        System.out.println("Marks: " + marks);
    }
    public int getMarks1(){return marks; }
}
interface Sports{ void putGrade();}
class Result extends Student7 implements Sports{
    private char grade;
    public void getGrade(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sports grade: ");
        grade = sc.next().charAt(0);
    }
    public void putGrade(){
        System.out.println("Sports grade: " + grade);
    }
    public void displayRes(){
        putNumber();
        putMarks();
        putGrade();
        System.out.print("Final result: ");
        if(getMarks1()>=85 && grade == 'A'){
            System.out.println("Distinction");
        }
        else if(getMarks1()>=60){
            System.out.println("First Class");
        }
        else if(getMarks1()>=35){
            System.out.println("Second Class");
        }
        else{
            System.out.println("Fail");
        }
    }
}
public class Studemointer {
    public static void main(String[] args){
        Result stud = new Result();
        stud.getNumber();
        stud.getMarks();
        stud.getGrade();
        stud.displayRes();
    }
}