package com.aor.minesweeper.controller.game;

import com.aor.minesweeper.Game;
import com.aor.minesweeper.gui.GUI;
import com.aor.minesweeper.model.game.board.Board;
import com.aor.minesweeper.model.game.elements.Cell;
import com.aor.minesweeper.model.menu.GameOver;
import com.aor.minesweeper.model.ranking.GameWin;
import com.aor.minesweeper.states.menu.GameOverState;
import com.aor.minesweeper.states.ranking.GameWinState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class CellController extends GameController{
    public CellController(Board model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
            switch (action){
                case SELECT :
                    if(getModel().isFirst_time())start_Board();
                    getModel().getCurrentCell().setRevealed(true);
                    if(getModel().getCurrentCell().isMine()) {
                        getModel().getCurrentCell().playExplosionSound();
                        game.setState(new GameOverState(new GameOver(getModel().getHeight(), getModel().getWidth(), getModel().getNumMines())));
                    }
                    if(getModel().getCurrentCell().isZero()) {
                        revealAdjacent(getModel().getCurrent_row(), getModel().getCurrent_col());
                    }
                    if(win())game.setState(new GameWinState(new GameWin(getModel().getClock().getSeconds(), getModel().getWidth(), getModel().getHeight(), getModel().getNumMines())));
                    break;
                case FLAG:
                    if(getModel().getCurrentCell().isFlagged())getModel().getCurrentCell().setFlagged(false);
                    else if(canFlag())getModel().getCurrentCell().setFlagged(true);
                    break;
            }
    }
    public boolean win(){
        int num_reveal=0;
        for (int row = 0; row < getModel().getHeight(); row++) {
            for (int col = 0; col < getModel().getHeight(); col++) {
                if(getModel().getCell(row,col).isRevealed() & !getModel().getCell(row,col).isMine())num_reveal++;
            }
        }
        return (num_reveal == (getModel().getWidth()*getModel().getHeight()-getModel().getNumMines()));
    }
    public void start_Board(){
        getModel().setFirst_time(false);
        getModel().placeMines();
        getModel().calculateAdjacentMines();
    }
    public void revealAdjacent(int row, int col) {
        if (!getModel().isValidPosition(row,col)) {
            return;
        }
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (getModel().isValidPosition(newRow,newCol)) {
                    getModel().getCell(newRow,newCol).setRevealed(true);
                }
            }
        }
    }
    public boolean canFlag(){
        return getModel().countFlags() < getModel().getNumMines();
    }


}

