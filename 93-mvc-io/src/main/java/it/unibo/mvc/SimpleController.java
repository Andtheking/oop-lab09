package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * Simple {@link Controller} implementation.
 */
public final class SimpleController implements Controller {
    private final List<String> history;
    private String nextString;

    /**
     * Creates a new SimpleController and initializes history {@link List} as a {@link LinkedList}.
     */
    public SimpleController() {
        history = new LinkedList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeLine() {
        if (nextString == null) {
            throw new IllegalStateException("Next string to print was null.");
        }
        System.out.println(nextString); // NOPMD Requested to write to stdout by the exercise.
        history.add(nextString);
    }

    /**
     * Set the next {@link String} to print.
     * 
     * @param text
     *              {@link String} to print.
     */
    public void setNextString(final String text) {
        nextString = text;
    }

    /**
     * Get the next {@link String} to print with {@link #writeLine()}.
     * 
     * @return
     *          The next {@link String} that will be printed by {@link #writeLine()}.
     */
    public String getNextString() {
        return nextString;
    }

    /**
     * Get all printed strings as a {@link LinkedList} of {@link String}s.
     * 
     * @return
     *          {@link LinkedList}<{@link String}> of all printed {@link String}s.
     */
    public List<String> getHistory() {
        return new LinkedList<>(history); // safety copy
    }

}
