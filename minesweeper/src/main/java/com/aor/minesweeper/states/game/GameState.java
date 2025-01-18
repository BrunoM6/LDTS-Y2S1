package com.aor.minesweeper.states.game;

import com.aor.minesweeper.controller.Controller;
import com.aor.minesweeper.controller.game.BoardController;
import com.aor.minesweeper.controller.game.GameController;
import com.aor.minesweeper.model.game.board.Board;
import com.aor.minesweeper.states.State;
import com.aor.minesweeper.viewer.Viewer;
import com.aor.minesweeper.viewer.board.GameViewer;

import java.awt.geom.Area;

public class GameState extends State<Board> {

    public GameState(Board model) {
        super(model);
    }

    @Override
    protected Viewer<Board> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Board> getController() {
        return new BoardController(getModel());
    }
}
