package dp.leiba.midi.generate;

import dp.leiba.midi.generate.tick.TickBass;
import dp.leiba.midi.theory.Accent;

import java.util.ArrayList;

/**
 * ABass.
 */
abstract public class ABass
{

    /**
     * Tones.
     */
    protected ArrayList<TickBass> _tones;

    /**
     * Constructor.
     *
     * @param tone    Tone.
     * @param isMajor Is major.
     * @param accents Accents.
     * @param size    Size.
     */
    public ABass(int tone, boolean isMajor, Accent[] accents, int size)
    {
        _tones  = new ArrayList<>();
    }

    /**
     * Get tones.
     *
     * @return Tones.
     */
    public ArrayList<TickBass> get()
    {
        return _tones;
    }
}
