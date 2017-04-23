package dp.leiba.midi.theory;

import dp.leiba.midi.tool.ToolNumber;

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
     * Get tone.
     *
     * @return Tone.
     */
    public static int getTone()
    {
        int min = 5 * TONES;
        int max = 6 * TONES - 1;

        return ToolNumber.getRandom(min, max);
    }

    /**
     * Get is major.
     *
     * @return Is major.
     */
    public static boolean getIsMajor()
    {
        return ToolNumber.getIs();
    }

    /**
     * Get is triplet.
     *
     * @return Is triplet.
     */
    public static boolean getIsTriplet()
    {
        return ToolNumber.getIs();
    }

    /**
     * Get accents.
     *
     * @param tone    Tone.
     * @param isMajor Is major.
     * @param size    Size.
     *
     * @return Accents.
     */
    public static Accent[] getAccents(int tone, boolean isMajor, int size)
    {
        int[] chord;
        int i = 0;
        Accent[] accents = new Accent[size];
        accents[i]       = Accent.get(tone, isMajor);

        while (++i < size) {
            chord      = getChordRandom(tone, isMajor);
            accents[i] = Accent.get(chord[0], (chord[1] - chord[0]) == INTERVAL_THIRD);
        }

        return accents;
    }

    /**
     * Get harmony for tone.
     *
     * @param tone Tone.
     *
     * @return Harmony.
     */
    public static int[] getHarmony(int tone, boolean isMajor)
    {
        int[] harmony = new int[] {
            tone,
            tone + INTERVAL_SECOND,
            tone + INTERVAL_THIRD,
            tone + INTERVAL_FORTH,
            tone + INTERVAL_FIFTH,
            tone + INTERVAL_SIXTH,
            tone + INTERVAL_SEVENTH,
        };

        if (!isMajor) {
            for (int i : new int[] {2, 5, 6}) {
                harmony[i] += INTERVAL_SMALL;
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
     * @param tone Tone.
     * @param type Type.
     *
     * @return Chord.
     */
    public static int[] getChord(int tone, int type)
    {
        int[] chord = null;

        if (type == CHORD_MAJOR) {
            chord = getChord(tone, true);
        } else if (type == CHORD_MINOR) {
            chord = getChord(tone, false);
        }

        return chord;
    }

    /**
     * Get chord.
     *
     * @param tone    Tone.
     * @param isMajor Is major.
     *
     * @return Chord.
     */
    public static int[] getChord(int tone, boolean isMajor)
    {
        int interval = isMajor ? INTERVAL_BIG : INTERVAL_SMALL;

        return new int[]{
            tone,
            tone + INTERVAL_THIRD + interval,
            tone + INTERVAL_FIFTH
        };
    }

    /**
     * Get chord random.
     *
     * @param tone    Tone.
     * @param isMajor Is major.
     *
     * @return Chord.
     */
    public static int[] getChordRandom(int tone, boolean isMajor)
    {
        int interval;
        int[] chord   = null;
        int[] harmony = getHarmony(tone, isMajor);
        int[] chords  = getHarmonyChord(isMajor);

        while (chord == null) {
            interval = ToolNumber.getRandom(harmony.length - 1);
            chord    = getChord(harmony[interval], chords[interval]);
        }

        return chord;
    }
}
