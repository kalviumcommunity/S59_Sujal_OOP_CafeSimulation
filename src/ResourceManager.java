public class ResourceManager {
    private WaterStorage waterStorage;
    private BeanStorage beanStorage;
    private MilkStorage milkStorage;

    public ResourceManager(BeanStorage beanStorage, WaterStorage waterStorage, MilkStorage milkStorage) {
        this.waterStorage = waterStorage;
        this.beanStorage = beanStorage;
        this.milkStorage = milkStorage;
    }

    public boolean checkAndUseResources(Coffee coffee) {
        int waterRequired = 5;  
        int beansRequired = 5; 
        int milkRequired = coffee.isDairy() ? 3 : 0;  

        boolean hasEnoughResources = waterStorage.use(waterRequired) && beanStorage.use(beansRequired);
        if (coffee.isDairy()) {
            hasEnoughResources = hasEnoughResources && milkStorage.use(milkRequired);
        }

        return hasEnoughResources;
    }

    public void refillAll() {
        waterStorage.refill();
        beanStorage.refill();
        milkStorage.refill();
    }

    public void checkAllLevels() {
        waterStorage.checkLevel();
        beanStorage.checkLevel();
        milkStorage.checkLevel();
    }
}
