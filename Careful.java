package capitalygame;

/**
 *
 * @author aliafzal
 */
public class Careful extends Player {
    
    public Careful(String name)
    {
        super(name);
    }
    @Override
    public void stepOnField(Field a)
    {
    if(a instanceof Property property)
    {
        if (searchProperty(property))
        {
            if(!property.house)
            {
                if(getMoney()/2 >= 4000)
                {
                    addMoney(-4000);
                    property.setHouse(true);
                }
            }
        }
        else if (property.isOwned() && property.hasHouse())
        {
            if (canSpent(2000))
            {
                addMoney(-2000);
                    property.getOwner().addMoney(2000);
            }
            else
            {
                property.getOwner().addMoney(getMoney());
                setAlive(false);
                deleteAllProperty();
            }
        }
        else if (property.isOwned())
        {
            if (canSpent(500))
            {
                addMoney(-500);
                    property.getOwner().addMoney(500);
            }
            else
            {
                property.getOwner().addMoney(getMoney());
                setAlive(false);
                deleteAllProperty();
            }
        }
        else
        {
            if(getMoney()/2 >= 1000)
            {
                addMoney(-1000);
                property.setOwner(this);
                this.addOwns(property);
            }
        }
    }
    else if (a instanceof Service)
    {
        if(canSpent(a.getCost()))
        {
            addMoney(-1*(a.getCost()));
        }
        else
        {
            setAlive(false);
            deleteAllProperty();
        }
    }
    else
    {
        addMoney(a.getCost());
    }
    }
}