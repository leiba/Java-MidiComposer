package dp.leiba.midi.core;

import dp.leiba.midi.tool.ToolNumber;

import java.util.Arrays;

/**
 * Melody.
 */
public class Melody
{

    /**
     * Midi.
     */
    private Midi _midi;

    /**
     * Tone.
     */
    private int _tone;

    /**
     * Is major.
     */
    private boolean _isMajor;

    /**
     * Is triplet.
     */
    private boolean _isTriplet;

    /**
     * Harmony.
     */
    private int[] _harmony;

    /**
     * Harmony chords.
     */
    private int[] _chords;

    /**
     * Constructor.
     *
     * @param file File.
     */
    public Melody(String file)
        throws Exception
    {
        _midi      = new Midi(file);
        _tone      = Theory.getTone();
        _isMajor   = Theory.getIsMajor();
        _isTriplet = Theory.getIsTriplet();
        _harmony   = Theory.getHarmony(_tone, _isMajor);
        _chords    = Theory.getHarmonyChord(_isMajor);

        int[][] chords = getChords();

        for (int i = 0; i < chords.length; i++) {
            for (int j = 0; j < chords[i].length; j++) {
                _midi.play(chords[i][j], Midi.SIZE_BEAT * i, Midi.SIZE_BEAT);
            }
        }

        _midi.save();
    }

    private void getBass()
    {

    }

    /**
     * Get chords.
     *
     * @return Chords.
     */
    private int[][] getChords()
    {
        int i = 0, note;
        int[][] chords = new int[4][3];
        chords[i++] = Theory.getChord(_tone, _isMajor);

        while (i < chords.length) {
            note = ToolNumber.getRandom(0, _harmony.length - 1);

            if (_chords[note] != Theory.CHORD_NOP) {
                chords[i++] = Theory.getChord(_harmony[note], _chords[note] == Theory.CHORD_MAJOR);
            }
        }

        return chords;

    }

    private void getLead()
    {

    }

    private void getLeadPit()
    {

    }




}
