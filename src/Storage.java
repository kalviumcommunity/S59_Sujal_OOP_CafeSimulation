public class Storage {
    public static int waterLevel = 100;
    public static int beanLevel = 100;

    public static void checkResources() {
        System.out.println("Water Level: " + waterLevel + " units");
        System.out.println("Bean Level: " + beanLevel + " units");
    }

    public static void refillResources() {
        waterLevel = 100;
        beanLevel = 100;
        System.out.println("Resources have been refilled.");
    }

    public static boolean useResources(int waterRequired, int beansRequired) {
        if (waterLevel >= waterRequired && beanLevel >= beansRequired) {
            waterLevel -= waterRequired;
            beanLevel -= beansRequired;
            return true;
        } else {
            System.out.println("Not enough resources to prepare coffee. Please refill water and beans.");
            return false;
        }
    }
}
