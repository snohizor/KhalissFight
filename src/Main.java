import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       new Window();

        ArrayList<Character> allCharacters = new ArrayList<Character>();
        ArrayList<Character> players = new ArrayList<Character>();
        ArrayList<Character> mobs = new ArrayList<Character>();

        Character player1 = new Character("Beverly", 10, 10);
        Character player2 = new Character("Neymar Miçil", 8, 8);

        players.add(player1);
        players.add(player2);

        Character mob1 = new Character("Khélin Alpha", 15, 15);
        Character mob2 = new Character("Gnoll", 7, 7);

        mobs.add(mob1);
        mobs.add(mob2);

        getAllCharsInList(allCharacters, players, mobs);

        log("KHALISS FIGHT");
        space();

        displayList(players, mobs);

        new Fight(players, mobs);
    }

    public static void displayList(ArrayList<Character> players, ArrayList<Character> mobs){
        for(Character character : players){
            log(character.displayCharacter());
        }
        space();
        for(Character character : mobs){
            log(character.displayCharacter());
        }
        space();
    }

    public static void getAllCharsInList(ArrayList<Character> list, ArrayList<Character> players, ArrayList<Character> mobs){
        for(Character character : players){
            list.add(character);
        }

        for (Character character : mobs){
            list.add(character);
        }
    }

    public static void log(String message){
        System.out.println(message);
    }

    public static void space(){
        System.out.println();
    }

    public static int intScan(int min, int max){
        Scanner scanner = new Scanner(System.in);
        boolean error = true;
        int number;
        do {
            System.out.print("int scan ?");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                if(input.contains("@") || input.contains("#")){
                    System.out.print("lol force pas non plus");
                }
                System.out.print("int scan ?");
            }
            number = scanner.nextInt();
            if (number >= min && number <= max)
                error = false;
        } while (error == true);
        return number;
    }

}