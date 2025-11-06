package org.example;

// I'm putting the class in the final position to avoid inheritance
// Since the object is immutable (all fields are final and there are no setters)
public final class Weapon {
    private final String name;
    private final int power;

    //constructor and validation, an error is raised immediately if the data is invalid.
    public Weapon(String name, int power) {
        if (power <= 0) throw new IllegalArgumentException("La puissance doit etre positive");
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString(){
        return name + "(Puissance "+ power + ")";
    }
}
