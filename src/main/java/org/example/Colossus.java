package org.example;

public class Colossus extends Character implements Attacker {
    //TODO

    public Colossus(String name) {
        super(name, Type.COLOSSUS);
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
