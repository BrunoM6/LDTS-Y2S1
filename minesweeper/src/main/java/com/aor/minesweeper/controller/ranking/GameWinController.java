package com.aor.minesweeper.controller.ranking;

import com.aor.minesweeper.Game;
import com.aor.minesweeper.controller.Controller;
import com.aor.minesweeper.gui.GUI;
import com.aor.minesweeper.model.game.board.Board;
import com.aor.minesweeper.model.game.elements.ClockModel;
import com.aor.minesweeper.model.menu.MainMenu;
import com.aor.minesweeper.model.ranking.GameWin;
import com.aor.minesweeper.states.game.GameState;
import com.aor.minesweeper.states.menu.MainMenuState;

import java.io.IOException;
import java.time.Clock;

public class GameWinController extends Controller<GameWin> {

    public GameWinController(GameWin model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action){
            case QUIT :
                game.setState(new MainMenuState(new MainMenu()));
                break;
            case RESTART:
                game.setState(new GameState(new Board(getModel().getWidth(), getModel().getHeight(), getModel().getMines(), new ClockModel(Clock.systemDefaultZone()))));
                break;
        }
    }
}
