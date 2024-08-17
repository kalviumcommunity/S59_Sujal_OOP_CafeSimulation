public class CoffeeMachine {
    private boolean isOn;

    String blueText = "\u001B[34m";
    String greenText = "\u001B[32m";
    String redText = "\u001B[31m";
    String resetText = "\u001B[0m";

    public CoffeeMachine() {
        this.isOn = false;
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
        return Storage.waterLevel >= 5 && Storage.beanLevel >= 5;
    }

    public boolean useResources() {
        if (Storage.waterLevel >= 5 && Storage.beanLevel >= 5) {
            Storage.waterLevel -= 5;
            Storage.beanLevel -= 5;
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
