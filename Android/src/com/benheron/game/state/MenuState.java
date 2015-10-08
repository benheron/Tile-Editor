package com.benheron.game.state;

import android.view.MotionEvent;
import com.benheron.Tile_Run.TR;
import com.benheron.framework.util.Painter;
import com.benheron.framework.util.UIButton;
import com.benheron.Tile_Run.Assets;
import com.benheron.game.model.grid;
import com.benheron.game.model.map;

public class MenuState extends State {
    private UIButton playButton, editorButton;
    private grid edgrid;

    @Override
    public void init() {
        //button width = 250;
        //button height = 100;

        int gw = TR.GAME_WIDTH;
        int gh = TR.GAME_HEIGHT;

        int psx = gw/2 - 125;
        int psy1 = gh/2 - 75;
        int psy2 = gh/2 + 75;

        playButton = new UIButton(psx, psy1, psx+250, psy1+100, Assets.play, Assets.playDwn);
        editorButton = new UIButton(psx, psy2, psx+250, psy2+100, Assets.edit, Assets.editDwn);
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public void render(Painter g) {
        g.drawImage(Assets.welscreen, 0, 0);
        //playButton.render(g);
        editorButton.render(g);

    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            //playButton.onTouchDown(scaledX, scaledY);
            editorButton.onTouchDown(scaledX, scaledY);
        }
        if (e.getAction() == MotionEvent.ACTION_UP) {
             if (editorButton.isPressed(scaledX, scaledY))
            {
                editorButton.cancel();
                setCurrentState(new EditorState());
            } else {
                //playButton.cancel();
                editorButton.cancel();
            }
        }
        return true;
    }
}