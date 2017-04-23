package dp.leiba.midi.generate.tick;

import dp.leiba.midi.theory.Theory;

/**
 * TickBass.
 */
public class TickBass
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
    public TickBass(int tone, int position, int ticks)
    {
        this.tone     = tone - Theory.TONES;
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
     * @return TickChord.
     */
    public static TickBass get(int tone, int position, int ticks)
    {
        return new TickBass(tone, position, ticks);
    }
}
