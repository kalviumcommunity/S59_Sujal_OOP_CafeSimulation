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

class Espresso extends Coffee {
    public Espresso() {
        super("Espresso", 4);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Espresso...");
    }
}

class Latte extends Coffee {
    public Latte() {
        super("Latte", 5);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Latte...");
    }
}

class Cappuccino extends Coffee {
    public Cappuccino() {
        super("Cappuccino", 6);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Cappuccino...");
    }
}
