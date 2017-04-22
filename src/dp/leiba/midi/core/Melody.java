package dp.leiba.midi.core;

import dp.leiba.midi.tool.ToolNumber;

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

        int[][] chords = TheoryGen.getChords(_tone, _isMajor, 4 * 20, _harmony, _chords);
        int[] lead = TheoryGen.getLead(chords, _harmony, 32 * 20);
        int[] bass = TheoryGen.getBass(chords);

        for (int i = 0; i < chords.length; i++) {
            for (int j = 0; j < chords[i].length; j++) {
                _midi.play(chords[i][j], Midi.SIZE_TACT * i, Midi.SIZE_TACT);
            }
        }

        for (int i = 0; i < bass.length; i++) {
            _midi.play(bass[i], Midi.SIZE_TACT * i + (Midi.SIZE_BEAT * 0), Midi.SIZE_BEAT);
            if (ToolNumber.getIs()) _midi.play(bass[i], Midi.SIZE_TACT * i + (Midi.SIZE_BEAT * 1), Midi.SIZE_BEAT);
            if (ToolNumber.getIs()) _midi.play(bass[i], Midi.SIZE_TACT * i + (Midi.SIZE_BEAT * 2), Midi.SIZE_BEAT);
            if (ToolNumber.getIs()) _midi.play(bass[i], Midi.SIZE_TACT * i + (Midi.SIZE_BEAT * 3), Midi.SIZE_BEAT);
        }

        for (int i = 0; i < lead.length; i++) {
            if (lead[i] != TheoryGen.NOP) {
                //System.out.println(lead[i]);
                _midi.play(lead[i], Midi.SIZE_BEAT / 2 * i, Midi.SIZE_CELL * 3);
            }
        }

        _midi.save();
    }

    private void getBass()
    {

    }

    private void getLead()
    {

    }

    private void getLeadPit()
    {

    }




}
