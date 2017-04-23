package dp.leiba.midi.generate.position;

import dp.leiba.midi.theory.Accent;
import dp.leiba.midi.tool.ToolNumber;

import java.util.ArrayList;

/**
 * APosition.
 */
abstract public class APosition
{

    /**
     * Get positions.
     *
     * @param accents   Accents.
     * @param size      Size.
     * @param isTriplet Is triplet.
     *
     * @return Positions.
     */
    protected ArrayList<Position> _getPositions(Accent[] accents, int size, boolean isTriplet)
    {
        int shift;
        int step = size / accents.length;
        int tick = step / ((isTriplet ? 3 : 4) * ToolNumber.getRandom(4, 5));
        ArrayList<Position> positions = new ArrayList<>();

        for (int i = 0; i < accents.length; i++) {
            positions.add(Position.get(i, shift = (i * step), tick));

            for (; shift < (i * step + step); shift += tick) {
                if (ToolNumber.getIs()) {
                    positions.add(Position.get(shift, ToolNumber.getRandom(tick)));
                }
            }
        }

        return positions;
    }
}
