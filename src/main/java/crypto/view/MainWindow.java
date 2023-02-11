package crypto.view;

import crypto.controller.MainWindowController;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class MainWindow extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel panel1;
    private JPanel panel2;
    private JTextArea textToEncrypt;
    private JTextArea encryptedText;

    private JTextArea textToDecrypt;
    private JTextArea decryptedText;

    private JButton encryptButton;
    private JButton encryptCopyButton;

    private JButton decryptButton;
    private JButton decryptCopyButton;

    private JScrollPane jScrollToEncrypt;
    private JScrollPane jScrollEncrypted;

    private JScrollPane jScrollToDecrypt;
    private JScrollPane jScrollDecrypted;
    private MainWindowController controller;
    private Container container;

    public MainWindow() {
        super("Шифратор");
        this.setBounds(100, 100, 700, 700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        container = this.getContentPane();
        panel1 = new JPanel(null);
        panel2 = new JPanel(null);
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        container.add(tabbedPane);

        tabbedPane.add("Шифрация", panel1);
        tabbedPane.add("Дешифрация", panel2);

        panel1.setLayout(null);

        textToEncrypt = new JTextArea();
        textToEncrypt.setText("Исходная строка");
        jScrollToEncrypt = new JScrollPane(textToEncrypt);
        jScrollToEncrypt.setBounds(20, 100, 350, 40);

        encryptedText = new JTextArea();
        encryptedText.setText("Результат");
        jScrollEncrypted = new JScrollPane(encryptedText);
        jScrollEncrypted.setBounds(20, 180, 350, 40);

        panel1.add(jScrollToEncrypt);
        panel1.add(jScrollEncrypted);

        encryptButton = new JButton();
        encryptButton.setText("Зашифровать");
        encryptButton.setBounds(500, 105, 140, 30);
        panel1.add(encryptButton);
        encryptCopyButton = new JButton();
        encryptCopyButton.setText("Копировать");
        encryptCopyButton.setBounds(500, 185, 140, 30);
        panel1.add(encryptCopyButton);

        panel2.setLayout(null);

        textToDecrypt = new JTextArea();
        textToDecrypt.setText("Зашифрованная строка");
        jScrollToDecrypt = new JScrollPane(textToDecrypt);
        jScrollToDecrypt.setBounds(20, 100, 350, 40);
        decryptedText = new JTextArea();
        decryptedText.setText("Результат");
        jScrollDecrypted = new JScrollPane(decryptedText);
        jScrollDecrypted.setBounds(20, 180, 350, 40);

        panel2.add(jScrollToDecrypt);
        panel2.add(jScrollDecrypted);

        decryptButton = new JButton();
        decryptButton.setText("Расшифровать");
        decryptButton.setBounds(500, 105, 140, 30);
        panel2.add(decryptButton);
        decryptCopyButton = new JButton();
        decryptCopyButton.setText("Копировать");
        decryptCopyButton.setBounds(500, 185, 140, 30);
        panel2.add(decryptCopyButton);
    }
}
