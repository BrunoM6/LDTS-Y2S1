package com.aor.minesweeper.controller.menu;

import com.aor.minesweeper.Game;
import com.aor.minesweeper.controller.Controller;
import com.aor.minesweeper.gui.GUI;
import com.aor.minesweeper.model.menu.MainMenu;
import com.aor.minesweeper.model.menu.MenuControls;
import com.aor.minesweeper.states.menu.MainMenuState;

import java.io.IOException;
import java.nio.channels.SelectableChannel;

import static com.aor.minesweeper.gui.GUI.ACTION.SELECT;

public class MenuControlsController extends Controller<MenuControls> {
    public MenuControlsController(MenuControls model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action){
            case SELECT:
                game.setState(new MainMenuState(new MainMenu()));
                break;
        }
    }
}
