public abstract class Coffee {
    private String name;
    private int preparationTime;
    private boolean isDairy;

    public Coffee(String name, int preparationTime, boolean isDairy) {
        this.name = name;
        this.preparationTime = preparationTime;
        this.isDairy = isDairy;
    }

    public String getName() {
        return name;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public boolean isDairy() {
        return isDairy;
    }

    protected void addMilk() {
        if (isDairy) {
            System.out.println("Adding milk to " + name + "...");
        }
    }

    protected abstract void brew();
}

class Latte extends Coffee {
    public Latte() {
        super("Latte", 5, true);
    }

    @Override
    protected void brew() {
        System.out.println("Brewing espresso and steaming milk for " + getName() + "...");
        addMilk();
    }
}

class Espresso extends Coffee {
    public Espresso() {
        super("Espresso", 4, false);
    }

    @Override
    protected void brew() {
        System.out.println("Brewing a strong shot of " + getName() + "...");
    }
}

class Cappuccino extends Coffee {
    public Cappuccino() {
        super("Cappuccino", 6, true);
    }

    @Override
    protected void brew() {
        System.out.println("Brewing espresso and frothing milk for " + getName() + "...");
        addMilk();
    }
}
