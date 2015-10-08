package com.benheron.game.model;


import android.graphics.Rect;

public class tile extends worldObject {

    protected int TS = 64 ;
    protected boolean solid;
    protected boolean movable;
    protected int column, row;
    protected Rect tileRect;

    public tile(int c, int r, boolean s)
    {
        column = c;
        row = r;
        xPos = c * TS;
        yPos = r * TS+128;

        width = TS;
        height = TS;
        solid = s;

        tileRect = new Rect((int)xPos, (int)yPos, (int)xPos + TS, (int)yPos + TS);

    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean s) {
        solid = s;
    }

    public boolean isMovable() {
        return movable;
    }

    public void setMovable(boolean m) {
        movable = m;
    }

    public boolean onTouch(int touchX, int touchY)
    {
        if (tileRect.contains(touchX, touchY))
        {
            return true;
        }
        return false;
    }

}
