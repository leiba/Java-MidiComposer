package dp.leiba.midi.core;

/**
 * Melody.
 */
public class Melody
{

    /**
     * Midi.
     */
    private Midi _midi;

    /**
     * Tone.
     */
    private int _tone;

    /**
     * Is major.
     */
    private boolean _isMajor;

    /**
     * Harmony.
     */
    private int[] _harmony;

    /**
     * Harmony chords.
     */
    private int[] _chords;

    /**
     * Constructor.
     *
     * @param file File.
     */
    public Melody(String file)
        throws Exception
    {
        _midi    = new Midi(file);
        _tone    = Theory.getTone();
        _isMajor = Theory.getIsMajor();
        _harmony = Theory.getHarmony(_tone, _isMajor);
        _chords  = Theory.getHarmonyChord(_isMajor);
    }
}
