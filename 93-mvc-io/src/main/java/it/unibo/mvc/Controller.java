package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    /**
     * Writes a line on Standard Output.
     */
    void writeLine();

    /**
     * Set the next {@link String} to print.
     * 
     * @param s
     *              {@link String} to print.
     */
    void setNextString(String s);

    /**
     * Get the next {@link String} to print with {@link #writeLine()}.
     * 
     * @return
     *          The next {@link String} that will be printed by {@link #writeLine()}.
     */
    String getNextString();

    /**
     * Get all printed strings of {@link String}s.
     * 
     * @return
     *          {@link List}<{@link String}> of all printed {@link String}s.
     */
    List<String> getHistory();
}
