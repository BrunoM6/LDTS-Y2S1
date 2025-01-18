package com.aor.minesweeper.viewer.ranking;

import com.aor.minesweeper.gui.GUI;
import com.aor.minesweeper.model.ranking.GameWin;
import com.aor.minesweeper.viewer.Viewer;

public class GameWinViewer extends Viewer<GameWin> {

    public GameWinViewer(GameWin model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawBackground();
        gui.drawText(13, 5, "YOU WON","#FFFFFF", "#FFD700");
        String text = Integer.toString(getModel().getScore());
        gui.drawText(6, 10, "YOUR SCORE: "+text,"#FFFFFF", "#FFD700");
        gui.drawText(6, 11, "YOUR NAME: ","#FFFFFF", "#FFD700");
        gui.drawText(0,29,"Q-MENU","#FFFFFF", "#FFD700");
        gui.drawText(27,29,"R-RESTART","#FFFFFF", "#FFD700");
    }
}
