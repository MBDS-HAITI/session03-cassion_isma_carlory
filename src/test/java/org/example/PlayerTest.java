package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getName() {
    }

    @Test
    void addCharacter_rejectDuplicateType() {
        try {
            Character c = new Magus("m1");
            Character c2 = new Warrior("m2");
            List<Character> list = new ArrayList<>();
            list.add(c);
            list.add(c2);
            Player p = new Player("Player1", list);
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                p.addCharacter(new Magus("m3"));
            });
            assertEquals("The type of characters must be unique", exception.getMessage());
        }
        catch (Exception e) {
            fail();
        }
//
    }

    @Test
    void addCharacters_rejectMoreThanThreeCharacters() {
        Character c = new Magus("mm1");
        Character c2 = new Warrior("mm2");
        List<Character> list = new ArrayList<>();
        list.add(c);
        list.add(c2);
        Player p = new Player("Player2", list);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            p.addCharacter(new Colossus("mm3"));
            p.addCharacter(new Dwarf("mm4"));
        });
        assertEquals("The number of characters must be 3", exception.getMessage());
    }
}