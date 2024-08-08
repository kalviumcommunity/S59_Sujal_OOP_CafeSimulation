import java.util.Scanner;

public class App {
    private static final int MAX_ORDERS = 4;

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        CoffeeShop coffeeShop = new CoffeeShop(coffeeMachine, MAX_ORDERS);

        coffeeMachine.turnOn();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Order[] orders = new Order[MAX_ORDERS];
            int orderCount = 0;

            while (orderCount < MAX_ORDERS) {
                System.out.println("\nEnter customer name and select a coffee type by number:");
                System.out.println("1. Espresso");
                System.out.println("2. Latte");
                System.out.println("3. Cappuccino");
                System.out.println("Type 'done' to start processing orders.\n");

                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("done")) {
                    if (orderCount > 0) {
                        break;
                    } else {
                        System.out.println("No orders to process. Enter orders before starting.\n");
                        continue;
                    }
                }

                String[] parts = input.split(",");
                if (parts.length != 2) {
                    System.out.println(
                            "Invalid input. Please enter the customer name and coffee choice separated by a comma.\n");
                    continue;
                }

                String customerName = parts[0].trim();
                String coffeeChoice = parts[1].trim();

                int choiceNumber;

                try {
                    choiceNumber = Integer.parseInt(coffeeChoice);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid coffee choice. Please enter a number between 1 and 3.\n");
                    continue;
                }

                if (choiceNumber < 1 || choiceNumber > 3) {
                    System.out.println("Invalid coffee choice: " + coffeeChoice + "\n");
                    continue;
                }

                int token = coffeeShop.assignToken();
                Customer customer = new Customer(customerName, token);
                coffeeShop.addCustomer(customer);

                Coffee coffee = switch (choiceNumber) {
                    case 1 -> new Espresso();
                    case 2 -> new Latte();
                    case 3 -> new Cappuccino();
                    default -> null;
                };

                orders[orderCount++] = new Order(customer, coffee);

                System.out.println(customerName + " (Token #" + token + ") placed an order for a " + coffee.getName());

                if (orderCount >= MAX_ORDERS) {
                    System.out.println(
                            "Maximum number of orders reached. Type 'done' to start processing or continue to add more orders.");
                }
            }

            for (int i = 0; i < orderCount; i++) {
                Order order = orders[i];
                coffeeShop.placeOrder(order.getCustomer(), order.getCoffee());
            }

            coffeeShop.processOrders();

            System.out.println("All orders have been processed. Type 'exit' to quit or press Enter to add new orders.");

            String userInput = scanner.nextLine();
            
            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }
        }

        coffeeMachine.turnOff();
        scanner.close();
    }
}
