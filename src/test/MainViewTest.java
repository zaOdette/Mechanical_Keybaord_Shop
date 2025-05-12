package test;

import org.junit.jupiter.api.Test;
import view.MainView;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class MainViewTest {

    @Test
    void testMainViewInitialization() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            MainView mainView = new MainView();
            assertTrue(mainView.isDisplayable(), "MainView should be displayable");
        });
    }

    @Test
    void testSwitchSelection() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            MainView mainView = new MainView();
            mainView.switchNamesComboBox.setSelectedItem("HMX Joker");
            assertEquals("HMX Joker", mainView.switchNamesComboBox.getSelectedItem(), "Selected switch should be 'HMX Joker'");
        });
    }

    @Test
    void testKeycapSelection() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            MainView mainView = new MainView();
            mainView.keycapNamesComboBox.setSelectedItem("LiftOff");
            assertEquals("LiftOff", mainView.keycapNamesComboBox.getSelectedItem(), "Selected keycap should be 'Lift Off'");
        });
    }

    @Test
    void testAddSwitchToCart() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            MainView mainView = new MainView();
            mainView.switchNamesComboBox.setSelectedItem("HMX Joker");
            mainView.switchesAddToCartButton.doClick();
            assertEquals("210", mainView.totalSum.getText(), "Total sum should be updated to 210");
        });
    }

    @Test
    void testAddKeycapToCart() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            MainView mainView = new MainView();
            mainView.keycapNamesComboBox.setSelectedItem("Lift Off");
            mainView.keycapsAddToCartButton.doClick();
            assertEquals("200", mainView.totalSum.getText(), "Total sum should be updated to 200");
        });
    }

    @Test
    void testHomeButton() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            MainView mainView = new MainView();
            mainView.homeButton.doClick();
            assertFalse(mainView.isDisplayable(), "MainView should be disposed after clicking Home button");
        });
    }
}