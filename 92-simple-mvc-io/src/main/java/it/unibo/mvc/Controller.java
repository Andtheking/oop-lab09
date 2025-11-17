package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String DEFAULT_FILE_NAME = "output.txt";
    private File file;

    /**
     * Creates a new controller with the default path output.txt into the user home.
     */
    public Controller() {
        file = new File(
            System.getProperty("user.home")
            + File.separator
            + DEFAULT_FILE_NAME
        );
    }

    /**
     * Set the new file which this Controller will use.
     * 
     * @param file
     *              {@link File}
     */
    public void setFile(final File file) {
        this.file = file;
    }

    /**
     * Get the {@link File} representation of the File.
     * 
     * @return
     *          the {@link File} object
     */
    public File getFile() {
        return file;
    }

    /**
     * Get the path of the {@link File}.
     * 
     * @return
     *          path of the file
     */
    public String getPath() {
        return file.getAbsolutePath();
    }

    /**
     * Write text into the {@link File} with new line.
     * 
     * @param textToWrite
     *                      text to write into the file with new line.
     * @throws IOException
     *                      if error occurs while reading the file.
     */
    public void writeFile(final String textToWrite) throws IOException {
        try (PrintStream ps = new PrintStream(file, "UTF8")) {
            ps.println(textToWrite);
        }
    }
}
