package efs.task.oop;

public class Monsters {
    static final Monster andariel = new Monster(10, 70) {

        @Override
        public void takeHit(int damage) {
            this.setHealth(this.getHealth() - damage);

            if (this.getHealth() > 0) {
                monstersHealth -= damage;
            }
            else {
                monstersHealth -= (damage + this.getHealth());
            }
        }

        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }
    };

    static final Monster blacksmith = new Monster(100, 25) {

        @Override
        public void takeHit(int damage) {
            this.setHealth(this.getHealth() - (damage + 5));

            if (this.getHealth() > 0) {
                monstersHealth -= (damage + 5);
            }
            else {
                monstersHealth -= (damage + 5 + this.getHealth());
            }
        }

        @Override
        public void attack(Fighter victim) {
            victim.takeHit(this.getDamage());
        }
    };

    public static int monstersHealth = andariel.getHealth() + blacksmith.getHealth();

    public static int getMonstersHealth() {
        return monstersHealth;
    }
}

