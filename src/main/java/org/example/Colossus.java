package org.example;

public class Colossus extends Character implements Attacker {
    //TODO


    public Colossus(String name, Weapon weapon, int hp, String type, boolean isAlive, int maxHp) {
        super(name, weapon, hp, type,isAlive,maxHp);
    }

    @Override
    public void action() {
    }

    //we implement the method to attc
    @Override
    public void attack(Character ennemie) {
        if (!this.isAlive() || ennemie == null || !ennemie.isAlive()) return;
        ennemie.takeDamage(getWeapon().getPower());
    }
}
