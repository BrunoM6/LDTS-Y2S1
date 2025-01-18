package com.aor.minesweeper.states.ranking;

import com.aor.minesweeper.controller.Controller;
import com.aor.minesweeper.controller.ranking.RankingController;
import com.aor.minesweeper.model.ranking.Ranking;
import com.aor.minesweeper.states.State;
import com.aor.minesweeper.viewer.Viewer;
import com.aor.minesweeper.viewer.ranking.RankingViewer;

public class RankingState extends State<Ranking> {
    public RankingState(Ranking model) {
        super(model);
    }

    @Override
    protected Viewer<Ranking> getViewer() {
        return new RankingViewer(getModel());
    }

    @Override
    protected Controller<Ranking> getController() {
        return new RankingController(getModel());
    }
}
