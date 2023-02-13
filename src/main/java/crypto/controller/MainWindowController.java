package crypto.controller;

import crypto.Crypto;
import crypto.view.MainWindow;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class MainWindowController {
    private final MainWindow mainWindow;

    public MainWindowController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        mainWindow.getTextToEncrypt().addFocusListener(new TextAreaFocusListener());
        mainWindow.getTextToDecrypt().addFocusListener(new TextAreaFocusListener());
        mainWindow.getEncryptButton().addActionListener(new EncryptButtonEventListener());
        mainWindow.getDecryptButton().addActionListener(new DecryptButtonEventListener());
        mainWindow.getEncryptCopyButton().addActionListener(new CopyEncryptButtonEventListener());
        mainWindow.getDecryptCopyButton().addActionListener(new CopyDecryptButtonEventListener());
    }

    static class TextAreaFocusListener implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            JTextArea text = (JTextArea) e.getSource();
            text.setText(null);
        }

        @Override
        public void focusLost(FocusEvent e) {

        }
    }

    class EncryptButtonEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Crypto crypto = new Crypto();
            String textToEncrypt = mainWindow.getTextToEncrypt().getText();
            String textEncrypted = "";
            try {
                textEncrypted = crypto.encrypt(textToEncrypt);
            } catch (InvalidKeySpecException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidAlgorithmParameterException invalidKeySpecException) {
                invalidKeySpecException.printStackTrace();
            }
            mainWindow.getEncryptedText().setText(textEncrypted);
        }
    }

    class DecryptButtonEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Crypto crypto = new Crypto();
            String textToDecrypt = mainWindow.getTextToDecrypt().getText();
            String textDecrypted = "";
            try {
                textDecrypted = crypto.decrypt(textToDecrypt);
            } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidAlgorithmParameterException invalidKeySpecException) {
                invalidKeySpecException.printStackTrace();
            }
            mainWindow.getDecryptedText().setText(textDecrypted);
        }
    }

    class CopyEncryptButtonEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StringSelection copyText = new StringSelection(mainWindow.getEncryptedText().getText());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(copyText, null);
        }
    }

    class CopyDecryptButtonEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StringSelection copyText = new StringSelection(mainWindow.getDecryptedText().getText());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(copyText, null);
        }
    }
}
