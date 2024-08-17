import java.util.LinkedList;
import java.util.Queue;

public class CoffeeShop {

    private CoffeeMachine coffeeMachine;

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
}
