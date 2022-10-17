import java.util.Random;
public class Pokemon {
    private String name;
    private int hitPoints;
    private String move;
    private int movePower;
    private int attackSpeed;

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
            Random rand = new Random();
            boo = rand.nextBoolean();
        }
        else {
            boo = false;
        }
        return boo;
    }

    public String getName() {
        return name;
    }

    public String getMove(){
        return move;
    }

    public int getPower(){
        return movePower;
    }

    public int getAttackSpeed(){
        return attackSpeed;
    }

    public void subtractHitPoints(int number) {
        hitPoints =- number;
    }

    public int checkHitPoints() {
        return hitPoints;
    }
}
