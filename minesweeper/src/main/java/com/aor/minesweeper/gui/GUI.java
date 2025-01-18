package com.aor.minesweeper.gui;

import com.aor.minesweeper.model.game.board.Board;
import com.aor.minesweeper.model.game.elements.Cell;
import com.aor.minesweeper.model.game.elements.ClockModel;

import java.io.IOException;

public interface GUI {

    void drawCell(Cell cell, int col, int row,Board board, boolean isselectd);
    ACTION getNextAction() throws IOException;


    void drawClock(ClockModel clock, Board board);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;

    void drawText(int x , int y, String menu, String BackColor,String ForeColor);
    void drawBackground();
    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, FLAG,RESTART};

}
