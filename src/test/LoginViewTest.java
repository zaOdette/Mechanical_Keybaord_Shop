package test;

import database.Database;
import org.junit.jupiter.api.Test;
import view.MenuView;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class LoginViewTest {

    String username = "mantal9";
    String password = "man";

    @Test
    void testLogin() {
        try {
            assertTrue(Database.userExists(username), "User not found");

            String correctPassword = Database.getPassword(username);
            assertNotNull(correctPassword, "Password not found");

            if (password.equals(correctPassword)) {
                assertTrue(true, "Login successful");
            } else {
                fail("Incorrect password");
            }
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
}