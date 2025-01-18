package com.aor.minesweeper.states.menu;

import com.aor.minesweeper.controller.Controller;
import com.aor.minesweeper.controller.menu.MenuControlsController;
import com.aor.minesweeper.model.menu.MenuControls;
import com.aor.minesweeper.states.State;
import com.aor.minesweeper.viewer.Viewer;
import com.aor.minesweeper.viewer.menu.MenuControlsViewer;

public class MenuControlsState extends State<MenuControls> {
    public MenuControlsState(MenuControls model) {
        super(model);
    }

    @Override
    protected Viewer<MenuControls> getViewer() {
        return new MenuControlsViewer(getModel());
    }

    @Override
    protected Controller<MenuControls> getController() {
        return new MenuControlsController(getModel());
    }
}
