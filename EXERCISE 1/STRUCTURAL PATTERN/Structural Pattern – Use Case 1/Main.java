import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileReaderInterface reader = new FileReaderAdapter(new LegacyFileReader());

        final int EXIT = 2;
        int choice;
        do {
            System.out.println("\n--- Adapter Pattern: File Reader ---");
            System.out.println("1. Read File");
            System.out.println("2. Exit");
            choice = getChoice(scanner, 1, EXIT);

            if (choice == 1) {
                System.out.print("Enter file path: ");
                String path = scanner.nextLine();
                Path p = Paths.get(path);
                if (Files.isDirectory(p)) {
                    System.out.println("Error: path refers to a directory, not a file.");
                } else {
                    System.out.println("\nFile Contents:\n" + reader.readFile(path));
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
