public abstract class Coffee {
    private String name;
    private int preparationTime;

     public String getName() {
         return name;
     }

     public int getPreparationTime() {
         return preparationTime;
     }

    public abstract void prepare();
}

class Espresso extends Coffee {

    @Override
    public void prepare() {
        System.out.println("Preparing Espresso...");
    }
}

class Latte extends Coffee {

    @Override
    public void prepare() {
        System.out.println("Preparing Latte...");
    }
}

class Cappuccino extends Coffee {

    @Override
    public void prepare() {
        System.out.println("Preparing Cappuccino...");
    }
}
