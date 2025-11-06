package org.example;

import java.util.HashSet;
import java.util.Set;

public abstract class Character {
    // Attributs
    protected String name;
    protected String type;
    protected int hp;
    protected Weapon weapon;
    protected boolean isAlive;

    //liste statiques des noms utilisés dans la partie

    private static Set<String> usedNames = new HashSet<>();

    //region constructeur


    public Character(String name, Weapon weapon, int hp, String type) {
        this.name = name;
        this.weapon = weapon;
        this.hp = hp;
        this.type = type;
        this.isAlive = true;
    }

    //endregion constructeur

    //region Setters and getters

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

    //endregion Methods
}
