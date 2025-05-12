package test;

import database.Database;
import model.Keycap;
import model.Switch;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    JLabel componentImageLabel = new JLabel();
    List<String> switchesNames = List.of(new String[]{
            "HMX Joker",
            "Gateron EF Curry",
            "Gateron Mini i",
            "JWICK Black",
            "Outemu Black",
            "JWK Durock L3",
            "Black Lotus Durock",
            "Gateron Milky Clear",
            "Gateron Mountain-Top",
            "Gateron Oil King"
    });

    Switch s = new Switch("HMX Joker", 210, new byte[0], "Linear", "45");
    Keycap k = new Keycap("LiftOff", 200, new byte[0], "PBT", "XDA");

    @Test
    void getImage() {
        assertNotNull(Database.getImage("select picture from switches where name = 'HMX Joker'"), "Image should not be null");
    }

    @Test
    void loadImage() {
        Database.loadImage("HMX Joker", componentImageLabel, "switches");
        assertNotNull(componentImageLabel.getIcon(), "Image should not be null");
    }

    @Test
    void getNames() {
        assertEquals(switchesNames, Database.getNames("switches"));
    }

    @Test
    void getPrice() {
        assertEquals(210, Database.getPrice("switches", "HMX Joker"));
    }

    @Test
    void getType() {
        assertEquals("Linear", Database.getType("switches", "HMX Joker"));
    }

    @Test
    void getMaterial() {
        assertEquals("PBT", Database.getMaterial("keycaps", "LiftOff"));
    }

    @Test
    void getProfile() {
        assertEquals("XDA", Database.getProfile("keycaps", "LiftOff"));
    }

    @Test
    void getActuationForce() {
        assertEquals(45, Database.getActuationForce("switches", "HMX Joker"));
    }

    @Test
    void getSwitch() {
        Switch sw = Database.getSwitch("HMX Joker");
        assertEquals(s.getName(), sw.getName());
        assertEquals(s.getPrice(), sw.getPrice());
        assertEquals(s.getType(), sw.getType());
        assertEquals(s.getActuationForce(), sw.getActuationForce());
    }

    @Test
    void getKeycap() {
        Keycap kc = Database.getKeycap("LiftOff");
        assertEquals(k.getName(), kc.getName());
        assertEquals(k.getPrice(), kc.getPrice());
        assertEquals(k.getMaterial(), kc.getMaterial());
        assertEquals(k.getProfile(), kc.getProfile());
    }

    @Test
    void userExists() {
        assertTrue(Database.userExists("mantal9"), "User should exist");
    }

    @Test
    void getPassword() {
        assertEquals("man", Database.getPassword("mantal9"));
    }

    @Test
    void executeQuery() {
        assertNotNull(Database.executeQuery("Keyboards that have switches that cost more than 200"), "Query result should not be null");
    }
}