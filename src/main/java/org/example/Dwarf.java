package org.example;

public class Dwarf extends Character implements Attacker {



    public Dwarf(String name, Weapon weapon, int hp, String type, boolean isAlive) {
        super(name, weapon, hp, type,isAlive);
    }

    @Override
    public void action() {

    }


    @Override
    public void attack(Character ennemie) {
        if (!this.isAlive() || ennemie == null || !ennemie.isAlive()) return;
        ennemie.takeDamage(getWeapon().getPower());
    }
}
