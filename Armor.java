public class Armor {
    private int id;
    private String name;
    private int block;
    private int cost;

    public Armor(int id, String name, int block, int cost) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "\nArmor"
                + "\nName: " + this.getName()
                + "\nDefense: " + this.getBlock();
    }
}
