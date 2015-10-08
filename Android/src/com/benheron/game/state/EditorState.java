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


import com.benheron.framework.util.UIButton;
import com.benheron.game.model.*;


public class EditorState extends State {

    private grid edGrid;
    private Bitmap bgimg;
    private map editorMap;
    private editorBar edbarOverlay;
    private int selectedItem;
    private boolean touch;
    private UIButton testButton, saveButton;

    private EditorItem solTile, plStart, clearTile;


    @Override
    public void init() {
        bgimg = Assets.bgimage;
        selectedItem = 0;

        //create editor bar to choose items
        edbarOverlay = new editorBar();

        //initialise empty map
        editorMap = new map(30, 15, true);

        testButton = new UIButton(846, 0, 966, 120, Assets.testBtn, Assets.testBtnDwn);
        saveButton = new UIButton(1465, 25, 1593, 89, Assets.saveBtn, Assets.saveBtnDwn);

        //800/25 = 32
        //450/25 = 18
        // initialise grid
        edGrid = new grid(30, 15, 64, 0, 128);

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(Painter g) {
        g.drawImage(bgimg, 0 , 0);
        editorMap.render(g);
        edGrid.render(g);
        edbarOverlay.render(g);
        testButton.render(g);
        saveButton.render(g);

    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if (e.getAction() == MotionEvent.ACTION_UP) {
            edbarOverlay.onTouch(scaledX, scaledY);
            touch = false;
            editorMap.onUp();

            if (e.getAction() == MotionEvent.ACTION_UP) {
                if (testButton.isPressed(scaledX, scaledY)) {
                    testButton.cancel();
                    setCurrentState(new PlayState(editorMap));
                } else if (saveButton.isPressed(scaledX, scaledY))
                {
                    saveButton.cancel();
                    setCurrentState(new EditorState());
                } else {
                    testButton.cancel();
                    saveButton.cancel();
                }
            }


        }

        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            selectedItem = edbarOverlay.getSelectedIcon();
            touch = true;
            editMap(scaledX, scaledY);

            switch (edbarOverlay.getSelectedIcon()) {
                case 4:
                    editorMap.onTouch(scaledX, scaledY, 3);
                    break;
                case 6:
                    editorMap.onTouch(scaledX, scaledY, 9);
                    break;
                default:
                    break;
            }
            testButton.onTouchDown(scaledX, scaledY);
            saveButton.onTouchDown(scaledX, scaledY);
        }

        if (touch)
        {
            if (e.getAction() == MotionEvent.ACTION_MOVE) {
                editMap(scaledX, scaledY);
            }
        }


        return true;
    }

    private void editMap(int scaledX, int scaledY)
    {
        switch (edbarOverlay.getSelectedIcon())
        {
            case 0:
                editorMap.onTouch(scaledX, scaledY, 1);

                break;
            case 1:
                editorMap.onTouch(scaledX, scaledY, 7);
                break;
            case 2:
                editorMap.onTouch(scaledX, scaledY, 0);
                break;
            case 3:
                editorMap.onTouch(scaledX, scaledY, 2);
                break;
            case 5:
                editorMap.onTouch(scaledX, scaledY, 8);
                break;
            default:
                break;
        }
    }
}
