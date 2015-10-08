package com.benheron.game.state;

import android.view.MotionEvent;
import com.benheron.framework.util.Painter;
import com.benheron.Tile_Run.TR;

public abstract class State {
    public void setCurrentState(State newState) {
        TR.sGame.setCurrentState(newState);
    }

    public abstract void init();

    public abstract void update(float delta);

    public abstract void render(Painter g);

    public abstract boolean onTouch(MotionEvent e, int scaledX, int scaledY);
}