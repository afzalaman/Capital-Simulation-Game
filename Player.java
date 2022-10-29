package capitalygame;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author aliafzal
 */
public abstract class Player {
    
    protected String name;
    protected int money;
    protected List<Property> owns;
    protected int currentPos;
    protected boolean alive;

    public Player(String name) {
        this.name = name;
        this.money = 10000;
        owns = new ArrayList<>();
        this.currentPos =0;
        this.alive = true;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

//Input:    int money - the amount of money we need to add
//Activity: adds the particular amount of money to the Player
    public void addMoney(int money) {
        this.money += money;
    }

    public List<Property> getOwns() {
        return owns;
    }
    
//Input:    Property y - Property to be added
//Activity: adds a particular property to the owned Properties
    public void addOwns(Property y)
    {
        owns.add(y);
    }
    
//Activity: delete all the properties owned by the Player   
    public void deleteAllProperty()
    {
        for (Property y : owns)
        {
            y.setOwner(null);
            y.setHouse(false);
        }
        owns.clear();
    }
    public int getCurrentPos() {
        return currentPos;
    }

//Input:    int currentPos - the number of increment (depends on the dice number)
//Activity: increment the curent position of the Player on the Board
    public void addCurrentPos(int pos) {
        this.currentPos += pos;
    }
    
//Input:    int cost - the cost which the player has to pay
//Output:   boolean - returns true if the player has enoungh money to spend
//Activity: checks if the player has enough money to pay
    public boolean canSpent(int cost) {
        return money > cost;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean isAlive) {
        this.alive = isAlive;
    }
    
//Input:    Property a - Property to be searched
//Output:   boolean - returns true if the player owns the searched Property
//Activity: checks if the player owns the searched Property
    public boolean searchProperty(Property a)
    {
        for (Property x : owns)
        {
            if (a.equals(x))
            {
                return true;
            }
        }
        return false;
    }

//Task:     abstract meathod which will be implemeted in the concrete classes
//Input:    Field a - the type of field on which the player is stepping
//Activity: Demonstrate what will happen if the player steps on a particular type of field
    public abstract void stepOnField(Field a);
    
    @Override
    public String toString() {
         int len = (int)owns.stream().filter(x->x.hasHouse()).count();
        
        return "Player{" + "name=" + name + ", money=" + money +", Properties owned=" + owns.size()+", Houses built=" + len+'}';
    }
    
    
    
}
