package org.example;

public enum Type {

    WARRIOR("Attaquant équilibré",100,1000),
    MAGUS("Peut soigner ses alliés",50,1500),
    COLOSSUS("Très résistant",100,2000),
    DWARF("Très fort mais fragile",200,750);

    private final int startingHP;
    private final int maxHP;
    private final int weaponPower;
    private final String description;
    Type(String description, int weaponPower, int startingHP){
        this.weaponPower = weaponPower;
        this.startingHP=startingHP;
        this.maxHP=startingHP;
        this.description = description;
    }

    public int getStartingHP() {
        return this.startingHP;
    }
    public int getWeaponPower(){
        return this.weaponPower;
    }
    public int getMaxHP(){
        return this.maxHP;
    }
    public String getDescription(){
        return this.description;
    }

}
