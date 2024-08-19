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

    public void prepare() {
        System.out.println("Preparing " + name + "...");
        if (isDairy) {
            addMilk();
        }
    }

    private void addMilk() {
        System.out.println("Adding milk to " + name + "...");
    }
}

class Latte extends Coffee {
    public Latte() {
        super("Latte", 5, true);
    }
}

class Espresso extends Coffee {
    public Espresso() {
        super("Espresso", 4, false);
    }
}

class Cappuccino extends Coffee {
    public Cappuccino() {
        super("Cappuccino", 6, true);
    }
}
