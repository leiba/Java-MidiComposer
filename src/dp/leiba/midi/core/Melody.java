package dp.leiba.midi.core;

import dp.leiba.midi.tool.ToolNumber;

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
     * Is triplet.
     */
    private boolean _isTriplet;

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
        _midi      = new Midi(file);
        _tone      = Theory.getTone();
        _isMajor   = Theory.getIsMajor();
        _isTriplet = Theory.getIsTriplet();
        _harmony   = Theory.getHarmony(_tone, _isMajor);
        _chords    = Theory.getHarmonyChord(_isMajor);
    }


}
