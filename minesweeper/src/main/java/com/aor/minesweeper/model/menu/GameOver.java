package com.aor.minesweeper.model.menu;

import com.aor.minesweeper.gui.GUI;

import com.aor.minesweeper.model.ranking.RankingData;
import com.aor.minesweeper.model.soundeffects.SoundEfffects;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GameOver {
    private final List<String> entries;
    private int currentEntry;
    private int row;
    private int col;
    private int mines;

    public GameOver(int row,int col , int mines){
        this.entries = Arrays.asList("RESTART", "MENU");
        this.row = row;
        this.col = col;
        this.mines = mines;
    }
    public void nextEntry(){
        currentEntry++;
        if(currentEntry > entries.size()-1){
            currentEntry = 0;
        }
    }
    public void previousEntry(){
        currentEntry--;
        if(currentEntry<0){
            currentEntry = entries.size()-1;
        }
    }
    public boolean isSelected(int i) {
        return currentEntry == i;
    }
    public int getNumberEntries() {
        return this.entries.size();
    }

    public String getEntry(int i) {
        return entries.get(i);
    }
    public boolean isSelectedMenu(){return isSelected(1);}
    public boolean isSelectRestart(){return isSelected(0);}
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public int getMines(){
        return mines;
    }

}
