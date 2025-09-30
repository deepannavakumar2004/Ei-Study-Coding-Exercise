import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChatRoom chatRoom = new ChatRoom();

        int numUsers = getPositiveInt(scanner, "Enter number of users: ");
        for (int i = 1; i <= numUsers; i++) {
            chatRoom.addUser(new ChatUser("User" + i));
        }

        final int EXIT = 3;
        int choice;
        do {
            System.out.println("\n--- Chat Room ---");
            System.out.println("1. Send Direct Message");
            System.out.println("2. Show Users");
            System.out.println("3. Exit");
            choice = getChoice(scanner, 1, EXIT);

            List<ChatUser> users = chatRoom.getUsers();
            switch (choice) {
                case 1:
                    int from = getUserIndex(scanner, users.size(), "From user (1-" + users.size() + "): ");
                    int to = getUserIndex(scanner, users.size(), "To user (1-" + users.size() + "): ");
                    System.out.print("Enter message: ");
                    String msg = scanner.nextLine();
                    users.get(from).sendMessage(msg, users.get(to));
                    break;

                case 2:
                    System.out.println("Users:");
                    for (int i = 0; i < users.size(); i++) {
                        System.out.println((i + 1) + ". " + users.get(i).getName());
                    }
                    break;

                default:
                    break;
            }
        } while (choice != EXIT);

        scanner.close();
    }

    private static int getPositiveInt(Scanner scanner, String prompt) {
        int num = -1;
        while (num <= 0) {
            System.out.print(prompt);
            try {
                num = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid positive number.");
            }
        }
        return num;
    }

    private static int getUserIndex(Scanner scanner, int max, String prompt) {
        int idx = -1;
        while (idx < 0 || idx >= max) {
            System.out.print(prompt);
            try {
                idx = Integer.parseInt(scanner.nextLine().trim()) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number between 1 and " + max);
            }
        }
        return idx;
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
