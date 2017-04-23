package dp.leiba.midi.generate;

import dp.leiba.midi.generate.tick.TickChord;
import dp.leiba.midi.theory.Accent;

/**
 * AChord.
 */
abstract public class AChord
{

    /**
     * Chords.
     */
    protected TickChord[] _chords;

    /**
     * Constructor.
     *
     * @param tone    Tone.
     * @param isMajor Is major.
     * @param accents Accents.
     * @param size    Size.
     */
    public AChord(int tone, boolean isMajor, Accent[] accents, int size)
    {
        _chords  = new TickChord[size];
    }

    /**
     * Get chords.
     *
     * @return Chords.
     */
    public TickChord[] get()
    {
        return _chords;
    }
}
