package org.example;

public class Warrior extends Character implements Attacker {
    //TODO

    public  Warrior(String name){
        super();
    }

    public Warrior(String name, Weapon weapon, int hp, String type,boolean isAlive, int maxHp) {
        super(name, weapon, hp, type, isAlive,maxHp);
    }

    @Override
    public void action() {
    }

    @Override
    public void attack(Character enemy) {
        if (!this.isAlive() || enemy == null || !enemy.isAlive()) return;
        enemy.takeDamage(getWeapon().getPower());
    }
}
