package com.aor.minesweeper.controller.ranking;

import com.aor.minesweeper.Game;
import com.aor.minesweeper.controller.Controller;
import com.aor.minesweeper.gui.GUI;
import com.aor.minesweeper.model.menu.MainMenu;
import com.aor.minesweeper.model.ranking.Ranking;
import com.aor.minesweeper.states.menu.MainMenuState;

import java.io.IOException;

public class RankingController extends Controller<Ranking> {

    public RankingController(Ranking model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action){
            case QUIT:
                game.setState(new MainMenuState(new MainMenu()));
                break;
        }
    }
}
