package dp.leiba.midi.generate.chord;

import dp.leiba.midi.generate.AChord;
import dp.leiba.midi.generate.tick.TickChord;
import dp.leiba.midi.theory.Accent;
import dp.leiba.midi.theory.Theory;

/**
 * ChordAccent.
 */
public class ChordAccent extends AChord
{
    /**
     * Constructor.
     *
     * @param tone    Tone.
     * @param isMajor Is major.
     * @param accents Accents.
     * @param size    Size.
     */
    public ChordAccent(int tone, boolean isMajor, Accent[] accents, int size)
    {
        super(tone, isMajor, accents, size);

        int[] chord;
        int step = size / accents.length;

        for (int i = 0; i < accents.length; i++) {
            chord = Theory.getChord(accents[i].tone, accents[i].isMajor);
            _chords[(i++) * step] = TickChord.get(chord, step);
        }
    }
}