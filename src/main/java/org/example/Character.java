package org.example;

import java.util.HashSet;
import java.util.Set;

public abstract class Character {
    // Attributs
    protected String name;
    protected String type;
    protected int hp;
    protected int maxHp;
    protected Weapon weapon;
    protected boolean isAlive;

    //static list of usedNames in the party

    private static Set<String> usedNames = new HashSet<>();

    //region constructor


    public Character(String name, Weapon weapon, int hp, String type, boolean isAlive, int maxHp) {
        this.name = name;
        this.weapon = weapon;
        this.hp = hp;
        this.maxHp = maxHp;
        this.type = type;
        this.isAlive = true;
    }

    public Character() {

    }

    //endregion constructor

    //region Setters and getters
    public Weapon getWeapon() {
        return weapon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    public boolean isAlive() {
        return isAlive;
    }

    //endregion getters



    //region Methods

    // Implementing abstract method action()
    public abstract void action();
    //public abstract String getType();

    // --- Encapsulation: only controlled ways to change HP ---
    public void takeDamage(int amount) {
        if (!isAlive()) return;
        if (amount < 0) amount = 0;
        hp = Math.max(0, hp - amount);
        if (hp == 0) isAlive = false;
    }

    public void heal(int amount) {
        if (!isAlive) return;
        if (amount < 0) amount = 0;
        hp = Math.min(maxHp, hp + amount);
    }


    //endregion Methods
}
