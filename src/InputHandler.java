import java.util.Scanner;

public class InputHandler {
    private Scanner scanner = new Scanner(System.in);

    public String getInput() {
        return scanner.nextLine();
    }

    public void closeScanner() {
        scanner.close();
    }

    public void displayMenu() {
        System.out.println("\nEnter customer name and select a coffee type by number:");
        System.out.println("1. Espresso");
        System.out.println("2. Latte");
        System.out.println("3. Cappuccino");
        System.out.println("Type 'done' to start processing orders.\n");
    }

    public void promptToAddMoreOrders() {
        System.out.println("Type 'y' to add more orders, or any other key to exit.");
    }

    public void displayInvalidInputMessage() {
        System.out.println("Invalid input. Please enter the customer name and coffee choice separated by a comma.\n");
    }

    public void displayInvalidChoiceMessage() {
        System.out.println("Invalid coffee choice. Please enter a number between 1 and 3.\n");
    }

    public void displayMaxOrdersReached() {
        System.out.println("Maximum number of orders reached. Type 'done' to start processing or continue to add more orders.");
    }
}
