package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller c;

    /**
     * Initialize simple gui.
     */
    public SimpleGUIWithFileChooser() {
        c = new Controller();
        final JTextArea fileArea = new JTextArea();
        final JButton browse = new JButton("Browse...");
        final JButton save = new JButton("Save");
        final JTextArea writeArea = new JTextArea();
        final JPanel panel = new JPanel();
        final JPanel northPanel = new JPanel();
        frame.add(panel);
        panel.setLayout(new BorderLayout());
        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(writeArea, BorderLayout.CENTER);
        panel.add(save, BorderLayout.SOUTH);
        northPanel.setLayout(new BorderLayout());
        northPanel.add(browse, BorderLayout.LINE_END);
        northPanel.add(fileArea, BorderLayout.CENTER);
        fileArea.setEnabled(false);
        fileArea.setText(c.getPath());
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileBrowser = new JFileChooser();
                final var result = fileBrowser.showSaveDialog(frame);
                switch (result) {
                    case JFileChooser.APPROVE_OPTION -> { 
                        c.setFile(fileBrowser.getSelectedFile()); 
                        fileArea.setText(c.getPath());
                    }
                    case JFileChooser.CANCEL_OPTION -> { }
                    default -> JOptionPane.showMessageDialog(frame, "Error with the file browser.");
                }
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    c.writeFile(writeArea.getText());
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
        new SimpleGUIWithFileChooser().display();
    }
}
