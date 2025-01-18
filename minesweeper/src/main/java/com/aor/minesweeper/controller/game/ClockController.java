package com.aor.minesweeper.controller.game;

import com.aor.minesweeper.Game;
import com.aor.minesweeper.gui.GUI;
import com.aor.minesweeper.model.game.board.Board;

import java.io.IOException;

public class ClockController extends GameController{
    public ClockController(Board model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

    }

}
