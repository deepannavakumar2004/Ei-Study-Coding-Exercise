import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportFactory factory = new ReportFactory();

        final int EXIT = 3;
        int choice;
        do {
            System.out.println("\n--- Report Generator (Factory) ---");
            System.out.println("1. Generate PDF Report");
            System.out.println("2. Generate Excel Report");
            System.out.println("3. Exit");
            choice = getChoice(scanner, 1, EXIT);

            switch (choice) {
                case 1 -> {
                    Report r = factory.getReport("pdf");
                    if (r != null) r.generate();
                }
                case 2 -> {
                    Report r = factory.getReport("excel");
                    if (r != null) r.generate();
                }
            }
        } while (choice != EXIT);

        scanner.close();
    }

    private static int getChoice(Scanner scanner, int min, int max) {
        int c = -1;
        while (c < min || c > max) {
            System.out.print("Choose option (" + min + "-" + max + "): ");
            try { c = Integer.parseInt(scanner.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Please enter a valid number."); }
        }
        return c;
    }
}
