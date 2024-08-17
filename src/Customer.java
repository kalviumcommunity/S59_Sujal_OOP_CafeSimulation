public class Customer {
    private String name;
    private int token;

    public String getName() {
        return name;
    }

    public int getToken() {
        return token;
    }

    public void placeOrder(Order order) {
        System.out.println(name + " (Token #" + token + ") placed an order for a " + order.getCoffee().getName());
    }
}
