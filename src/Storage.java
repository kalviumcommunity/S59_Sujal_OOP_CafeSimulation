public class Storage {
    private int level;  
    private final int maxLevel;  
    private final String resourceType; 

    public Storage(String resourceType, int maxLevel) {
        this.level = 0;  
        this.maxLevel = maxLevel;  
        this.resourceType = resourceType;
        System.out.println("No-argument constructor called: Default " + resourceType + " storage created with max level of " + maxLevel + " units.");
    }

    public Storage(int initialLevel, int maxLevel, String resourceType) {
        if (initialLevel > maxLevel) {
            throw new IllegalArgumentException("Initial level cannot exceed max level.");
        }
        this.level = initialLevel;
        this.maxLevel = maxLevel;
        this.resourceType = resourceType;
    }

    public void checkLevel() {
        System.out.println("Current " + resourceType + " level: " + level + " units");
    }

    public void refill() {
        this.level = maxLevel;
        System.out.println(resourceType + " storage has been refilled to " + maxLevel + " units.");
    }

    public boolean use(int amount) {
        System.out.println("Using " + amount + " units of " + resourceType + ".");
        if (amount < 0) {
            throw new IllegalArgumentException("Usage amount must be positive.");
        }
        if (level >= amount) {
            level -= amount;
            return true;
        } else {
            System.out.println("Not enough " + resourceType + ". Please refill.");
            return false;
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level > maxLevel) {
            throw new IllegalArgumentException("Level cannot exceed max level.");
        }
        this.level = level;
    }

    public int getMaxLevel() {
        return maxLevel;
    }
}

class BeanStorage extends Storage {

    public BeanStorage(int initialLevel, int maxLevel) {
        super(initialLevel, maxLevel, "bean");
    }
}

class WaterStorage extends Storage {

    public WaterStorage(int initialLevel, int maxLevel) {
        super(initialLevel, maxLevel, "water");
    }
}

class MilkStorage extends Storage {

    public MilkStorage(int initialLevel, int maxLevel) {
        super(initialLevel, maxLevel, "milk");
    }
}
