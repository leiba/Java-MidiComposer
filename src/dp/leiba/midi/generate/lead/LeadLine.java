package dp.leiba.midi.generate.lead;

import dp.leiba.midi.generate.access.ALead;
import dp.leiba.midi.generate.position.Position;
import dp.leiba.midi.generate.tick.TickLead;
import dp.leiba.midi.theory.Accent;
import dp.leiba.midi.tool.ToolNumber;

/**
 * LeadLine.
 */
public class LeadLine extends ALead
{

    /**
     * Constructor.
     *
     * @param tone    Tone.
     * @param isMajor Is major.
     * @param accents Accents.
     * @param size    Size.
     */
    public LeadLine(int tone, boolean isMajor, Accent[] accents, int size)
    {
        super(tone, isMajor, accents, size);

        int random, accent = tone;

        for (Position pos : _getPositions(accents, size, ToolNumber.getIs())) {
            if (pos.accent != Position.NOP) {
                random = accent = accents[pos.accent].tone;
            } else {

                random = accent;
            }

            _tones.add(TickLead.get(random, pos.position, pos.ticks));
        }
    }
}
