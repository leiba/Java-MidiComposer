package dp.leiba.midi.core;

import javax.sound.midi.*;
import java.io.File;

/**
 * Midi.
 */
public class Midi
{
    /**
     * Sequence.
     */
    private Sequence _sequence;

    /**
     * Track.
     */
    private Track _track;

    /**
     * Constructor.
     */
    public Midi()
        throws Exception
    {
        _sequence = new Sequence(javax.sound.midi.Sequence.PPQ, 24);
        _track    = _sequence.createTrack();
    }

    public void play(int note, int start, int length)
    {

    }

    /**
     * Save.
     *
     * @param file File.
     */
    public void save(String file)
        throws Exception
    {
        MidiSystem.write(_sequence, 1, new File(file));
    }

    /**
     * Set message.
     *
     * @param status Status.
     * @param data1  Data 1.
     * @param data2  Data 2.
     * @param tick   Tick.
     */
    private void _setMessage(int status, int data1, int data2, long tick)
        throws Exception
    {
        ShortMessage message = new ShortMessage();

        message.setMessage(status, data1, data2);
        _track.add(new MidiEvent(message, tick));

    }

    /**
     * Set message.
     *
     * @param type   Type.
     * @param data   Data.
     * @param length Length.
     * @param tick   Tick.
     */
    private void _setMessage(int type, byte[] data, int length, long tick)
        throws Exception
    {
        MetaMessage message = new MetaMessage();

        message.setMessage(type, data, length);
        _track.add(new MidiEvent(message, tick));
    }

}
