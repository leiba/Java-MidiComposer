package dp.leiba.midi.tool;

import java.util.concurrent.ThreadLocalRandom;

/**
 * ToolNumber.
 */
public class ToolNumber
{

    /**
     * Get random.
     *
     * @param min Min.
     * @param max Max.
     *
     * @return Random.
     */
    public static int getRandom(int min, int max)
    {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * Get is.
     *
     * @return Is.
     */
    public static boolean getIs()
    {
        return getRandom(0, 1) == 0;
    }
}
