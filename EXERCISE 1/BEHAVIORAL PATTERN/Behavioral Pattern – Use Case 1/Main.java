import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        Stack<Command> history = new Stack<>();

        final int EXIT = 4;
        int choice;
        do {
            System.out.println("\n--- Command Pattern: Text Editor ---");
            System.out.println("1. Write Text");
            System.out.println("2. Undo Last");
            System.out.println("3. Show Text");
            System.out.println("4. Exit");
            choice = getChoice(scanner, 1, EXIT);

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String text = scanner.nextLine();
                    Command cmd = new WriteCommand(editor, text);
                    cmd.execute();
                    history.push(cmd);
                    logger.info("Text written.");
                    break;

                case 2:
                    if (!history.isEmpty()) {
                        Command last = history.pop();
                        last.undo();
                        logger.info("Undo executed.");
                    } else {
                        System.out.println("Nothing to undo.");
                    }
                    break;

                case 3:
                    System.out.println("Current Text: " + editor.getText());
                    break;

                default:
                    break;
            }
        } while (choice != EXIT);

        scanner.close();
        logger.info("Exited Command demo.");
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
