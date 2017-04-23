package dp.leiba.midi.generate.lead;

import dp.leiba.midi.generate.access.ALead;
import dp.leiba.midi.theory.Accent;

/**
 * LeadUp.
 */
public class LeadUp extends ALead
{

    /**
     * Constructor.
     *
     * @param tone      Tone.
     * @param isMajor   Is major.
     * @param accents   Accents.
     * @param size      Size.
     * @param isTriplet Is triplet.
     */
    public LeadUp(int tone, boolean isMajor, Accent[] accents, int size, boolean isTriplet)
    {
        super(tone, isMajor, accents, size, isTriplet);
    }
}
