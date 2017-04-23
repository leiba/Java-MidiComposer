package dp.leiba.midi.generate.lead;

import dp.leiba.midi.generate.access.ALead;
import dp.leiba.midi.generate.position.Position;
import dp.leiba.midi.generate.tick.TickLead;
import dp.leiba.midi.theory.Accent;
import dp.leiba.midi.theory.Theory;
import dp.leiba.midi.tool.ToolNumber;

/**
 * LeadLine.
 */
public class LeadLine extends ALead
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
    public LeadLine(int tone, boolean isMajor, Accent[] accents, int size, boolean isTriplet)
    {
        super(tone, isMajor, accents, size, isTriplet);

        int random, accent = tone;

        for (Position pos : _getPositions(accents, size, isTriplet)) {
            if (pos.accent != Position.NOP) {
                random = accent = accents[pos.accent].tone;
            } else {
                random = Theory.getToneNear(tone, isMajor, accent, ToolNumber.getRandom(-2, 2));
            }

            _tones.add(TickLead.get(random, pos.position, pos.ticks));
        }
    }
}
