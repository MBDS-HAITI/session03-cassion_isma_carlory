package org.example;

import java.util.HashSet;
import java.util.Set;

public abstract class Character {
    // Attributs
    protected String name;
    protected Type type;
    protected int hp;
    protected Weapon weapon;
    protected boolean isAlive;

    //static list of usedNames in the party

    private static Set<String> usedNames = new HashSet<>();

    //region constructor


    public Character(String name, int hp, Type type, boolean isAlive) {
        this.name = name;
        this.hp = hp;
        this.type = type;
        this.isAlive = true;
    }

    //endregion constructor

    //region Setters and getters

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
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

    //endregion Methods
}
