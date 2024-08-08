public class CoffeeMachine {
    private boolean isOn;
    private int waterLevel;
    private int beanLevel;

    public CoffeeMachine() {
        this.isOn = false;
        this.waterLevel = 100;
        this.beanLevel = 100;
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

    public boolean hasEnoughResources() {
        return waterLevel > 0 && beanLevel > 0;
    }

    public void useResources() {
        if (waterLevel > 0 && beanLevel > 0) {
            this.waterLevel -= 5;
            this.beanLevel -= 5;
            System.out.println("Resources used: Water Level = " + waterLevel + ", Bean Level = " + beanLevel);
        } else {
            System.out.println("Insufficient resources. Please refill.");
        }
    }

    public void prepareCoffee(Order order) {
        if (this.isOn && hasEnoughResources()) {

            useResources();
            Coffee coffee = order.getCoffee();
            Customer customer = order.getCustomer();
            coffee.prepare();

            try {
                int preparationTime = coffee.getPreparationTime();
                System.out.println(
                        "Preparing " + coffee.getName() + ". Please wait for " + preparationTime + " seconds...");
                Thread.sleep(preparationTime * 1000);
            } catch (InterruptedException e) {
                System.out.println("Coffee preparation interrupted.");
                Thread.currentThread().interrupt();
            }

            System.out.println(coffee.getName() + " is ready for " + customer.getName()
                    + " (Token #" + customer.getToken() + ")");

        } else {
            System.out.println("Cannot prepare coffee for Token #" + order.getCustomer().getToken()
                    + ". Check machine status or resources.");
        }
    }
}