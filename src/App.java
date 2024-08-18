public class App {
    private static final int MAX_ORDERS = 4;

    public static void main(String[] args) {
        BeanStorage beanStorage = new BeanStorage(100, 100);
        WaterStorage waterStorage = new WaterStorage(100, 100);
        MilkStorage milkStorage = new MilkStorage(100, 100);

        ResourceManager resourceManager = new ResourceManager(beanStorage, waterStorage, milkStorage);
        CoffeeMachine coffeeMachine = new CoffeeMachine(resourceManager);  

        CoffeeShop coffeeShop = new CoffeeShop(coffeeMachine, MAX_ORDERS);

        coffeeMachine.turnOn();

        InputHandler inputHandler = new InputHandler();
        OrderManager orderManager = new OrderManager(coffeeShop, MAX_ORDERS);

        while (true) {
            orderManager.manageOrders(inputHandler);

            System.out.println("All orders have been processed.");
            inputHandler.promptToAddMoreOrders();

            String userInput = inputHandler.getInput();

            if (!userInput.equalsIgnoreCase("y")) {
                break;
            }
        }

        coffeeMachine.turnOff();
        inputHandler.closeScanner();
    }
}
