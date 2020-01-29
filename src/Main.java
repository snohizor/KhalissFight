import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, IllegalAccessException {


        new Window();
        ArrayList<Character> loadedChars = new ArrayList<Character>();
        ArrayList<Character> allCharacters = new ArrayList<Character>();
        ArrayList<Character> players = new ArrayList<Character>();
        ArrayList<Character> mobs = new ArrayList<Character>();

//        Character player1 = new Character("Beverly", 10, 10);
//        Character player2 = new Character("Neymar Miçil", 8, 8);
//
//        players.add(player1);
//        players.add(player2);
//
//        Character mob1 = new Character("Khélin Alpha", 15, 15);
//        Character mob2 = new Character("Gnoll", 7, 7);
//
//        mobs.add(mob1);
//        mobs.add(mob2);


        loadTxt(loadedChars);
        allCharacters = loadedChars;
        fillOneListFromTwoLists(allCharacters, players, mobs);
        fromOneListToTwoLists(allCharacters, players, mobs);

        log("KHALISS FIGHT");
        space();

        System.out.println(loadedChars.get(0).name);

        displayList(players, mobs);

        extractTxt(allCharacters);
        //new Fight(players, mobs);
    }

    private static void loadChars(ArrayList<Character> loadedChars, ArrayList<Character> allCharacters) {
        allCharacters = loadedChars;
    }

    public static void loadTxt(ArrayList<Character> list) throws IOException {
        loadTableToInstance(readFromFileToTable(), list);
    }

    public static void extractTxt(ArrayList<Character> list) throws FileNotFoundException, UnsupportedEncodingException, IllegalAccessException {
        PrintWriter writer = new PrintWriter("C:\\Users\\snohi\\csv\\extract.txt", "UTF-8");
        writer.println(createStringForSave(list));
        writer.close();
    }

    public static String createStringForSave(ArrayList<Character> list) throws IllegalAccessException {
        String stringForSave = "";
        for (Character character : list) {
            stringForSave = stringForSave + character.createCharString();
        }
        return stringForSave;
    }

    public static String[] readFromFileToTable() throws IOException {
        File file = new File("C:\\Users\\snohi\\csv\\load.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String[] loadingArray;
        String fullStr = "";
        String lineStr;
        int i = 1;
        while ((lineStr = br.readLine()) != null){
            System.out.println(lineStr);
            fullStr = fullStr + lineStr;
        }

        //Découpage of fullStr
//        fullStr = br.readLine();
//        log(fullStr);
        String delimiter = " ";
        loadingArray = fullStr.split(delimiter);

        return loadingArray;
    }

    public static void loadTableToInstance(String[] array, ArrayList<Character> list) {
        /* print substrings */
        Field[] fields = Character.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++)
            System.out.println(array[i]);//une stat a chaque coup

        //Creation of the characters from the file
        //Get the String, transform to int if needed, and save it temporaly
        int nbOfChars = 0;
        nbOfChars = (array.length / fields.length);

        boolean b = true;
        for (int i = 0; i < nbOfChars; i++) {
            log("ici : ");System.out.print(array[(fields.length*i) + 0]);

            if (array[(fields.length*i) + 0].equals("false")){
                b = false;
                log("it s not human");
            }else if(array[(fields.length*i) + 0].equals("true")){
                b = true;
                log("it s human");
            }else{
                log("ntm rito");
            }

            boolean isHuman = b;
            if (b)
                log("b is true");
            if (!b)
                log("b is false");
            String name = array[(fields.length*i) + 1];
            String _class = array[(fields.length*i) + 2];
            String race = array[(fields.length*i) + 3];
            log(race);
            String alignment = array[(fields.length*i) + 4];
            int init = Integer.parseInt(array[(fields.length*i) + 5]);
            int xp = Integer.parseInt(array[(fields.length*i) + 6]);
            int level = Integer.parseInt(array[(fields.length*i) + 7]);
            int hpMax = Integer.parseInt(array[(fields.length*i) + 8]);
            int hp = Integer.parseInt(array[(fields.length*i) + 9]);
            int strength = Integer.parseInt(array[(fields.length*i) + 10]);
            int dexterity = Integer.parseInt(array[(fields.length*i) + 11]);
            int constitution = Integer.parseInt(array[(fields.length*i) + 12]);
            int intelligence = Integer.parseInt(array[(fields.length*i) + 13]);
            int wisdom = Integer.parseInt(array[(fields.length*i) + 14]);
            int charisma = Integer.parseInt(array[(fields.length*i) + 15]);
            //nice

            list.add(new Character(isHuman, name, _class, race, alignment, init, xp, level, hpMax, hp, strength, dexterity, constitution, intelligence, wisdom, charisma));
            log((name + " loaded."));
        }
    }

    public static void displayList(ArrayList<Character> players, ArrayList<Character> mobs) {
        for (Character character : players) {
            log(character.displayCharacter());
        }
        space();
        for (Character character : mobs) {
            log(character.displayCharacter());
        }
        space();
    }

    public static void fillOneListFromTwoLists
            (ArrayList<Character> list, ArrayList<Character> players, ArrayList<Character> mobs) {
        for (Character character : players) {
            list.add(character);
        }

        for (Character character : mobs) {
            list.add(character);
        }
    }

    public static void fromOneListToTwoLists
            (ArrayList<Character> list, ArrayList<Character> players, ArrayList<Character> mobs) {
        for (Character character : list){
            if(character.isHuman)
                players.add(character);
            else
                mobs.add(character);
        }
    }

    public static void log(String message) {
        System.out.println(message);
    }

    public static void space() {
        System.out.println();
    }

    public static int intScan(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        boolean error = true;
        int number;
        do {
            System.out.print("int scan ?");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                if (input.contains("@") || input.contains("#")) {
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