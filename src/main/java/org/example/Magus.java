package org.example;

public class Magus  extends Character implements Attacker, Healer {
    public static final int HEAL_POWER = 25;

    public Magus(String name) {
        super(name, Type.MAGUS);
    }

    @Override
    public void action() {

    }

    @Override
    public void attack(Character enemy) {
        if (!this.isAlive() || enemy == null || !enemy.isAlive()) return;
        enemy.takeDamage(getWeapon().getPower());
    }

    @Override
    public void heal(Character friend) {
        if (!this.isAlive() || friend == null || !friend.isAlive()) return;
        friend.heal(HEAL_POWER);
    }
}
