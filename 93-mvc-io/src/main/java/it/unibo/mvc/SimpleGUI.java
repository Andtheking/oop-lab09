package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.BorderLayout;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();

    /**
     * Creates and initializes the components of the SimpleGUI.
     */
    public SimpleGUI() {
        final Controller c = new SimpleController();
        /*
         * Components
         */
        final JTextField upperTextField = new JTextField();
        final JTextArea centerTextArea = new JTextArea();
        centerTextArea.setEnabled(false);
        final JButton printButton = new JButton("Print");
        final JButton historyButton = new JButton("Show history");
        /*
         * Layout
         */
        final JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);
        panel.add(upperTextField, BorderLayout.NORTH);
        panel.add(centerTextArea, BorderLayout.CENTER);
        final JPanel buttonsPanel = new JPanel(new BorderLayout());
        panel.add(buttonsPanel, BorderLayout.SOUTH);
        buttonsPanel.add(printButton, BorderLayout.LINE_START);
        buttonsPanel.add(historyButton, BorderLayout.LINE_END);
        /*
         * Handlers
         */
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                c.setNextString(upperTextField.getText());
                c.writeLine();
            }
        });
        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final var history = c.getHistory();
                final StringBuilder historyBuilder = new StringBuilder();
                for (final String string : history) {
                    historyBuilder.append(string).append('\n');
                }
                centerTextArea.setText(historyBuilder.toString());
            }
        });
    }

    /**
     * Displays the GUI.
     */
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        /* Setting Window with proportions and not with JFrame#pack() method 
         * because with JFrame#pack() the text area is too small. */
        frame.setSize(sw / PROPORTION, sh / PROPORTION); 
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Launch point of the GUI.
     * 
     * @param args 
     *              unused
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}
