package com.aor.minesweeper.viewer.elements;

import com.aor.minesweeper.gui.GUI;
import com.aor.minesweeper.model.game.board.Board;
import com.aor.minesweeper.model.game.elements.ClockModel;


public class ClockViewer {
    public void draw(ClockModel clock, Board board, GUI gui) {
        gui.drawClock(clock, board);
    }
}
