package dp.leiba.midi.generate.tick;

/**
 * TickChord.
 */
public class TickChord
{

    /**
     * Chord.
     */
    public int[] chord;

    /**
     * Ticks.
     */
    public int ticks;

    /**
     * Constructor.
     *
     * @param chord Chord.
     * @param ticks Ticks.
     */
    public TickChord(int[] chord, int ticks)
    {
        this.chord = chord;
        this.ticks = ticks;
    }

    /**
     * Get object.
     *
     * @param chord Chord.
     * @param ticks Ticks.
     *
     * @return TickChord.
     */
    public static TickChord get(int[] chord, int ticks)
    {
        return new TickChord(chord, ticks);
    }

}
