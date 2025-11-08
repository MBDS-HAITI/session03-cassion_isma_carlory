package org.example;

import java.util.HashSet;
import java.util.Set;

public abstract class Character {
    // Attributs
    protected String name;
    protected Type type;
    protected int hp;
    protected int maxHp;
    private Weapon weapon;
    protected boolean isAlive;

    //static list of usedNames in the party

    private static final Set<String> usedNames = new HashSet<>();

    //region constructor


    public Character(String name, Type type) {
        this.name = name;
        this.hp = type.getStartingHP();
        this.maxHp = type.getMaxHP();
        this.type = type;
        this.isAlive = true;
        this.weapon= new Weapon("Kalash", type.getWeaponPower());
        if(usedNames.contains(name.toLowerCase())){
            throw new IllegalStateException("Character name already used!");
        }
        usedNames.add(name.toLowerCase());
    }

    public Character() {

    }

    //endregion constructor

    //region Setters and getters
    public Weapon getWeapon() {
        return weapon;
    }

    public Type getType() {
        return type;
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
