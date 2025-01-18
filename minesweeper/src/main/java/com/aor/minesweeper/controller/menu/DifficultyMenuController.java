package com.aor.minesweeper.controller.menu;

import com.aor.minesweeper.Game;
import com.aor.minesweeper.controller.Controller;
import com.aor.minesweeper.gui.GUI;
import com.aor.minesweeper.model.game.board.Board;
import com.aor.minesweeper.model.game.elements.ClockModel;
import com.aor.minesweeper.model.menu.DifficultyMenu;
import com.aor.minesweeper.model.menu.MainMenu;
import com.aor.minesweeper.model.ranking.Ranking;
import com.aor.minesweeper.states.game.GameState;
import com.aor.minesweeper.states.menu.MainMenuState;
import com.aor.minesweeper.states.ranking.RankingState;

import java.io.IOException;
import java.time.Clock;

public class DifficultyMenuController extends Controller<DifficultyMenu> {
    public DifficultyMenuController(DifficultyMenu model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if(getModel().isSelectedBack()) game.setState(new MainMenuState(new MainMenu()));
                if(getModel().isSelectedBeginner() & getModel().isStartgame()) game.setState(new GameState(new Board(9,9,10,new ClockModel(Clock.systemDefaultZone()))));
                if(getModel().isSelectedIntermediate() & getModel().isStartgame()) game.setState(new GameState(new Board(16,16,40,new ClockModel(Clock.systemDefaultZone()))));
                if(getModel().isSelectedExpert() & getModel().isStartgame()) game.setState(new GameState(new Board(30,16,99,new ClockModel(Clock.systemDefaultZone()))));
                if(getModel().isSelectedBeginner() & !getModel().isStartgame() ) game.setState(new RankingState(new Ranking()));
                if(getModel().isSelectedIntermediate() & !getModel().isStartgame() ) game.setState(new RankingState(new Ranking()));
                if(getModel().isSelectedExpert() & !getModel().isStartgame() ) game.setState(new RankingState(new Ranking()));
        }
    }
}
