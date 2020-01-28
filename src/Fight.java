import java.util.ArrayList;
import java.util.Scanner;

public class Fight {
    public Fight(ArrayList<Character> players, ArrayList<Character> mobs) {

        int sumHpMobs = getSumHp(mobs);
        System.out.println("Nombre d'HP total des mobs : " + sumHpMobs);

        ArrayList<Character> allCharactersList = new ArrayList<Character>();
        for(Character player : players){
            System.out.print("Jet d'initiative de " + player.name + " : ");
            player.init = Main.intScan(0,20);
            allCharactersList.add(player);
        }

        for(Character mob : mobs){
            System.out.print("Jet d'initiative de " + mob.name + " : ");
            mob.init = Main.intScan(0, 20);
            allCharactersList.add(mob);
        }

        //TRIER ORDRE D INITIATIVE
        ArrayList<Character> orderList = new ArrayList<Character>();
        int listsLength = 0;
        for(Character character : allCharactersList){
            listsLength++;
        }

        while(listsLength > 0){
            int temp = 0;
            Character bestInitChar = null;
            for(Character character : allCharactersList){
                if (character.init > temp){
                    temp = character.init;
                    bestInitChar = character;
                }

            }

            //System.out.println("le bestInitChar : " + bestInitChar.name);
            listsLength--;
            orderList.add(bestInitChar);
            allCharactersList.remove(bestInitChar);

        }

        System.out.println("Ordre d'initiative :");
        for(Character character : orderList){
            System.out.println(character.name + " : " + character.init);
        }

        System.out.println("--------------");
        System.out.println("LET THE FIGHT BEGIN");
        Main.getAllCharsInList(allCharactersList, players, mobs);
        System.out.println(getSumHp(mobs));

        while(getSumHp(mobs)>0){
            //FIGHT
            for (Character character : orderList){
                character.checkLifeAndAttack(allCharactersList, mobs);
                //removeDeadMobFromList(allCharactersList, orderList);
            }
            System.out.println(getSumHp(mobs));
        }
        System.out.println("Fight terminado");
    }

    private int getSumHp(ArrayList<Character> characters) {
        int sumHp = 0;
        for(Character mob : characters){
            sumHp = sumHp + mob.hp;
        }
        return sumHp;
    }

    public void removeDeadMobFromList(ArrayList<Character> fullList, ArrayList<Character> orderList){
        for(Character mob : fullList){
            if (mob.hp <= 0) {
                mob.setHp(0);
                orderList.remove(mob);
                System.out.println(mob.name + " est dead.");
            }
        }
    }

}
