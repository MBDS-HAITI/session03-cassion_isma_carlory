package org.example;

public class Dwarf extends Character implements Attacker {


    public Dwarf(String name) {
        super(name, Type.DWARF);
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
