import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {
    private static final Logger appLogger = Logger.getLogger("SingletonLoggerDemo");

    public static void main(String[] args) {
        AppLogger logger = AppLogger.getInstance(); 
        Scanner scanner = new Scanner(System.in);

        final int EXIT = 2;
        int choice;
        do {
            System.out.println("\n--- Singleton Logger ---");
            System.out.println("1. Log Message");
            System.out.println("2. Exit");
            choice = getChoice(scanner, 1, EXIT);

            switch (choice) {
                case 1:
                    System.out.print("Enter message to log: ");
                    String msg = scanner.nextLine();
                    logger.log(msg); // ✅ your singleton log
                    break;

                default:
                    break;
            }
        } while (choice != EXIT);

        scanner.close();
        appLogger.log(Level.INFO, "Exited Singleton demo.");
    }

    private static int getChoice(Scanner scanner, int min, int max) {
        int c = -1;
        while (c < min || c > max) {
            System.out.print("Choose option (" + min + "-" + max + "): ");
            try {
                c = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        return c;
    }
}
