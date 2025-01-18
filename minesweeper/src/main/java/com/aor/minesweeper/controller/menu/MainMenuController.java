package com.aor.minesweeper.controller.menu;

import com.aor.minesweeper.Game;
import com.aor.minesweeper.controller.Controller;
import com.aor.minesweeper.gui.GUI;
import com.aor.minesweeper.model.menu.DifficultyMenu;
import com.aor.minesweeper.model.menu.MainMenu;
import com.aor.minesweeper.model.menu.MenuControls;
import com.aor.minesweeper.states.menu.DifficultyMenuState;
import com.aor.minesweeper.states.menu.MenuControlsState;

import java.io.IOException;

public class MainMenuController extends Controller<MainMenu> {
    public MainMenuController(MainMenu menu) {
        super(menu);
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
            case QUIT:
                game.setState(null);
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if(getModel().isSelectedControls()) game.setState(new MenuControlsState(new MenuControls()));
                if(getModel().isSelectedRanking()) game.setState(new DifficultyMenuState(new DifficultyMenu(false)));
                if(getModel().isSelectedStart()) game.setState(new DifficultyMenuState(new DifficultyMenu(true)));
                break;
        }
    }
}
