package com.aor.minesweeper.states.menu;

import com.aor.minesweeper.controller.Controller;
import com.aor.minesweeper.controller.menu.DifficultyMenuController;
import com.aor.minesweeper.model.menu.DifficultyMenu;
import com.aor.minesweeper.states.State;
import com.aor.minesweeper.viewer.Viewer;
import com.aor.minesweeper.viewer.menu.DifficultyMenuViewer;

public class DifficultyMenuState extends State<DifficultyMenu> {
    public DifficultyMenuState(DifficultyMenu model) {
        super(model);
    }

    @Override
    protected Viewer<DifficultyMenu> getViewer() {
        return new DifficultyMenuViewer(getModel());
    }

    @Override
    protected Controller<DifficultyMenu> getController() {
        return new DifficultyMenuController(getModel());
    }
}
