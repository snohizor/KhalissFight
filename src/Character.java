import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Character {
    public String name;
    public int hpmax;
    public int hp;
    public int init;

    public String displayCharacter(){
        return this.name + " - " + this.hp + "/" + this.hpmax;
    }

    public void checkLifeAndAttack(ArrayList<Character> list, ArrayList<Character> mobs){
        if(this.hp > 0 && getSumHp(mobs) > 0){
            Character ennemy;
            int i = 0;
            System.out.println(this.name + " attaque !\nQui attaquer ?");
            for (Character character : list){
                System.out.println(i + " - " + character.displayCharacter());
                i++;
            }
            int scan = Main.intScan(0, i);
            this.damages(list.get(scan));
            if (list.get(scan).getHp() == 0){
                System.out.println(list.get(scan).name + " est dead.\n");
                list.remove(list.get(scan));
            }
        }
    }

    public void damages(Character ennemy){
        if(this.hp > 0){
            System.out.println(this.name + " attaque " + ennemy.name + " !");
            int degats = Main.intScan(-1000, 1000);
            System.out.println("Vous avez saisi le nombre : " + degats);

            ennemy.setHp(ennemy.hp - degats);
            System.out.println(ennemy.name + " " + ennemy.hp + "/" + ennemy.hpmax + "\n");
            if(ennemy.hp < 1){
                ennemy.setHp(0);
            }
        }
    }

    private int getSumHp(ArrayList<Character> characters) {
        int sumHp = 0;
        for(Character mob : characters){
            sumHp = sumHp + mob.hp;
        }
        return sumHp;
    }

    public Character(String name, int hpmax, int hp) {
        this.name = name;
        this.hpmax = hpmax;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHpmax() {
        return hpmax;
    }

    public void setHpmax(int hpmax) {
        this.hpmax = hpmax;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
