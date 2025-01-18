package com.aor.minesweeper.viewer.elements;

import com.aor.minesweeper.gui.GUI;
import com.aor.minesweeper.gui.LanternaGUI;
import com.aor.minesweeper.model.game.board.Board;
import com.aor.minesweeper.model.game.elements.Cell;

public class CellViewer {
    public void draw(Cell cell, int col, int row, GUI gui, Board board){gui.drawCell(cell,col,row,board, board.isSelected(col,row));}
}
