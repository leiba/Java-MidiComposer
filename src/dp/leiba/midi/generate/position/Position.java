package dp.leiba.midi.generate.position;

/**
 * Position.
 */
public class Position
{

    public static final int NOP = -1;

    /**
     * Accent.
     */
    public int accent;

    /**
     * Position.
     */
    public int position;

    /**
     * Ticks.
     */
    public int ticks;

    /**
     * Constructor.
     *
     * @param accent   Accent.
     * @param position Position.
     * @param ticks    Ticks.
     */
    public Position(int accent, int position, int ticks)
    {
        this.accent   = accent;
        this.position = position;
        this.ticks    = ticks;

    }

    /**
     * Get object.
     *
     * @param accent   Accent.
     * @param position Position.
     * @param ticks    Ticks.
     *
     * @return Position.
     */
    public static Position get(int accent, int position, int ticks)
    {
        return new Position(accent, position, ticks);
    }

    /**
     * Get object.
     *
     * @param position Position.
     * @param ticks    Ticks.
     *
     * @return Position.
     */
    public static Position get(int position, int ticks)
    {
        return new Position(NOP, position, ticks);
    }
}
