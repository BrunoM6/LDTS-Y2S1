package com.aor.minesweeper.viewer.menu;

import com.aor.minesweeper.gui.GUI;
import com.aor.minesweeper.model.menu.MenuControls;
import com.aor.minesweeper.viewer.Viewer;

public class MenuControlsViewer extends Viewer<MenuControls> {
    public MenuControlsViewer(MenuControls model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawBackground();
        gui.drawText(9, 5, "CONTROLS", "#FFFFFF","#FFD700");

        gui.drawText(6, 12, "> - RIGHT", "#FFFFFF", "#000000");
        gui.drawText(6, 13, "< - LEFT", "#FFFFFF", "#000000");
        gui.drawText(6, 14, "^ - UP", "#FFFFFF", "#000000");
        gui.drawText(6, 15, "; - DOWN", "#FFFFFF", "#000000");
        gui.drawText(6,16,"F - FLAG","#FFFFFF","#000000");
        gui.drawText(6, 17, "Q - QUIT", "#FFFFFF", "#000000");
        gui.drawText(6, 18, "ENTER - SELECT", "#FFFFFF", "#000000");
        gui.drawText(6,25, getModel().getEntry(0),"#FFFFFF",getModel().isSelected(0) ? "#d3d3d3" : "#000000" );

    }
}
