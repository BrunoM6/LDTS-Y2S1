package com.aor.minesweeper.states.ranking;

import com.aor.minesweeper.controller.Controller;
import com.aor.minesweeper.controller.ranking.GameWinController;
import com.aor.minesweeper.model.ranking.GameWin;
import com.aor.minesweeper.states.State;
import com.aor.minesweeper.viewer.Viewer;
import com.aor.minesweeper.viewer.ranking.GameWinViewer;

public class GameWinState extends State<GameWin> {

    public GameWinState(GameWin model) {
        super(model);
    }

    @Override
    protected Viewer<GameWin> getViewer() {
        return new GameWinViewer(getModel());
    }

    @Override
    protected Controller<GameWin> getController() {
        return new GameWinController(getModel());
    }
}
