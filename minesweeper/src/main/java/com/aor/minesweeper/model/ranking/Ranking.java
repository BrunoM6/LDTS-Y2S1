package com.aor.minesweeper.model.ranking;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ranking {
    private List<RankingData> ranking;
    public Ranking(){
        this.ranking = Arrays.asList();
    }
    public void addPlayer(RankingData Player){
        if(ranking.size()==10) {
            ranking.remove(9);
        }
        ranking.add(Player);
        ranking.sort(new Comparator<RankingData>() {
            @Override
            public int compare(RankingData o1, RankingData o2) {
                return o1.getScore() - o2.getScore();
            }
        });
    }
    public List<RankingData> getRanking(){return ranking;}
}
