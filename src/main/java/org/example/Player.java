package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public  class Player {
    private List<Character> characters = new ArrayList<>();
    private static final Set<String> names = new HashSet<>();
    private final String name;
    private final Set<Type> characterTypes = new HashSet<>();
    public Player(String name,List<Character> characters) {
        this.characters = characters;
        if(name.isBlank()){
            throw new IllegalArgumentException("Player name cannot be blank");
        }
        if(name.length()<3){
            throw new IllegalArgumentException("Player name length cannot be less than 3");
        }
//        Verify that the name did not exist in the names property
        if(Player.names.contains(name.toLowerCase())) {
            throw  new IllegalArgumentException("Player already exists");
        }
        if (characters.size() > 3) {
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
            if(this.characterTypes.contains(character.getType())) {
                return false;
            }
            this.characterTypes.add(character.getType());
        }

        return true ;
    }

    public String getName() {
        return name;
    }
//    Allow to add a Character
    public void addCharacter(Character character) {
        if(this.characterTypes.contains(character.getType())) {
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

//    know if the player is defeated
    public boolean isDefeated() {
        for(Character character : this.characters) {
            if(character.isAlive()) {
                return false;
            }
        }
        return true;

    }

    public List<Character> getActiveCharacters() {
        List<Character> activeCharacters = new ArrayList<>();
        for(Character character : this.characters) {
            if(character.isAlive()) {
                activeCharacters.add(character);
            }
        }
        return activeCharacters;
    }
}
