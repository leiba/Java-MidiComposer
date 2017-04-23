package dp.leiba.midi.generate;

import dp.leiba.midi.theory.Theory;
import dp.leiba.midi.tool.ToolNumber;

/**
 * AChord.
 */
abstract public class AChord
{

    /**
     * Tone.
     */
    protected int _tone;

    /**
     * Is major.
     */
    protected boolean _isMajor;

    /**
     * Harmony.
     */
    protected int[] _harmony;

    /**
     * Size.
     */
    protected int _size;

    public AChord(int tone, boolean isMajor, int[] harmony, int size)
    {
        _tone    = tone;
        _isMajor = isMajor;
        _harmony = harmony;
        _size    = size;
    }

    



}
