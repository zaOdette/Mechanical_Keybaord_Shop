package test;

import org.junit.jupiter.api.Test;
import view.MainView;
import view.MenuView;
import view.ViewsView;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class MenuViewTest {

    @Test
    void testMenuView() {
        SwingUtilities.invokeLater(() -> {
            MenuView menuView = new MenuView();
            assertNotNull(menuView, "MenuView should be instantiated");

            menuView.shopButton.doClick(); // simulates click on Shop button
            MainView mainView = new MainView();
            assertTrue(mainView.isDisplayable(), "MainView should be displayable after clicking Shop button");

            menuView.viewsButton.doClick(); // simulates click on Statistics button
            ViewsView viewsView = new ViewsView();
            assertTrue(viewsView.isDisplayable(), "MenuView should be displayable after clicking Statistics button");

            assertFalse(menuView.isDisplayable(), "MenuView should be disposed after clicking Shop or Statistics button");
        });
    }
}