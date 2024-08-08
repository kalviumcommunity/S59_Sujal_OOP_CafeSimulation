public class CoffeeMachine {
    private boolean isOn;
    private int waterLevel;
    private int beanLevel;

    String blueText = "\u001B[34m";
    String greenText = "\u001B[32m";
    String redText = "\u001B[31m";
    String resetText = "\u001B[0m";

    public CoffeeMachine() {
        this.isOn = false;
        this.waterLevel = 100;
        this.beanLevel = 100;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(greenText + "Coffee machine is now ON." + resetText);
    }

    public void turnOff() {
        isOn = false;
        System.out.println(redText + "Coffee machine is now OFF." + resetText);
    }

    public boolean isMachineOn() {
        return isOn;
    }

    public boolean hasEnoughResources() {
        return waterLevel >= 5 && beanLevel >= 5;
    }

    public boolean useResources() {
        if (waterLevel >= 5 && beanLevel >= 5) {
            this.waterLevel -= 5;
            this.beanLevel -= 5;
            return true;
        } else {
            System.out.println(redText + "Not enough resources to prepare coffee. Please refill water and beans."
                    + resetText);
            return false;
        }
    }

    public void prepareCoffee(Order order) {
        if (this.isOn && hasEnoughResources()) {
            if (useResources()) {
                Coffee coffee = order.getCoffee();
                Customer customer = order.getCustomer();

                coffee.prepare();

                try {
                    int preparationTime = coffee.getPreparationTime();

                    System.out.println("Please wait for " + preparationTime + " seconds...\n");
                    Thread.sleep(preparationTime * 1000);
                } catch (InterruptedException e) {
                    System.out.println("Coffee preparation interrupted.\n");
                    Thread.currentThread().interrupt();
                }

                System.out.println(blueText + coffee.getName() + " is ready for " + customer.getName()
                        + " (Token #" + customer.getToken() + ")\n" + resetText);
            }
        } else {
            System.out.println("Cannot prepare coffee for Token #" + order.getCustomer().getToken()
                    + ". Check machine status or resources.\n");
        }
    }
}
