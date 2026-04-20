import java.util.List;
import java.util.ArrayList;

/**
 * Creates two armies of Creatures and sets them to battle one another.
 * 
 * The nature of the battle is army1[0] battles army2[0] until one, the other
 * or both are knocked out. The creature continues battling until HP < 0.
 * The battle continues until army1, army2 or both have no creatures left standing.
 *
 * @author Crosbie
 * @version 2026-04-20
 */
public class Battle
{
    // instance variables 
    private List<Creature> army1, army2;

    /**
     * Constructor for objects of class Battle
     */
    public Battle()
    {
        army1 = new ArrayList<Creature>();
        army2 = new ArrayList<Creature>();
        
        CreateArmy1(100);
        CreateArmy2(35);

        System.out.println("Armies created and at the ready");
    }
    
    /**
     * Start Battle between army 1 and army 2
     *
     */
    public void EngageInBattle()
    {
        System.out.println("\n\n\n== War Trumpets Sound ============");
        
        Creature goodFighter;
        Creature evilFighter;
        
        goodFighter = army1.removeFirst();  //get the first fighter and remove from list
        evilFighter = army2.removeFirst();
               
        // while there are still creatures in each army 
        // and one of the current fighters is still standing
        while ((army1.size() > 0) && (army2.size() > 0))
        {
            do {
            System.out.println("Good:"+goodFighter.getHealth()+"\t Evil:"+evilFighter.getHealth());
            evilFighter.takeDamage(goodFighter.attack());
            goodFighter.takeDamage(evilFighter.attack());
            } while (goodFighter.isAlive() && evilFighter.isAlive());
            
            System.out.println("===Fight over===");
            if (goodFighter.isKnockedOut()){
                System.out.println("Good Fighter has fallen. NEXT UP!");
                goodFighter = army1.removeFirst();
            }
            
            if (evilFighter.isKnockedOut()){
                System.out.println("Evil Fighter has fallen. NEXT UP!");
                evilFighter = army2.removeFirst();
            }   
            System.out.println();
        }
        
        System.out.println("THE FINAL CONTEST!!!");
        do {
            System.out.println("Good:"+goodFighter.getHealth()+"\t Evil:"+evilFighter.getHealth());
            evilFighter.takeDamage(goodFighter.attack());
            goodFighter.takeDamage(evilFighter.attack());
            } while (goodFighter.isAlive() && evilFighter.isAlive());
        
        if (army1.size() > 0) {
            System.out.println("Good has prevailed in middle earth.");
        } else if (army2.size() > 0)  {
            System.out.println("Evil has covered middle earth.");
        } else { //total destruction
            System.out.println("The only winner is death...");
        }
        }
   

        

    
        /**
     * Start Battle between army 1 and army 2
     *
     */
    public void ShowStartingLineups()
    {
        System.out.println("=== ARMY 1 ===");
        for(Creature c : army1)
        {
           System.out.println("\t"+c.getClass().getName()+
                              "\t[STR:"+c.getStrength()+
                              " / hp:"+c.getHealth()+"]");
        }
        System.out.println("=== ARMY 2 ===");
        for(Creature c : army2)
        {
           System.out.println("\t"+c.getClass().getName()+
                              "\t[STR:"+c.getStrength()+
                              " / hp:"+c.getHealth()+"]");
        }
    }
    
    
    //=========================================
    /**
     * Create Army of good creatures as understood in Lord of the Rings
     *
     * @param size How many creatures in the army
     */
    private void CreateArmy1(int size)
    {
        for(int i=0; i<size; i++)
        {
            int roll = Randomizer.nextInt(20);
            
            if (roll <= 20)  //change this value
            { //create Human
                army1.add(new Human());
            
            } else { //add other if tests to allow for other good creatures to be created
                
               
            }
        }
        
    }
    

    /**
     * Create Army of evil creatures as understood in Lord of the Rings
     *
     * @param size How many creatures in the army
     */
        private void CreateArmy2(int size)
    {
        for(int i=0; i<size; i++)
        {
            int roll = Randomizer.nextInt(20);
            
            if (roll <= 20)
            { //create Human
                army2.add(new Human());
            
            } else {
                //further if tests to allow for other evil creatures to be greated
            }
        }
    }
    
    
    /* NOTES for future development
     * 
     * make create army a single method and 
     * Pass in a list of classes that can make up the army  
     * 
     */
}