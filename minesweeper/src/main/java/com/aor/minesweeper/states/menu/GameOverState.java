package com.aor.minesweeper.states.menu;

import com.aor.minesweeper.controller.Controller;
import com.aor.minesweeper.controller.menu.GameOverController;
import com.aor.minesweeper.model.menu.GameOver;
import com.aor.minesweeper.states.State;
import com.aor.minesweeper.viewer.Viewer;
import com.aor.minesweeper.viewer.menu.GameOverViewer;

public class GameOverState extends State<GameOver> {
    public GameOverState(GameOver model) {
        super(model);
    }

    @Override
    protected Viewer<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }
}
