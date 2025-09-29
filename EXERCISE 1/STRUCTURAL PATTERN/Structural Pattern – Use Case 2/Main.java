import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int EXIT = 5;
        int choice;
        do {
            System.out.println("\n--- Decorator Pattern: Pizza Menu ---");
            System.out.println("1. Plain Pizza");
            System.out.println("2. Plain + Cheese");
            System.out.println("3. Plain + Olives");
            System.out.println("4. Plain + Cheese + Olives");
            System.out.println("5. Exit");
            choice = getChoice(scanner, 1, EXIT);

            Pizza pizza;
            switch (choice) {
                case 1 -> pizza = new PlainPizza();
                case 2 -> pizza = new Cheese(new PlainPizza());
                case 3 -> pizza = new Olives(new PlainPizza());
                case 4 -> pizza = new Olives(new Cheese(new PlainPizza()));
                default -> pizza = null;
            }

            if (pizza != null) {
                System.out.println("Description: " + pizza.getDescription());
                System.out.println("Total Cost: $" + pizza.getCost());
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
