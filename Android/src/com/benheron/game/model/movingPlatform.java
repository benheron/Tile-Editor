package com.benheron.game.model;


import android.graphics.Rect;
import com.benheron.Tile_Run.Assets;

public class movingPlatform extends worldObject {
    private Rect movPlatRect;

    public movingPlatform(int x, int y) {
        xPos = x;
        yPos = y;
        width = 120;
        height = 25;
        objImg = Assets.touchPlat;

        movPlatRect = new Rect((int)xPos, (int)yPos, (int)xPos + width, (int)yPos + height);
    }

    /*public void onTouch(int touchX, int touchY, int lastTouchX, int lastTouchY)
    {
        xPos += lastTouchX - touchX;
        yPos += lastTouchY - lastTouchX;
    }*/

    public boolean onTouch(int touchX, int touchY)
    {
        if (movPlatRect.contains(touchX, touchY))
        {
            return true;
        }
        return false;
    }

    public void updateRect()
    {
        movPlatRect.set((int)xPos, (int)yPos, (int)xPos + width, (int)yPos + height);
    }

}
