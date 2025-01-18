package com.aor.minesweeper.model.menu;

import java.util.Arrays;
import java.util.List;

public class DifficultyMenu {
    private final List<String> entries;
    private int currentEntry;
    private  boolean startgame;
    public DifficultyMenu(boolean startgame){
        this.entries = Arrays.asList("Beginner","Intermediate","Expert","Back");
        this.startgame = startgame;
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
    public boolean isSelectedBeginner(){return currentEntry == 0;}
    public boolean isSelectedIntermediate(){return currentEntry == 1;}
    public boolean isSelectedExpert(){return currentEntry == 2;}
    public boolean isSelectedBack(){return currentEntry == 3;}

    public boolean isStartgame(){return startgame;}

    public int getNumberEntries() {
        return this.entries.size();
    }

    public String getEntry(int i) {
        return entries.get(i);
    }
}
