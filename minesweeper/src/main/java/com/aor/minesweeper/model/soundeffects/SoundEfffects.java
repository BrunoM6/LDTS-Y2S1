package com.aor.minesweeper.model.soundeffects;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SoundEfffects {
    private final String filePath;
    public SoundEfffects(String filePath){
        this.filePath = filePath;
    };

    public void playSound() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }
}
