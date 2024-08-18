public class WaterStorage extends Storage {

    public WaterStorage(int initialLevel, int maxLevel) {
        super(initialLevel, maxLevel);
    }

    @Override
    public void checkLevel() {
        System.out.println("Current water level: " + getLevel() + " units");
    }

    @Override
    public void refill() {
        super.refill();
        System.out.println("Water storage has been refilled.");
    }

    @Override
    public boolean use(int amount) {
        System.out.println("Using " + amount + " units of water.");
        return super.use(amount);
    }
}