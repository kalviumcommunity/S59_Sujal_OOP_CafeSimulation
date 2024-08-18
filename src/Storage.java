public class Storage {
    private int level;  
    private final int maxLevel; 

    public Storage() {
        this.level = 0;  
        this.maxLevel = 100;  
        System.out.println("No-argument constructor called: Default storage created with max level of " + maxLevel + " units.");
    }

    public Storage(int initialLevel, int maxLevel) {
        this.level = initialLevel;
        this.maxLevel = maxLevel;
    }

    public void checkLevel() {
        System.out.println("Current level: " + level + " units");
    }

    public void refill() {
        this.level = maxLevel;
        System.out.println("Storage has been refilled to " + maxLevel + " units.");
    }

    public boolean use(int amount) {
        if (level >= amount) {
            level -= amount;
            return true;
        } else {
            System.out.println("Not enough resources. Please refill.");
            return false;
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}