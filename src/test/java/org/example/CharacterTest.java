package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CharacterTest {

    static class TestCharacter extends Character {
        public TestCharacter(String name, Type type) {
            super(name, type);
        }
        @Override
        public void action() {
        }
    }

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
    @Test
    void shouldThrowExceptionWhenNameAlreadyExists() {
        new TestCharacter("cassion",Type.WARRIOR);
//        Exception
        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> new TestCharacter("cassion",Type.MAGUS));
        assertEquals("Character name already used!", exception.getMessage());
    }


    @org.junit.jupiter.api.Test
    void getWeapon() {
    }

    @org.junit.jupiter.api.Test
    void getType() {
    }

    @org.junit.jupiter.api.Test
    void getHp() {
    }

    @org.junit.jupiter.api.Test
    void setHp() {
    }

    @org.junit.jupiter.api.Test
    void isAlive() {
    }

    @org.junit.jupiter.api.Test
    void action() {
    }

    @org.junit.jupiter.api.Test
    void takeDamage() {
    }

    @org.junit.jupiter.api.Test
    void heal() {
    }
}