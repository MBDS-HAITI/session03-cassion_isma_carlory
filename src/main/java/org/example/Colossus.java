package org.example;

public class Colossus extends Character implements Attacker {
    //TODO

    public  Colossus(String name){
        super();

    }

    public Colossus(String name, Weapon weapon, int hp, String type, boolean isAlive, int maxHp) {
        super(name, weapon, hp, type,isAlive,maxHp);
    }

    @Override
    public void action() {
    }

    //we implement the method to attack
    @Override
    public void attack(Character enemy) {
        if (!this.isAlive() || enemy == null || !enemy.isAlive()) return;
        enemy.takeDamage(getWeapon().getPower());
    }
}
