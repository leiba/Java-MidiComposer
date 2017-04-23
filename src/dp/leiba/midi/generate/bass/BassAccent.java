package dp.leiba.midi.generate.bass;

import dp.leiba.midi.generate.ABass;
import dp.leiba.midi.generate.tick.TickBass;
import dp.leiba.midi.theory.Accent;
import dp.leiba.midi.theory.Theory;
import dp.leiba.midi.tool.ToolNumber;

/**
 * BassAccent.
 */
public class BassAccent extends ABass
{

    /**
     * Constructor.
     *
     * @param tone    Tone.
     * @param isMajor Is major.
     * @param accents Accents.
     * @param size    Size.
     */
    public BassAccent(int tone, boolean isMajor, Accent[] accents, int size)
    {
        super(tone, isMajor, accents, size);

        int random;
        int step  = size / accents.length;
        int shift = step / 2;

        for (int i = 0; i < accents.length; i++) {
            _tones.add(TickBass.get(accents[i].tone, i * step, shift));

            if (ToolNumber.getIs()) {
                random = Theory.getToneRandom(tone, isMajor);
                _tones.add(TickBass.get(random, i * step + shift, shift));
            }
        }
    }
}
