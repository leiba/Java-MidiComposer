package dp.leiba.midi.generate.chord;

import dp.leiba.midi.generate.AChord;
import dp.leiba.midi.generate.tick.TickChord;
import dp.leiba.midi.theory.Accent;
import dp.leiba.midi.theory.Theory;
import dp.leiba.midi.tool.ToolNumber;

/**
 * ChordPass.
 */
public class ChordPass extends AChord
{
    /**
     * Constructor.
     *
     * @param tone    Tone.
     * @param isMajor Is major.
     * @param accents Accents.
     * @param size    Size.
     */
    public ChordPass(int tone, boolean isMajor, Accent[] accents, int size)
    {
        super(tone, isMajor, accents, size);

        int[] chord;
        int step = size / accents.length;

        for (int i = 0; i < accents.length; i++) {
            if (ToolNumber.getIs()) {
                chord = Theory.getChord(accents[i].tone, accents[i].isMajor);
                _chords.add(TickChord.get(chord, (i++) * step, step));
            }
        }
    }
}
