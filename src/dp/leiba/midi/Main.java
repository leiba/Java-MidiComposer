package dp.leiba.midi;

import dp.leiba.midi.core.Midi;
import dp.leiba.midi.core.Theory;

import javax.sound.midi.*;
import java.io.File;

/**
 * Main.
 */
public class Main
{

    /**
     * Start point.
     *
     * @param args Arguments.
     */
    public static void main(String[] args)
    {
        try {
            Midi midi = new Midi();
            midi.play(5 * 12, 0, Midi.SIZE_TACT);
            midi.play(6 * 12 - 1, Midi.SIZE_TACT, Midi.SIZE_TACT);
            midi.save("C:\\Users\\leiba\\Downloads\\midifile1.mid");





        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
