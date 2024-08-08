public class CoffeeMachine {
    private boolean isOn;

    public CoffeeMachine() {
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Coffee machine is now ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Coffee machine is now OFF.");
    }

    public boolean isMachineOn() {
        return isOn;
    }

    public void prepareCoffee(Order order) {
        if (isOn) {
            Coffee coffee = order.getCoffee();
            Customer customer = order.getCustomer();
            coffee.prepare();

            try {
                int preparationTime = coffee.getPreparationTime();
                System.out.println(
                        "Preparing " + coffee.getName() + ". Please wait for " + preparationTime + " seconds...");
                Thread.sleep(preparationTime * 1000); //
            } catch (InterruptedException e) {
                System.out.println("Coffee preparation interrupted.");
            }

            System.out.println(coffee.getName() + " is ready for " + customer.getName()
                    + " (Token #" + customer.getToken() + ")");
        } else {
            System.out.println("Cannot prepare coffee for Token #" + order.getCustomer().getToken()
                    + ". Check machine status or resources.");
        }
    }
}
