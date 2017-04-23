package dp.leiba.midi.core;

import dp.leiba.midi.generate.bass.*;
import dp.leiba.midi.generate.chord.ChordAccent;
import dp.leiba.midi.generate.chord.ChordBeat;
import dp.leiba.midi.generate.chord.ChordPass;
import dp.leiba.midi.generate.chord.ChordSyncope;
import dp.leiba.midi.generate.lead.LeadLine;
import dp.leiba.midi.generate.tick.TickBass;
import dp.leiba.midi.generate.tick.TickChord;
import dp.leiba.midi.generate.tick.TickLead;
import dp.leiba.midi.theory.Accent;
import dp.leiba.midi.theory.Theory;
import dp.leiba.midi.tool.ToolNumber;

import java.util.ArrayList;

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

        int size = Midi.SIZE_TACT * 4;
        int accts = 8;
        Accent[] accents = Theory.getAccents(_tone, _isMajor, accts);
        ArrayList<TickChord> chords = new ChordSyncope(_tone, _isMajor, accents, size).get();
        ArrayList<TickBass> bass = new BassBeat(_tone, _isMajor, accents, size).get();
        ArrayList<TickLead> leads = new LeadLine(_tone, _isMajor, accents, size, false).get();

        for (TickChord chord : chords) {
            for (int tone : chord.tones) {
                _midi.play(tone, chord.position, chord.ticks);
            }
        }

        for (TickBass bs : bass) {
            _midi.play(bs.tone, bs.position, bs.ticks);
        }

        for (TickLead lead : leads) {
            _midi.play(lead.tone, lead.position, lead.ticks);
        }

        //_midi.play(55, 0, Midi.SIZE_BEAT);

        /*

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
*/
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
