package test;

import model.Keycap;

import static org.junit.jupiter.api.Assertions.*;

class KeycapTest{

    Keycap keycap = new Keycap("keycap", 10, new byte[0], "material", "profile");

    @org.junit.jupiter.api.Test
    void testGetDetails() {
        assertEquals("Name: keycap\nPrice: 10\nMaterial: material\nProfile: profile", keycap.getDetails());
    }
}