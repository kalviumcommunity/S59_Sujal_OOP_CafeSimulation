public class Order {
    private Customer customer;
    private Coffee coffee;

    public Order(Customer customer, Coffee coffee) {
        this.customer = customer;
        this.coffee = coffee;
    }

     public Customer getCustomer() {
         return customer;
     }

     public Coffee getCoffee() {
         return coffee;
     }
}
