package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.JTextComponent;

import java.awt.BorderLayout;
/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    public SimpleGUI() {
        /*
         * Components
         */
        JTextField upperTextField = new JTextField();
        JTextArea centerTextArea = new JTextArea();
        JButton printButton = new JButton("Print");
        JButton historyButton = new JButton("Show history");
        /*
         * Layout
         */
        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);
        panel.add(upperTextField, BorderLayout.NORTH);
        panel.add(centerTextArea, BorderLayout.CENTER);
        JPanel buttonsPanel = new JPanel(new BorderLayout());
        panel.add(buttonsPanel, BorderLayout.SOUTH);
        buttonsPanel.add(printButton, BorderLayout.LINE_START);
        buttonsPanel.add(historyButton, BorderLayout.LINE_END);
    }

    public void display() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI().display();
    }
}
