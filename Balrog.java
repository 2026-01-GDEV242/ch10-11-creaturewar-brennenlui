

/**
 * The Balrog class implements a Tolkien style Demoni nightmare with the following additions
 * Implements a maximum/minimum strength for the creature type [40/20]
 * Implements a maximum/minimum hitpoint total for the creature type [100/25]
 * 
 * @author Bill Crosbie
 * @version 2025-04 v1.1
 */
public class Balrog extends Demon
{
    // instance variables - replace the example below with your own
    private static final int MAX_BALROG_HP = 200;
    private static final int MIN_BALROG_HP = 85;
    private static final int MAX_BALROG_STR = 100;
    private static final int MIN_BALROG_STR = 50;

    /**
     * Constructor for objects of class Balrog -
     * Note that the calling class does not need to know anything about the 
     * requirements of Balrog minimum and maximum values
     * 
     * The instantiating class asks for a Balrog and the human class is responsible for
     * return a Balrog object with values in the appropriate range
     * 
     */
    public Balrog()
    {
        // note how the class uses the static randomizer class to
        // generate the values. This localizes the need to know 
        // max and min values to this class only
        // max-min is range of values
        // range + min ensures that the values don't start at one.
        super(
            Randomizer.nextInt(MAX_BALROG_STR-MIN_BALROG_STR)+MIN_BALROG_STR,
            Randomizer.nextInt(MAX_BALROG_HP-MIN_BALROG_HP)+MIN_BALROG_HP        
        );
          
    }
    
    
    /**
     * Balrog attack twice. Duck and cover...
     * @return damage from two fisted attack
     */
    public int attack(){
        int tempDamage;
        
        tempDamage = super.attack(); //left jab
        tempDamage = tempDamage + super.attack(); //right uppercut
        
        return tempDamage;
    }
    // takeDamage(int) - not overridden, because Humans take all damage assigned to them

}
