package dp.leiba.midi.generate.tick;

/**
 * TickChord.
 */
public class TickChord
{

    /**
     * Tones.
     */
    public int[] tones;

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
     * @param tones    Tones.
     * @param position Position.
     * @param ticks    Ticks.
     */
    public TickChord(int[] tones, int position, int ticks)
    {
        this.tones    = tones;
        this.position = position;
        this.ticks    = ticks;
    }

    /**
     * Get object.
     *
     * @param tones    Tones.
     * @param position Position.
     * @param ticks    Ticks.
     *
     * @return TickChord.
     */
    public static TickChord get(int[] tones, int position, int ticks)
    {
        return new TickChord(tones, position, ticks);
    }

}
