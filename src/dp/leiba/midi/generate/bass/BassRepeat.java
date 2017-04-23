package dp.leiba.midi.generate.bass;

import dp.leiba.midi.generate.ABass;
import dp.leiba.midi.generate.tick.TickBass;
import dp.leiba.midi.theory.Accent;

/**
 * BassRepeat.
 */
public class BassRepeat extends ABass
{

    /**
     * Constructor.
     *
     * @param tone    Tone.
     * @param isMajor Is major.
     * @param accents Accents.
     * @param size    Size.
     */
    public BassRepeat(int tone, boolean isMajor, Accent[] accents, int size)
    {
        super(tone, isMajor, accents, size);

        int step  = size / accents.length;
        int shift = step / 4;

        for (int i = 0; i < accents.length; i++) {
            for (int j = 0; j < 4; j++) {
                _tones.add(TickBass.get(accents[i].tone, i * step + (j * shift), shift));
            }
        }
    }
}
