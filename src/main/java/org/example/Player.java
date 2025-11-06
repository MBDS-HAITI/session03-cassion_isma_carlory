package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public  class Player {
    private final List<Character> characters;
    private static Set<String> names;
    private final String name;
    public Player(String name,List<Character> characters) {
        this.characters = characters;
//        Verify that the name did not exist in the names property
        if(names.contains(name)) {
            throw  new IllegalArgumentException("Player already exists");
        }
        if (characters.size() != 3) {
            throw new IllegalArgumentException("The number of characters must be 3");
        }
        if(!this.isCharactersTypeUnique()) {
            throw new IllegalArgumentException("The type of characters must be unique");
        }
        this.name = name;
        names.add(name);

    }
//  Verify that Character type is unique for the player
    private boolean isCharactersTypeUnique() {
        Set <String> types = new HashSet<>();
        for (Character character : this.characters) {
            types.add(character.getType().toLowerCase());
        }
        return types.size() == this.characters.size();
    }

    public String getName() {
        return name;
    }
//    TODO : Implements remaining methods for player
}
