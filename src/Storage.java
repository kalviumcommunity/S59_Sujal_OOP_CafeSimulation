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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}