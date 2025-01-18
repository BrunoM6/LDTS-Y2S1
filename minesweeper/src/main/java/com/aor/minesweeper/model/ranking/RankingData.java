package com.aor.minesweeper.model.ranking;

public class RankingData {
    private final String name;
    private final int score;
    public RankingData(String name, int score){
        this.name = name;
        this.score = score;
    }
    public String getName(){return name;}
    public int getScore(){return score;}
}
