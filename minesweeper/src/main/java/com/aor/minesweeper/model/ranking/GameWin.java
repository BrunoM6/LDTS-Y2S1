package com.aor.minesweeper.model.ranking;

public class GameWin {
    private final int score;
    private final int width;
    private final int height;
    private final int mines;
    private String name;
    public GameWin(int score,int width,int height,int mines){
        this.score = score;
        this.height = height;
        this.width = width;
        this.mines = mines;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getMines() {
        return mines;
    }

    public int getWidth() {
        return width;
    }

    public void setName(){}
    public void setRanking(){}
}
