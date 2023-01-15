import java.util.Scanner;

public class GradesClient {
    private static final int READ = 1;
    private static final int ADD = 2;
    private static final int REMOVE = 3;
    private static final int DROP = 4;
    private static final int DISPLAY = 5;
    private static final int SORT = 6;
    private static final int AVERAGE = 7;
    private static final int EXIT = 8;

    private GradeList grades = new GradeList();

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int choice = -1;
        GradesClient client = new GradesClient();

        while (choice != EXIT) {
            displayMenu();

            System.out.print("Enter your numerical choice: ");
            choice = Integer.parseInt(console.next());

            switch (choice) {
                case READ:
                    client.readGrades(console);
                    break;
                case ADD:
                    client.addGrade(console);
                    break;
                case REMOVE:
                    client.removeAll(console);
                    break;
                case DROP:
                    client.dropLowest();
                    break;
                case DISPLAY:
                    client.displayGrades();
                    break;
                case SORT:
                    client.displaySorted();
                    break;
                case AVERAGE:
                    client.calcAverage();
                    break;
                case EXIT:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("That choice is not valid " + choice);
            }
        }
    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("*************************************");
        System.out.println("1. Read grades from file");
        System.out.println("2. Add grade");
        System.out.println("3. Remove all grades");
        System.out.println("4. Drop lowest grade");
        System.out.println("5. Display grades");
        System.out.println("6. Sort grades");
        System.out.println("7. Calculate average");
        System.out.println("8. Exit");
        System.out.println("*************************************");
        System.out.println();

    }

    private void readGrades(Scanner console) {
        System.out.print("Enter a filename to read the grades from: ");
        String fileName = console.next();

        System.out.println("***** Reading in grades from " + fileName + " *****");
        grades.readGrades(fileName);

    }

    private void calcAverage() {
        System.out.printf("Average is %.2f", grades.calcAverage());
    }

    private void addGrade(Scanner console) {
        System.out.print("Enter a grade to add: ");
        String number = console.next();
        try {
            double grade = Double.parseDouble(number);
            System.out.println("***** Adding grade " + grade + " *****");
            grades.addGrade(grade);
        } catch (NumberFormatException e) {
            System.out.println("You did not enter a valid grade: " + e.getMessage());
        }

    }

    private void removeAll(Scanner console) {
        System.out.print("Enter a grade to remove: ");
        while (!console.hasNextDouble()) {
            console.next();
            System.out.println("You did not enter a valid grade: try again.");
            System.out.print("Enter a grade to remove:");
        }
        double grade = Double.parseDouble(console.next());

        boolean removed = grades.removeAllGrades(grade);
        if (removed) {
            System.out.println("***** Removed ALL occurances of " + grade + " *****");
        } else {
            System.out.println("***** No grade," + grade + ", found to remove *****");
        }

    }

    private void dropLowest() {
        System.out.println("Lowest grade dropped: " + grades.dropLowest());
    }

    private void displayGrades() {
        System.out.println(grades);
    }

    private void displaySorted() {
        grades.printSortedGrades();
    }

}