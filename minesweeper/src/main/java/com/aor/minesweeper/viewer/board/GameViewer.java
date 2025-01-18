package com.aor.minesweeper.viewer.board;

import com.aor.minesweeper.gui.GUI;
import com.aor.minesweeper.model.game.board.Board;
import com.aor.minesweeper.model.game.elements.Cell;
import com.aor.minesweeper.viewer.Viewer;
import com.aor.minesweeper.viewer.elements.CellViewer;
import com.aor.minesweeper.viewer.elements.ClockViewer;

public class GameViewer extends Viewer<Board> {

    public GameViewer(Board model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {

        drawElements(gui, new CellViewer());
        drawClock(gui,getModel(), new ClockViewer());
        gui.drawText(0,29,"Q-MENU","#FFFFFF", "#FFD700");
    }
    private void drawElements(GUI gui, CellViewer viewer){
        gui.drawBackground();
        for (int row = 0 ; row < getModel().getHeight(); row++) {
            for (int col = 0; col < getModel().getWidth(); col++) {
                drawCells(gui,col,row,viewer);
            }
        }
    }
    private void drawCells(GUI gui, int col , int row, CellViewer viewer){
        viewer.draw(getModel().getCell(row,col),col,row, gui,getModel());
    }
    private void drawClock(GUI gui,Board board ,ClockViewer viewer){
        viewer.draw(board.getClock(),board,gui);
    }

}