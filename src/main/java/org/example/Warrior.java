package org.example;

public class Warrior extends Character implements Attacker {
    public Warrior(String name) {
        super(name, Type.WARRIOR);
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
