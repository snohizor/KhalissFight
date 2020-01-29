import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Character {

    public boolean isHuman;
    public String name;
    public String _class;
    public String race;
    public String alignment;
    public int init;
    public int xp;
    public int level;
    public int hpMax;
    public int hp;
    public int strengh;
    public int dexterity;
    public int constitution;
    public int intelligence;
    public int wisdom;
    public int charisma;

    public Character(boolean isHuman, String name, String _class, String race, String alignment, int init, int xp, int level, int hpMax, int hp, int strengh, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
    }

    public String displayCharacter() {
        if (this.isHuman)
            return "HERO " + this.name + " - " + this.hp + "/" + this.hpMax;
        else if (!this.isHuman)
            return this.name + " - " + this.hp + "/" + this.hpMax;
        else
            return "coucou c le bug";
    }

    public String displayCharacterStats(){
        String str = name + "\n";
        return str;
    }

    public void checkLifeAndAttack(ArrayList<Character> list, ArrayList<Character> mobs) {
        if (this.hp > 0 && getSumHp(mobs) > 0) {
            Character ennemy;
            int i = 0;
            System.out.println(this.name + " attaque !\nQui attaquer ?");
            for (Character character : list) {
                System.out.println(i + " - " + character.displayCharacter());
                i++;
            }
            int scan = Main.intScan(0, i);
            this.damages(list.get(scan));
            if (list.get(scan).getHp() == 0) {
                System.out.println(list.get(scan).name + " est dead.\n");
                list.remove(list.get(scan));
            }
        }
    }

    public void damages(Character ennemy) {
        if (this.hp > 0) {
            System.out.println(this.name + " attaque " + ennemy.name + " !");
            int degats = Main.intScan(-1000, 1000);
            System.out.println("Vous avez saisi le nombre : " + degats);

            ennemy.setHp(ennemy.hp - degats);
            System.out.println(ennemy.name + " " + ennemy.hp + "/" + ennemy.hpMax + "\n");
            if (ennemy.hp < 1) {
                ennemy.setHp(0);
            }
        }
    }

    public String createCharString() throws IllegalAccessException {
        String statsOfCharInString = "";
        String str = "";
        Field[] fields = Character.class.getDeclaredFields();
        System.out.println("fields length : " + fields.length);
        for (int i = 0; i < fields.length; i++) {
            try {
                str = fields[i].get(this).toString() + " ";
            } catch (Exception e) {

            }
            statsOfCharInString = statsOfCharInString + str;
        }
        statsOfCharInString = statsOfCharInString + "\n";
        return statsOfCharInString;
    }

    private int getSumHp(ArrayList<Character> characters) {
        int sumHp = 0;
        for (Character mob : characters) {
            sumHp = sumHp + mob.hp;
        }
        return sumHp;
    }

//    public Character(boolean isHuman, String name, int hpmax, int hp) {
//        this.isHuman = isHuman;
//        this.name = name;
//        this.hpMax = hpmax;
//        this.hp = hp;
//    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHpmax() {
        return hpMax;
    }

    public void setHpmax(int hpmax) {
        this.hpMax = hpmax;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

}
