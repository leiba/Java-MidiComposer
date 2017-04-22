package dp.leiba.midi.core;

import dp.leiba.midi.tool.ToolNumber;

import java.util.Arrays;

/**
 * TheoryGen.
 */
public class TheoryGen
{

    public static final int NOP = -1;

    /**
     * Get chords.
     *
     * @param tone         Tone.
     * @param isMajor      Is major.
     * @param count        Count chords.
     * @param harmony      Harmony from theory.
     * @param harmonyChord Chords from theory.
     *
     * @return Chords.
     */
    public static int[][] getChords(int tone, boolean isMajor, int count, int[] harmony, int[] harmonyChord)
    {
        int i = 0, note;
        int[] chord;
        int[][] chords = new int[count][];
        chords[i++] = Theory.getChord(tone, isMajor);

        while (i < chords.length) {
            note  = ToolNumber.getRandom(harmony.length - 1);
            chord = Theory.getChord(harmony[note], harmonyChord[note]);

            if (chord != null) {
                chords[i++] = chord;
            }
        }

        return chords;
    }

    /**
     * Get lead.
     *
     * @param chords  Complete chords.
     * @param harmony Harmony from theory.
     * @param count   Points count.
     *
     * @return Lead.
     */
    public static int[] getLead(int[][] chords, int[] harmony, int count)
    {
        int i, note;
        int beat   = count / chords.length;
        int[] lead = new int[count];

        for (i = 0; i < lead.length; i++) {
            if (i % beat == 0) {
                note = chords[i / beat][0];
            } else if (!ToolNumber.getIs()) {
                note = harmony[ToolNumber.getRandom(harmony.length - 1)];
            } else {
                note = NOP;
            }

            lead[i] = note != NOP ? (note + Theory.TONES * 2) : note;
        }

        return lead;
    }

    /**
     * Get bass.
     *
     * @param chords Chords.
     *
     * @return Bass.
     */
    public static int[] getBass(int[][] chords)
    {
        int i;
        int[] bass = new int[chords.length];

        for (i = 0; i < chords.length; i++) {
            bass[i] = chords[i][0] - Theory.TONES;
        }

        return bass;
    }
}
