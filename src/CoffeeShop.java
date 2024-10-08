import java.util.LinkedList;
import java.util.Queue;

public class CoffeeShop {

    private CoffeeMachine coffeeMachine;

    private Queue<Order> orders;

    private Queue<Integer> availableTokens;

    public CoffeeShop(CoffeeMachine coffeeMachine, int maxTokens) {
        this.coffeeMachine = coffeeMachine;
        this.orders = new LinkedList<>();
        this.availableTokens = new LinkedList<>();
        for (int i = 1; i <= maxTokens; i++) {
            availableTokens.add(i);
        }
    }

    public void addCustomer(Customer customer) {
        System.out.println("Welcome, " + customer.getName() + "! Your token number is: " + customer.getToken());
    }

    public void placeOrder(Customer customer, Coffee coffee) {
        Order order = new Order(customer, coffee);
        orders.add(order);
        customer.placeOrder(order);
    }

    public void processOrders() {
        if (!coffeeMachine.isMachineOn()) {
            System.out.println("Please turn on the coffee machine before processing orders.");
            return;
        }
        System.out.println("\nProcessing Orders...");
        while (!orders.isEmpty()) {
            Order order = orders.poll();
            coffeeMachine.prepareCoffee(order);
            availableTokens.add(order.getCustomer().getToken());
        }
    }

    public int assignToken() {
        if (availableTokens.isEmpty()) {
            throw new IllegalStateException("No available tokens. Please wait.");
        }
        return availableTokens.poll();
    }
}
