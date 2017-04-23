package dp.leiba.midi.generate;

import dp.leiba.midi.generate.tick.TickChord;
import dp.leiba.midi.theory.Accent;

import java.util.ArrayList;

/**
 * AChord.
 */
abstract public class AChord
{

    /**
     * Chords.
     */
    protected ArrayList<TickChord> _chords;

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
        _chords  = new ArrayList<>();
    }

    /**
     * Get chords.
     *
     * @return Chords.
     */
    public ArrayList<TickChord> get()
    {
        return _chords;
    }
}
