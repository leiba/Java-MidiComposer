package dp.leiba.midi.generate.tick;

import dp.leiba.midi.theory.Theory;

/**
 * TickLead.
 */
public class TickLead
{

    /**
     * Tone.
     */
    public int tone;

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
     * @param tone     Tone.
     * @param position Position.
     * @param ticks    Ticks.
     */
    public TickLead(int tone, int position, int ticks)
    {
        this.tone     = tone + Theory.TONES * 2;
        this.position = position;
        this.ticks    = ticks;
    }

    /**
     * Get object.
     *
     * @param tone     Tone.
     * @param position Position.
     * @param ticks    Ticks.
     *
     * @return TickLead.
     */
    public static TickLead get(int tone, int position, int ticks)
    {
        return new TickLead(tone, position, ticks);
    }
}
