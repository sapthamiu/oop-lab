import java.util.GregorianCalendar;
import java.util.Scanner;

class SeatsFilledException extends Exception {
    public SeatsFilledException(String message) {
        super(message);
    }
}

class StudentExcept {
    String name;
    int reg;
    GregorianCalendar doj;
//    short sem;
//    float gpa;
//    float cgpa;
    static int count = 0;

    StudentExcept(String nm, int day, int month, int year /*,short sm, float gp, float cgp*/) throws SeatsFilledException {
        ++count;
        name = nm;
        doj = new GregorianCalendar(year, month, day);
        reg = getReg(doj);
        if ((reg%100) > 2) {
            throw new SeatsFilledException("Registration number " + reg + " exceeds the limit.");
        }
//        sem = sm;
//        gpa = gp;
//        cgpa = cgp;
    }

    public int getReg(GregorianCalendar doj) {
        int yr = doj.get(GregorianCalendar.YEAR);
        return ((yr % 100) * 100) + count;
    }

    public void disp() {
        System.out.println("\nName: " + name + "\nRegistration number: " + reg);
       // System.out.println("Sem: " + sem + "\nGPA: " + gpa + "\nCGPA: " + cgpa);
    }
}

public class StudentExceptDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentExcept[] students = new StudentExcept[5];

        for (int i = 0; i < 5; ) {
            System.out.println("Enter name: ");
            String nm = sc.nextLine();
            try {
                System.out.print("Date of Joining (YYYY MM DD): ");
                int year = sc.nextInt();
                int month = sc.nextInt() - 1; // Months are 0-based in GregorianCalendar
                int day = sc.nextInt();
//                System.out.println("Enter sem, gpa, cgpa: ");
//                short sm = sc.nextShort();
//                float gp = sc.nextFloat();
//                float cgp = sc.nextFloat();
                sc.nextLine();

                students[i] = new StudentExcept(nm, day, month, year/*, sm, gp, cgp*/);
                i++;
            } catch (SeatsFilledException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
            System.out.println("-----------------STUDENT DETAILS-----------------");
            for (StudentExcept student : students) {
                if (student != null) {
                    student.disp();
                }
            }
            sc.close();

    }
}