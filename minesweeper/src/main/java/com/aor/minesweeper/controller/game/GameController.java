package com.aor.minesweeper.controller.game;

import com.aor.minesweeper.Game;
import com.aor.minesweeper.controller.Controller;
import com.aor.minesweeper.gui.GUI;
import com.aor.minesweeper.model.game.board.Board;

import java.io.IOException;

public abstract class GameController extends Controller<Board> {

    public GameController(Board model) {
        super(model);
    }

}
