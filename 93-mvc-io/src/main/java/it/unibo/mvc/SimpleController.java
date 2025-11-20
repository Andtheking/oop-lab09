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
     * {@inheritDoc}
     */
    @Override
    public void setNextString(final String text) {
        nextString = text;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNextString() {
        return nextString;
    }

    /**
     * {@inheritDoc}
     * The implementation is made using a {@link LinkedList}.
     */
    @Override
    public List<String> getHistory() {
        return new LinkedList<>(history); // safety copy
    }

}
