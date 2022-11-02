import java.util.Scanner;

public class PokemonSelection {
    Scanner input = new Scanner(System.in);

    //instance variables


    //constructor
    public PokemonSelection() {

    }

    //createPokemon() method
    //uses Scanner to ask user to select values needed to create a Pokemon
    //calls pokemon constructor using the above values as parameters to create an instance of pokemon class
    //returns pokemon object
    public Pokemon createPokemon() {
        //name of pokemon
        System.out.print("What is the name of your pokemon?");
        input.nextLine(); //throw-away so that it takes the input for nextLine()
        String name = input.nextLine();
        //hit points
        System.out.println("How many hit points does your pokemon have?");
        int hp = input.nextInt();
        //move
        System.out.println("What move does your pokemon perform?");
        input.nextLine(); //throw-away so that it takes the input for nextLine()
        String move = input.nextLine();
        //power of move
        System.out.println("What is the power of that move?");
        int power = input.nextInt();
        //attack speed of pokemon
        System.out.println("What is the attack speed of your pokemon?");
        int speed = input.nextInt();
        Pokemon test = new Pokemon(name, hp, move, power, speed);
        return test;
    }

    //assignPokemon() method
    //for each player, it prints "Player x: Select a Pokemon and enter its stats"
    //it then calls the createPokemon() method and assigns the returned instance
    //of the Pokemon class to a variable
    //it then prints "Player x Pokemon" and then calls the displayPokemonstats()
    //method for that Pokemon instance and then prints the returned String.
    //then it closes the Scanner
    public Pokemon assignPokemon(int playNum) {
        //call this for each player
        System.out.println("Player " + playNum + ": select a Pokemon and enter its stats");
        Pokemon test = createPokemon();
        System.out.println("Player " + playNum + " x " + test.getName());
        String display = test.displayPokemonStats();
        System.out.println(display);

        //System.exit(0);

        return test;
    }
}
