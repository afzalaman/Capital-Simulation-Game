package capitalygame;

import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author aliafzal
 */
public class CapitalyGame {
    
    private final ArrayList<Field> fields;
    private final ArrayList<Player> players;
    private final ArrayList<Integer> diceList;
    
    public CapitalyGame()
    {
        fields = new ArrayList<>();
        players = new ArrayList<>();
        diceList = new ArrayList<>();
    }
        
    public void read(String playerFile,String diceFile) throws FileNotFoundException, InvalidInputException 
    {
        File file1 = new File(playerFile);
        Scanner sc = new Scanner(file1);
        File file2 = new File(diceFile);
        Scanner scd = new Scanner(file2);

        int fieldSize=sc.nextInt();
        for (int i=0;i<fieldSize;i++)
        {
            String temp = sc.next();
            switch(temp)
            {
                case ("Property") -> fields.add(new Property(1000,"Property"));
                case ("Service") -> {
                    int t=sc.nextInt();
                    fields.add(new Service(t,"Service"));
                    }
                case ("LuckyField") -> {
                    int s=sc.nextInt();
                    fields.add(new LuckyField(s,"LuckyField"));
                    }
                default -> throw new InvalidInputException();    
            }
        }
        int playerSize=sc.nextInt();
        for (int i=0;i<playerSize;i++)
        {
            String name =sc.next();
            String strategy = sc.next();
            switch(strategy)
            {
                case ("Greedy") -> players.add(new Greedy(name));
                case ("Tactical") -> players.add(new Tactical(name));
                case ("Careful") -> players.add(new Careful(name));
                default -> throw new InvalidInputException();     
            }  
        }
        while(scd.hasNext())
        {
            diceList.add(scd.nextInt());
        }
        Collections.shuffle(diceList); // to shuffle the dice nums
    }
        
    public void simulate()
    {
        int counter=0;
        while(players.size() > 1)
        {
            for (int i = 0;i<players.size();i++)
            {
                int dice = diceList.get(counter);
                players.get(i).stepOnField(fields.get(((dice-1)+players.get(i).getCurrentPos()) % fields.size()));
                players.get(i).addCurrentPos(((dice-1)) % fields.size());
          
                if(!players.get(i).isAlive())
                {
                    players.remove(i);
                }
                counter = (counter + 1) % diceList.size();
            }
        System.out.println(players);// we can print the data after each round
        }
        System.out.println("The Winner is : "+players.get(0));
    }       
}
