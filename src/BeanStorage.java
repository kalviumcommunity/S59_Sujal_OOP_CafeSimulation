public class BeanStorage extends Storage {

    @Override
    public void checkLevel() {
        System.out.println("Current bean level: " + getLevel() + " units");
    }

    @Override
    public void refill() {
        super.refill();
        System.out.println("Bean storage has been refilled.");
    }

    @Override
    public boolean use(int amount) {
        System.out.println("Using " + amount + " units of beans.");
        return super.use(amount);
    }
}