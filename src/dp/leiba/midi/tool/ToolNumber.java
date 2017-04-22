package dp.leiba.midi.tool;

/**
 * ToolNumber.
 */
public class ToolNumber
{

    /**
     * Get random.
     *
     * @param max Max.
     *
     * @return Random.
     */
    public static int getRandom(int max)
    {
        return getRandom(0, max);
    }

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
        return min + (int)(Math.random() * ((max - min) + 1));
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
