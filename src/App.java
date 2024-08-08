import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        coffeeMachine.turnOn();
        Scanner scanner = new Scanner(System.in);

        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("Enter customer name:");
            String customerName = scanner.nextLine();

            if (customerName.trim().isEmpty()) {
                System.out.println("Customer name cannot be empty. Please try again.");
                continue;
            }

            System.out.println("\nSelect a coffee type by number:");
            System.out.println("1. Espresso");
            System.out.println("2. Latte");
            System.out.println("3. Cappuccino");
            System.out.println("Type 'exit' to quit.");

            String coffeeChoice = scanner.nextLine();

            if (coffeeChoice.equalsIgnoreCase("exit")) {
                keepRunning = false;
                break;
            }

            int token = 1;
            Customer customer = new Customer(customerName, token);

            Coffee coffee;
            switch (coffeeChoice) {
                case "1":
                    coffee = new Espresso();
                    break;
                case "2":
                    coffee = new Latte();
                    break;
                case "3":
                    coffee = new Cappuccino();
                    break;
                default:
                    System.out.println("Invalid coffee choice. Please enter 1, 2, or 3.");
                    continue;
            }

            Order order = new Order(customer, coffee);

            System.out.println(customerName + " (Token #" + token + ") placed an order for a " + coffee.getName());

            coffeeMachine.prepareCoffee(order);

            System.out
                    .println("Would you like to place another order? Type 'exit' to quit or press Enter to continue.");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("exit")) {
                keepRunning = false;
            }
        }

        coffeeMachine.turnOff();
        scanner.close();
    }
}
