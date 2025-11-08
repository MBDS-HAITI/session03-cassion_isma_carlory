package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public  class Player {
    private List<Character> characters;
    private static final Set<String> names = new HashSet<>();
    private final String name;
    private final Set<Type> characterTypes = new HashSet<>();
    public Player(String name,List<Character> characters) {
        this.characters = characters;
//        Verify that the name did not exist in the names property
        if(Player.names.contains(name.toLowerCase())) {
            throw  new IllegalArgumentException("Player already exists");
        }
        if (characters.size() != 3) {
            throw new IllegalArgumentException("The number of characters must be 3");
        }
        if(!this.isCharactersTypeUnique()) {
            throw new IllegalArgumentException("The type of characters must be unique");
        }
        this.name = name;
        Player.names.add(name.toLowerCase());

    }
//    Allow player to be created without Characters
    public Player(String name) {
        if(Player.names.contains(name.toLowerCase())) {
            throw  new IllegalArgumentException("Player already exists");
        }
        this.name = name;
        Player.names.add(name.toLowerCase());
    }
//  Verify that Character type is unique for the player
    private boolean isCharactersTypeUnique() {
        for (Character character : this.characters) {
            this.characterTypes.add(character.getType());
        }
        return this.characterTypes.size() == this.characters.size();
    }

    public String getName() {
        return name;
    }
//    Allow to add a Character
    public void addCharacter(Character character) {
        if(!this.characterTypes.contains(character.getType())) {
            throw new IllegalArgumentException("The type of characters must be unique");
        }
        if(this.characters.size()>=3){
            throw  new IllegalArgumentException("The number of characters must be 3");
        }
        characters.add(character);
        characterTypes.add(character.getType());

    }
//    Allow player to add multiple characters
    public void addCharacters(List<Character> characters) {
        for(Character character : characters) {
            this.addCharacter(character);
        }
    }
//    Allow player to create or instanciate his own character
//    TODO : add Character using type, character name
//    I think the type should be an enum
//    public Character createCharacter() {
//
//    }
}
