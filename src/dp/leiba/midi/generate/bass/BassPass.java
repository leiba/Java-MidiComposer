package dp.leiba.midi.generate.bass;

import dp.leiba.midi.generate.ABass;
import dp.leiba.midi.generate.tick.TickBass;
import dp.leiba.midi.theory.Accent;
import dp.leiba.midi.tool.ToolNumber;

/**
 * BassPass.
 */
public class BassPass extends ABass
{

    /**
     * Constructor.
     *
     * @param tone    Tone.
     * @param isMajor Is major.
     * @param accents Accents.
     * @param size    Size.
     */
    public BassPass(int tone, boolean isMajor, Accent[] accents, int size)
    {
        super(tone, isMajor, accents, size);

        int step = size / accents.length;

        for (int i = 0; i < accents.length; i++) {
            if (ToolNumber.getIs() || i == 0) {
                _tones.add(TickBass.get(accents[i].tone, i * step, step));
            }
        }
    }
}
