package com.aor.minesweeper.viewer.menu;

import com.aor.minesweeper.gui.GUI;
import com.aor.minesweeper.model.menu.GameOver;
import com.aor.minesweeper.viewer.Viewer;

public class GameOverViewer extends Viewer<GameOver> {
    public GameOverViewer(GameOver model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawBackground();
        gui.drawText(13, 5, "GAMEOVER","#FFFFFF", "#FFD700");
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    10+i*10,
                    27,
                    getModel().getEntry(i),
                    "#FFFFFF",
                    getModel().isSelected(i) ? "#d3d3d3" : "#000000");
    }
}
