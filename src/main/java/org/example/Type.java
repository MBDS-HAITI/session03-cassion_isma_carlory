package org.example;

public enum Type {

    WARRIOR("bazouka",90,90),
    MAGUS("baz",90,90),
    COLOSSUS("calash",90,90),
    DWARF("nick",90,90);

    private final int startingHP;
    private final int maxHP;
    private final int weaponPower;
    private final String weaponName;
    Type(String weaponName, int weaponPower,int startingHP){
        this.weaponPower = weaponPower;
        this.startingHP=startingHP;
        this.maxHP=startingHP;
        this.weaponName=weaponName;
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
    public String getWeaponName(){
        return this.weaponName;
    }

}
