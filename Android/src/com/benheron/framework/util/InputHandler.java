package com.benheron.framework.util;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.benheron.game.state.State;
import com.benheron.Tile_Run.TR;

public class InputHandler implements OnTouchListener {
    private State currentState;

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int scaledX = (int) ((event.getX() / v.getWidth()) * TR.GAME_WIDTH);
        int scaledY = (int) ((event.getY() / v.getHeight()) * TR.GAME_HEIGHT);
        return currentState.onTouch(event, scaledX, scaledY);
    }
}

