package com.aor.minesweeper.model.menu;

import com.aor.minesweeper.gui.GUI;

import java.util.Arrays;
import java.util.List;

public class MainMenu {
    private final List<String> entries;
    private int currentEntry;
    public MainMenu(){
            this.entries =  Arrays.asList("New Game","Controls","Ranking","Exit");
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
    public boolean isSelectedExit() {
        return isSelected(3);
    }
    public boolean isSelectedRanking(){return isSelected(2);}
    public boolean isSelectedControls(){return isSelected(1);}
    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public String getEntry(int i) {
        return entries.get(i);
    }
}
