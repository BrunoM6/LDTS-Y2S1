package com.aor.minesweeper.model.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuControls {
    private final List<String> entries;
    private int currentEntry;

    public MenuControls() {
        this.entries = Arrays.asList("Back");
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
    public boolean isSelectedBack(){return isSelected(0);}
    public String getEntry(int i) {
        return entries.get(i);
    }
}
