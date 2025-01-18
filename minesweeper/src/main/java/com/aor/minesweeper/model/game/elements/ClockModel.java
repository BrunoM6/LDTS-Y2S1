package com.aor.minesweeper.model.game.elements;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

public class ClockModel {
    private Instant start;
    private Clock clock;

    public ClockModel(Clock clock) {
        this.clock = clock;
        this.start = getCurrent();
    }
    public Instant getCurrent() {
        return clock.instant();
    }

    public Instant getStart() {
        return start;
    }

    public Integer getSeconds() {
        return (int) Duration.between(getStart(), getCurrent()).toMillis() / 1000;
    }


}
