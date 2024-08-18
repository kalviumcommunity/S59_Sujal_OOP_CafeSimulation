public abstract class Coffee {
    private String name;
    private int preparationTime;

    public Coffee(String name, int preparationTime) {
        this.name = name;
        this.preparationTime = preparationTime;
    }

    public String getName() {
        return name;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public abstract void prepare();
}

abstract class DairyCoffee extends Coffee {
    public DairyCoffee(String name, int preparationTime) {
        super(name, preparationTime);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + getName() + "...");
        addMilk();
    }

    public void addMilk() {
        System.out.println("Adding milk to " + getName() + "...");
    }
}

abstract class NonDairyCoffee extends Coffee {
    public NonDairyCoffee(String name, int preparationTime) {
        super(name, preparationTime);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + getName() + "...");
    }
}

class Latte extends DairyCoffee {
    public Latte() {
        super("Latte", 5);
    }
}

class Espresso extends NonDairyCoffee {
    public Espresso() {
        super("Espresso", 4);
    }
}

class Cappuccino extends DairyCoffee {
    public Cappuccino() {
        super("Cappuccino", 6);
    }
}
