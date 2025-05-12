package test;

import model.Switch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SwitchTest {

    Switch switch1 = new Switch("switch", 10, new byte[0], "type", "force");

    @Test
    void getDetails() {
        assertEquals("Name: switch\nPrice: 10\nSwitch type: type\nActuation force: force", switch1.getDetails());
    }
}