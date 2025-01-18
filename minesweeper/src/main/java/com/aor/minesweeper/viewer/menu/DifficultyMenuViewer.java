package com.aor.minesweeper.viewer.menu;

import com.aor.minesweeper.gui.GUI;
import com.aor.minesweeper.model.menu.DifficultyMenu;
import com.aor.minesweeper.viewer.Viewer;

public class DifficultyMenuViewer extends Viewer<DifficultyMenu> {
    public DifficultyMenuViewer(DifficultyMenu model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawBackground();
        gui.drawText(9, 5, "DIFFICULTY", "#FFFFFF", "#FFD700");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    10,
                    7+i,
                    getModel().getEntry(i),
                    "#FFFFFF",
                    getModel().isSelected(i) ? "#d3d3d3" : "#000000");
    }

}
