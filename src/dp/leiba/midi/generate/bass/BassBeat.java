package dp.leiba.midi.generate.bass;

import dp.leiba.midi.generate.access.ABass;
import dp.leiba.midi.generate.tick.TickBass;
import dp.leiba.midi.theory.Accent;

/**
 * BassBeat.
 */
public class BassBeat extends ABass
{

    /**
     * Constructor.
     *
     * @param tone    Tone.
     * @param isMajor Is major.
     * @param accents Accents.
     * @param size    Size.
     */
    public BassBeat(int tone, boolean isMajor, Accent[] accents, int size)
    {
        super(tone, isMajor, accents, size);

        int step = size / accents.length;

        for (int i = 0; i < accents.length; i++) {
            _tones.add(TickBass.get(accents[i].tone, i * step, step));
        }
    }
}
