package com.aor.minesweeper;

import com.aor.minesweeper.gui.LanternaGUI;
import com.aor.minesweeper.model.menu.MainMenu;
import com.aor.minesweeper.states.menu.MainMenuState;
import com.aor.minesweeper.states.State;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;

    private int FPS = 10;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(36, 30);
        this.state = new MainMenuState(new MainMenu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException, UnsupportedAudioFileException, LineUnavailableException {
        new Game().start();
    }

    public LanternaGUI getGui() {
        return gui;
    }

    public void setState(State state) {
        this.state = state;
    }
    public void setFPS(int FPS) {
        this.FPS = FPS;
    }

    private void start() throws IOException, URISyntaxException, FontFormatException, UnsupportedAudioFileException, LineUnavailableException {

        while (this.state != null) {
            int frameTime = 1000 / FPS;
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException ignored) {
            }
        }

        gui.close();
    }
}
