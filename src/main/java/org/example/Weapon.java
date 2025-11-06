package org.example;

// I'm putting the class in the final position to avoid inheritance
// Since the object is immutable (all fields are final and there are no setters)
public final class Weapon {
    private final String nom;
    private final int puissance;

    //constructor and validation, an error is raised immediately if the data is invalid.
    public Weapon(String nom, int puissance) {
        if (puissance <= 0) throw new IllegalArgumentException("La puissance doit etre positive");
        this.nom = nom;
        this.puissance = puissance;
    }

    public String getNom() {
        return nom;
    }

    public int getPuissance() {
        return puissance;
    }

    @Override
    public String toString(){
        return nom + "(Puissance "+ puissance + ")";
    }
}
