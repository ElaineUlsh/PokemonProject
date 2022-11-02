//****************************************************************
//          This class basically creates a Pokemon as an
//          object with different methods. This way, the
//          main method is cleaner and easier to read, and
//          also, the way that the Pokemon works is easier
//          to figure out.
//
//          By using accessor and mutator methods here,
//          which are easy to create, the PokemonBattle class
//          has complexity. Everything is more simple this
//          way.
//****************************************************************

//imports the Random method for use
import java.util.*;
public class Pokemon {
    //instance variables
    private String name;
    private int hitPoints;
    private String move;
    private int movePower;
    private int attackSpeed;

    //constructor
    public Pokemon(String theName, int points, String moveName, int power, int speed) {
        name = theName;
        hitPoints = points;
        move = moveName;
        movePower = power;
        attackSpeed = speed;
    }

    //basically, it takes two pok.'s speeds and compares them to see which one
    //is higher. If 'this' one is, then it returns true, otherwise false.
    public boolean goesFirst(Pokemon other){
        boolean boo;
        if (this.attackSpeed > other.getAttackSpeed()){
            boo = true;
        }
        else if (this.attackSpeed == other.getAttackSpeed()){
            //sets up the Random method for use
            Random rand = new Random();
            //chooses randomly from true or false
            boo = rand.nextBoolean();
        }
        else {
            boo = false;
        }
        return boo;
    }

    //accessor method for variable name
    public String getName() {
        return name;
    }

    //accessor method for variable move
    public String getMove(){
        return move;
    }

    //accessor method for variable power
    public int getPower(){
        return movePower;
    }

    //accessor method for variable attackSpeed
    public int getAttackSpeed(){
        return attackSpeed;
    }

    //subtracts number from hitPoints and sets hitPoints to that number
    public void subtractHitPoints(int number) {
        hitPoints =- number;
    }

    //accessor method for variable hitPoints
    //is the same as "getHitPoints", but sounds way cooler.
    public int checkHitPoints() {
        return hitPoints;
    }

    //displayPokemonStats() method
    //returns a pokemon's stats as a formatted String
    public String displayPokemonStats() {
        //String display = String.format("Name: %d%nHit Points: %d%nMove: %d%nPower: %d%nAttack Speed: %d", name, hitPoints, move, movePower, attackSpeed);
        //return "Stats:\n" + display;
        return String.format("Name: %s%nHit Points: %d%nMove: %s%nPower: %d%nAttack Speed: %d", name, hitPoints, move, movePower, attackSpeed);
    }
}
