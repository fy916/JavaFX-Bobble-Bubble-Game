package com.fy916.bubblebobble.utilities;

import com.fy916.bubblebobble.Main;
import com.fy916.bubblebobble.gaming.world.WorldElements;
import javafx.scene.media.AudioClip;

import java.io.File;


/**
 * The Class handles the sound effect of the game and has been transferred to utilize the JAVAFX {@link javafx.scene.media.AudioClip}. <br/>
 * Realizes Single Responsibility Principle and FACADE Design Pattern. 
 * @author fy916
 * @version 1.0
 */
public class SoundEffect {
    //load the files to the fields
    static AudioClip input_Fruit =FileReader.getAudioClip("fruit");
    static AudioClip input_Land = FileReader.getAudioClip("land");
    static AudioClip input_Death = FileReader.getAudioClip("death");
    static AudioClip input_Shoot = FileReader.getAudioClip("shoot");
    static AudioClip input_Pop =FileReader.getAudioClip("pop");
    static AudioClip input_Bubbled = FileReader.getAudioClip("bubbled");
    static AudioClip input_Jump = FileReader.getAudioClip("jump");
    static AudioClip input_Explode = FileReader.getAudioClip("explode");


    /**
     * A static method to Play the fruit sound when called.
     * @author fy916
     */
    public static void play_Fruit() {
        playAudio(input_Fruit);
    }

    /**
     * A static method to Play the death sound when called.
     * @author fy916
     */
    public static void play_Death() {
        playAudio(input_Death);
    }

    /**
     * A static method to Play the shoot sound when called.
     * @author fy916
     */
    public static void play_Shoot() {
        playAudio(input_Shoot);
    }

    /**
     * A static method to Play the pop sound when called.
     * @author fy916
     */
    public static void play_Pop() {
        playAudio(input_Pop);
    }

    /**
     * A static method to Play the bubbled sound when called.
     * @author fy916
     */
    public static void play_Bubbled() {
        playAudio(input_Bubbled);
    }

    /**
     * A static method to Play the jump sound when called.
     * @author fy916
     */
    public static void play_Jump() {
        playAudio(input_Jump);
    }

    /**
     * A static method to Play the explode sound when called.
     * @author fy916
     */
    public static void play_Explode() {
        playAudio(input_Explode);
    }

    /**
     * A static method to Play the land sound when called.
     * @author fy916
     */
    public static void play_Land() {
        playAudio(input_Land);
    }

    /**
     * A static method to Play the {@link AudioClip}.
     * @param audio the audio to be played
     * @author fy916
     */
    public static void playAudio(AudioClip audio){
        //stop if it is playing
        if (audio.isPlaying()){
            audio.stop();
        }
        audio.play();
    }


}
