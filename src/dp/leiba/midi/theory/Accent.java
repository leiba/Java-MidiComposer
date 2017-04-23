package dp.leiba.midi.theory;

/**
 * Accent.
 */
public class Accent
{

    /**
     * Tone.
     */
    public int tone;

    /**
     * Is major.
     */
    public boolean isMajor;

    /**
     * Constructor.
     *
     * @param tone    Tone.
     * @param isMajor Is major.
     */
    public Accent(int tone, boolean isMajor)
    {
        this.tone    = tone;
        this.isMajor = isMajor;
    }

    /**
     * Get object.
     *
     * @param tone    Tone.
     * @param isMajor Is major.
     *
     * @return Accent.
     */
    public static Accent get(int tone, boolean isMajor)
    {
        return new Accent(tone, isMajor);
    }
}
