package dp.leiba.midi.generate;

import dp.leiba.midi.generate.tick.TickLead;
import dp.leiba.midi.theory.Accent;

import java.util.ArrayList;

/**
 * ALead.
 */
abstract public class ALead
{

    /**
     * Tones.
     */
    protected ArrayList<TickLead> _tones;

    /**
     * Constructor.
     *
     * @param tone    Tone.
     * @param isMajor Is major.
     * @param accents Accents.
     * @param size    Size.
     */
    public ALead(int tone, boolean isMajor, Accent[] accents, int size)
    {
        _tones  = new ArrayList<>();
    }

    /**
     * Get tones.
     *
     * @return Tones.
     */
    public ArrayList<TickLead> get()
    {
        return _tones;
    }
}
