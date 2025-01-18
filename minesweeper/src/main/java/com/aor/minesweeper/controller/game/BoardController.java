package com.aor.minesweeper.controller.game;

import com.aor.minesweeper.Game;
import com.aor.minesweeper.gui.GUI;
import com.aor.minesweeper.model.game.board.Board;
import com.aor.minesweeper.model.game.elements.Cell;
import com.aor.minesweeper.model.menu.MainMenu;
import com.aor.minesweeper.states.menu.MainMenuState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class BoardController extends GameController {
    private final CellController cellController;
    private final ClockController clockController;

    public BoardController(Board model) {
        super(model);
        this.cellController = new CellController(model);
        this.clockController = new ClockController(model);
    }
    public void selectCellLeft(){
        getModel().setCurrent_col(getModel().getCurrent_col()-1);
    }
    public void selectCellRight(){
        getModel().setCurrent_col(getModel().getCurrent_col()+1);
    }
    public void selectCellUp(){
        getModel().setCurrent_row(getModel().getCurrent_row()-1);
    }
    public void selectCellDown(){
        getModel().setCurrent_row(getModel().getCurrent_row()+1);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        switch (action){
            case QUIT :
                game.setState(new MainMenuState(new MainMenu()));
                break;
            case UP:
                if(getModel().isValidPosition(getModel().getCurrent_row()-1, getModel().getCurrent_col()))selectCellUp();
                break;
            case DOWN:
                if(getModel().isValidPosition(getModel().getCurrent_row()+1, getModel().getCurrent_col()))selectCellDown();
                break;
            case RIGHT:
                if(getModel().isValidPosition(getModel().getCurrent_row(), getModel().getCurrent_col()+1))selectCellRight();
                break;
            case LEFT:
                if(getModel().isValidPosition(getModel().getCurrent_row(), getModel().getCurrent_col()-1))selectCellLeft();
                break;
            default:
                cellController.step(game, action, time);
                clockController.step(game, action, time);
                break;
        }
    }
}
