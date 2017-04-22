package dp.leiba.midi.core;

/**
 * Music theory.
 */
public class Theory
{

    public static final int OCTAVES             = 10;
    public static final int TONES               = 12;

    public static final int INTERVAL_UNISON     = 0;  // Прима
    public static final int INTERVAL_SECOND     = 2;  // Секунда
    public static final int INTERVAL_THIRD      = 4;  // Терция
    public static final int INTERVAL_FORTH      = 5;  // Кварта
    public static final int INTERVAL_FIFTH      = 7;  // Квинта
    public static final int INTERVAL_SIXTH      = 9;  // Секста
    public static final int INTERVAL_SEVENTH    = 11; // Септима
    public static final int INTERVAL_OCTAVE     = 12; // Октава

    public static final int INTERVAL_AUG        = 1;
    public static final int INTERVAL_BIG        = 0;
    public static final int INTERVAL_SMALL      = -1;
    public static final int INTERVAL_DIM        = -2;

    public static final int CHORD_NOP           = 0;
    public static final int CHORD_MINOR         = 1;
    public static final int CHORD_MAJOR         = 2;

    /**
     * Get harmony for tone.
     *
     * @param note Note.
     *
     * @return Harmony.
     */
    public static int[] getHarmony(int note, boolean isMajor)
    {
        int[] harmony = new int[] {
            note,
            note + INTERVAL_SECOND,
            note + INTERVAL_THIRD,
            note + INTERVAL_THIRD,
            note + INTERVAL_FORTH,
            note + INTERVAL_FIFTH,
            note + INTERVAL_SIXTH,
        };

        if (!isMajor) {
            for (int i : new int[] {2, 5, 6}) {
                harmony[i] -= INTERVAL_SMALL;
            }
        }

        return harmony;
    }

    /**
     * Get available chords for harmony.
     *
     * @param isMajor Is major.
     *
     * @return Chords harmony.
     */
    public static int[] getHarmonyChord(boolean isMajor)
    {
        int[] chords;

        if (isMajor) {
            chords = new int[] {
                CHORD_MAJOR,
                CHORD_MINOR,
                CHORD_MINOR,
                CHORD_MAJOR,
                CHORD_MAJOR,
                CHORD_MINOR,
                CHORD_NOP,
            };
        } else {
            chords = new int[] {
                CHORD_MINOR,
                CHORD_NOP,
                CHORD_MAJOR,
                CHORD_MINOR,
                CHORD_MINOR,
                CHORD_MAJOR,
                CHORD_MAJOR,
            };
        }

        return chords;
    }

    /**
     * Get chord.
     *
     * @param note    Note.
     * @param isMajor Is major.
     *
     * @return Chord.
     */
    public static int[] getChord(int note, boolean isMajor)
    {
        int interval = isMajor ? INTERVAL_BIG : INTERVAL_SMALL;

        return new int[]{
            note,
            note + INTERVAL_THIRD + interval,
            note + INTERVAL_FIFTH
        };
    }
}
