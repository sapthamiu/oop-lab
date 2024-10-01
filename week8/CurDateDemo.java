import java.util.Scanner;

class InvalidDayException extends Exception {
    public InvalidDayException(String message) {
        super(message);
    }

}

class InvalidMonthException extends Exception {
    public InvalidMonthException(String message) {
        super(message);
    }
}

class CurrentDate {
    private int day;
    private int month;
    private int year;

    public void createDate() throws InvalidDayException, InvalidMonthException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter day: ");
        day = sc.nextInt();

        System.out.print("Enter month: ");
        month = sc.nextInt();

        System.out.print("Enter year: ");
        year = sc.nextInt();

        validateDate();
    }

    private void validateDate() throws InvalidDayException, InvalidMonthException {
        if (month < 1 || month > 12) {
            throw new InvalidMonthException("Invalid month: " + month + ". Month must be between 1 and 12.");
        }

        int dayinmon;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dayinmon = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dayinmon = 30;
                break;
            case 2:
                // Check for leap year
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
                     dayinmon = 29; // Leap year
                else dayinmon = 28; // Non-leap year
                break;
            default: throw new InvalidMonthException("Invalid month: " + month);
        }

        if (day < 1 || day > dayinmon) {
            throw new InvalidDayException("Invalid day: " + day + ". Day must be between 1 and " + dayinmon + ".");
        }
        //prints only if validated
        System.out.println("Current Date: " + day + "/" + month + "/" + year);
    }
}

public class CurDateDemo{
    public static void main(String[] args) {
        CurrentDate currentDate = new CurrentDate();

        try {
            currentDate.createDate();
        } catch (InvalidDayException | InvalidMonthException e) {
            System.out.println(e.getMessage());
        }
    }
}