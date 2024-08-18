public class MilkStorage extends Storage {

    public MilkStorage(int initialLevel, int maxLevel) {
        super(initialLevel, maxLevel);
    }

    @Override
    public void checkLevel() {
        System.out.println("Current milk level: " + getLevel() + " units");
    }

    @Override
    public void refill() {
        super.refill();
        System.out.println("Milk storage has been refilled.");
    }

    @Override
    public boolean use(int amount) {
        System.out.println("Using " + amount + " units of milk.");
        return super.use(amount);
    }
}
