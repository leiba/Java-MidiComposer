package dp.leiba.midi.generate.access;

import dp.leiba.midi.generate.position.APosition;
import dp.leiba.midi.generate.tick.TickLead;
import dp.leiba.midi.theory.Accent;

import java.util.ArrayList;

/**
 * ALead.
 */
abstract public class ALead extends APosition
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
