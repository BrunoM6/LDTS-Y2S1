package com.aor.minesweeper.states.menu;

import com.aor.minesweeper.controller.Controller;
import com.aor.minesweeper.controller.menu.MainMenuController;
import com.aor.minesweeper.model.menu.MainMenu;
import com.aor.minesweeper.states.State;
import com.aor.minesweeper.viewer.Viewer;
import com.aor.minesweeper.viewer.menu.MainMenuViewer;

public class MainMenuState extends State<MainMenu> {
    public MainMenuState(MainMenu model) {
        super(model);
    }

    @Override
    protected Viewer<MainMenu> getViewer() {
        return new MainMenuViewer(getModel());
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MainMenuController(getModel());
    }
}
