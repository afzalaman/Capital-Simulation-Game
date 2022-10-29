package capitalygame;

import java.util.Objects;
/**
 *
 * @author aliafzal
 */
public class Property extends Field {
    
    protected Player owner;//who is the owner of the property//null if no owner
    protected boolean house;//if the property has a house built on it
    
    public Property(int cost,String name)
    {
        super(cost,name);
    }
    
    public boolean isOwned() {
        return Objects.nonNull(owner);
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
    
    public boolean hasHouse()
    {
        return house;
    }

    public void setHouse(boolean house) {
        this.house = house;
    }  
}
