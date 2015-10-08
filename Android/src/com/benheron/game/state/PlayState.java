package com.benheron.game.state;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;
import com.benheron.framework.util.Painter;

import com.benheron.Tile_Run.Assets;
import com.benheron.Tile_Run.TR;


import com.benheron.game.model.player;
import com.benheron.game.model.map;

public class PlayState extends State {

    private map gameMap;
    private Bitmap bgimg;
    private boolean touch = false;

    public PlayState(map playMap)
    {
        gameMap = playMap;
    }

    @Override
    public void init() {
       // mainChar = new player(90, 200);
        //gameMap = new map(5, 6, false);
        bgimg = Assets.bgimage;
    }

    @Override
    public void update(float delta) {
        gameMap.update(delta);
    }

    @Override
    public void render(Painter g) {
        g.drawImage(bgimg, 0 , 0);
        gameMap.render(g);
    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if (e.getAction() == MotionEvent.ACTION_UP)
        {
            gameMap.onPlayTouch(scaledX, scaledY);
            touch = false;
        }



        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            //gameMap.onPlayTouchDwn(scaledX, scaledY);
            touch = true;
        }

        if (touch)
        {
            //gameMap.onPlayTouchDwn(scaledX, scaledY);
        }
        return true;
    }

}
