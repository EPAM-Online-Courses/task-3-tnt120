package efs.task.oop;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Villager kashya = new Villager("Kashya", 30);
        Villager akara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);
        Villager gheed = new Villager("Gheed", 50);
        Villager deckard_cain = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        Villager warriv = new Villager("Warriv", 35);
        Villager flawia = new Villager("Flawia", 25);

        kashya.sayHello();
        akara.sayHello();
        gheed.sayHello();
        deckard_cain.sayHello();
        warriv.sayHello();
        flawia.sayHello();

        Object objectDeckardCain = deckard_cain;
        Object objectAkara = akara;

        Monster currentMonster;
        int monsterIndex = 0;
        int i = 0;

        List<Monster> fightingMonsters = new ArrayList<>();
        fightingMonsters.add(Monsters.andariel);
        fightingMonsters.add(Monsters.blacksmith);

        List<Villager> fightingVillagers = new ArrayList<>();
        fightingVillagers.add(kashya);
        fightingVillagers.add(gheed);
        fightingVillagers.add(warriv);
        fightingVillagers.add(flawia);

        while (Monsters.getMonstersHealth() > 0 && fightingVillagers.size() > 0) {
            currentMonster = fightingMonsters.get(monsterIndex);

            for (Villager currentVillager : fightingVillagers) {
                if (currentVillager.getHealth() <= 0) {
                    fightingVillagers.remove(currentVillager);
                    continue;
                }

                if (currentMonster.getHealth() <= 0) {
                    monsterIndex++;
                    break;
                }

                System.out.println("Potwory posiadaja jeszcze " + Monsters.getMonstersHealth() + " punkty zycia");
                System.out.println("Aktualnie walczacy osadnik to " + currentVillager.getName());

                if (i % 2 ==0 ) {
                    currentVillager.attack(currentMonster);
                }
                else {
                    currentMonster.attack(currentVillager);
                }
                i++;
            }
        }

        if (fightingVillagers.size() > 0) {
            System.out.println("Obozowisko ocalone!");
        }

        deckard_cain = (ExtraordinaryVillager) objectDeckardCain;
        akara = (ExtraordinaryVillager) objectAkara;
    }
}
