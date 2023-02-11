package crypto;

import crypto.controller.MainWindowController;
import crypto.view.MainWindow;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CryptoSwingApp {
    private static final Logger logger = Logger.getLogger(CryptoSwingApp.class.getName());
    public static void main(String[] args) {
        MainWindow app = new MainWindow();
        MainWindowController controller = new MainWindowController(app);
        initMetalLookAndFeel();
        app.setVisible(true);
    }

    public static void initMetalLookAndFeel() {
        try {
            // OceanTheme, DefaultMetalTheme
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            logger.log(Level.WARNING, "Не удается использовать указанный вид на этой платформе");
        } catch (Exception e) {
            logger.log(Level.WARNING, "Не получилось установить LookAndFeel.");
        }
    }
}
