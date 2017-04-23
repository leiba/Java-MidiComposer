package dp.leiba.midi.generate.lead;

import dp.leiba.midi.generate.access.ALead;
import dp.leiba.midi.theory.Accent;

/**
 * LeadHill.
 */
public class LeadHill extends ALead
{

    /**
     * Constructor.
     *
     * @param tone    Tone.
     * @param isMajor Is major.
     * @param accents Accents.
     * @param size    Size.
     */
    public LeadHill(int tone, boolean isMajor, Accent[] accents, int size)
    {
        super(tone, isMajor, accents, size);
    }
}
