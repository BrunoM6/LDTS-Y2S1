package com.aor.minesweeper.controller.menu;

import com.aor.minesweeper.Game;
import com.aor.minesweeper.controller.Controller;
import com.aor.minesweeper.gui.GUI;
import com.aor.minesweeper.model.game.board.Board;
import com.aor.minesweeper.model.game.elements.ClockModel;
import com.aor.minesweeper.model.menu.MainMenu;
import com.aor.minesweeper.model.menu.GameOver;
import com.aor.minesweeper.states.game.GameState;
import com.aor.minesweeper.states.menu.MainMenuState;

import java.io.IOException;
import java.time.Clock;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action){
            case LEFT :
                getModel().previousEntry();
                break;
            case RIGHT:
                getModel().nextEntry();
                break;
            case SELECT:
                if(getModel().isSelectedMenu())game.setState(new MainMenuState(new MainMenu()));
                if(getModel().isSelectRestart())game.setState(new GameState(new Board(getModel().getCol(), getModel().getRow(), getModel().getMines(),new ClockModel(Clock.systemDefaultZone()))));
        }
    }

}
