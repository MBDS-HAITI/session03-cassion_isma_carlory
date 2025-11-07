package org.example;

public enum Type {

    WARRIOR("bazouka",90,90),
    MAGUS("baz",90,90),
    COLOSSUS("calash",90,90),
    DWARF("nick",90,90);

    private final Weapon weapon;
    private final int startingHP;
    Type(String weaponName, int weaponPower,int startingHP){
        this.weapon=new Weapon(weaponName,weaponPower);
        this.startingHP=startingHP;
    }

    public int getStartingHP() {
        return this.startingHP;
    }
    public Weapon getWeapon(){
        return this.weapon;
    }

}
