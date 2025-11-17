package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller c;

    /**
     * Initialize simple gui.
     */
    public SimpleGUI() {
        c = new Controller();
        final JTextArea textArea = new JTextArea();
        final JButton save = new JButton("Save");
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel);
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(save, BorderLayout.SOUTH);
        /*
         * Handlers
         */
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    c.writeFile(textArea.getText());
                } catch (final IOException ioException) {
                    JOptionPane.showMessageDialog(frame, "Error occured writing the file.");
                }
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Application entry point.
     * 
     * @param args
     *              command line args
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}
