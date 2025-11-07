package org.example;

public class Magus  extends Character implements Attacker, Healer {
    public static final int HEAL_POWER = 25;


    public Magus(String name, Weapon weapon, int hp, String type,boolean isAlive, int maxHp) {
        super(name, weapon, hp, type, isAlive, maxHp);
    }

    @Override
    public void action() {

    }

    @Override
    public void attack(Character ennemie) {
        if (!this.isAlive() || ennemie == null || !ennemie.isAlive()) return;
        ennemie.takeDamage(getWeapon().getPower());
    }

    @Override
    public void heal(Character allie) {
        if (!this.isAlive() || allie == null || !allie.isAlive()) return;
        allie.heal(HEAL_POWER);
    }
}
