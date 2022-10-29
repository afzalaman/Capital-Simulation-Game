package capitalygame;

/**
 *
 * @author aliafzal
 */
public abstract class Field {
    protected int cost;
    protected String name;


    public Field(int cost, String name) {
        this.cost = cost;
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
