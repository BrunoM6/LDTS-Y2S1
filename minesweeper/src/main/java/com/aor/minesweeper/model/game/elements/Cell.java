package com.aor.minesweeper.model.game.elements;

import com.aor.minesweeper.model.soundeffects.SoundEfffects;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Cell {
    private boolean isMine;
    private boolean isFlagged;
    private boolean isRevealed;
    private int adjacentMines;
    private SoundEfffects soundEfffects;
    public Cell() {
        this.isMine = false;
        this.isRevealed = false;
        this.adjacentMines = 0;
        this.isFlagged = false;
        this.soundEfffects = new SoundEfffects("resources/sounds/bomb_sound.wav");
    }
    public void playExplosionSound() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        soundEfffects.playSound();
    }
    public Cell(boolean isMine, int adjacentMines) {
        this.isMine = isMine;
        this.isRevealed = false;
        this.adjacentMines = adjacentMines;
    }
    public boolean isMine() {
        return isMine;
    }
    public void setMine(boolean isMine) {
        this.isMine = isMine;
    }
    public boolean isRevealed() {
        return isRevealed;
    }
    public boolean isZero() {return adjacentMines==0;}
    public void setRevealed(boolean isRevealed) {
        this.isRevealed = isRevealed;
    }
    public int getAdjacentMines() {
        return adjacentMines;
    }
    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }
    public boolean isFlagged() {
        return this.isFlagged;
    }
    public void setFlagged(boolean flag) {
        this.isFlagged = flag;
    }
}