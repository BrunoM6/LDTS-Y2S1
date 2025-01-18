package com.aor.minesweeper.viewer.ranking;

import com.aor.minesweeper.gui.GUI;
import com.aor.minesweeper.model.ranking.Ranking;
import com.aor.minesweeper.model.ranking.RankingData;
import com.aor.minesweeper.viewer.Viewer;

public class RankingViewer extends Viewer<Ranking> {
    public RankingViewer(Ranking model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawBackground();
        gui.drawText(9, 5, "RANKING","#FFFFFF", "#FFD700");
        gui.drawText(0, 29, "Q-BACK","#FFFFFF", "#FFD700");
        int i = 0;
        for(RankingData player: getModel().getRanking()){
            gui.drawText(10,5+i, player.getName(), "#FFFFFF","#000000");
            gui.drawText(14,5+i, Integer.toString(player.getScore()),"#FFFFFF","#000000");
            i++;
        }
    }

}
