public class OrderManager {
    private CoffeeShop coffeeShop;
    private int maxOrders;

    public OrderManager(CoffeeShop coffeeShop, int maxOrders) {
        this.coffeeShop = coffeeShop;
        this.maxOrders = maxOrders;
    }

    public void manageOrders(InputHandler inputHandler) {
        Order[] orders = new Order[maxOrders];
        int orderCount = 0;

        while (orderCount < maxOrders) {
            inputHandler.displayMenu();

            String input = inputHandler.getInput();

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
                inputHandler.displayInvalidInputMessage();
                continue;
            }

            String customerName = parts[0].trim();
            String coffeeChoice = parts[1].trim();

            int choiceNumber;

            try {
                choiceNumber = Integer.parseInt(coffeeChoice);
            } catch (NumberFormatException e) {
                inputHandler.displayInvalidChoiceMessage();
                continue;
            }

            if (choiceNumber < 1 || choiceNumber > 3) {
                inputHandler.displayInvalidChoiceMessage();
                continue;
            }

            int token = coffeeShop.assignToken();
            Customer customer = new Customer(customerName, token);
            coffeeShop.addCustomer(customer);

            Coffee coffee = createCoffee(choiceNumber);

            orders[orderCount++] = new Order(customer, coffee);

            System.out.println(customerName + " (Token #" + token + ") placed an order for a " + coffee.getName());

            if (orderCount >= maxOrders) {
                inputHandler.displayMaxOrdersReached();
            }
        }

        for (int i = 0; i < orderCount; i++) {
            Order order = orders[i];
            coffeeShop.placeOrder(order.getCustomer(), order.getCoffee());
        }

        coffeeShop.processOrders();
    }

    private Coffee createCoffee(int choiceNumber) {
        return switch (choiceNumber) {
            case 1 -> new Espresso();
            case 2 -> new Latte();
            case 3 -> new Cappuccino();
            default -> throw new IllegalArgumentException("Invalid coffee choice");
        };
    }
}
