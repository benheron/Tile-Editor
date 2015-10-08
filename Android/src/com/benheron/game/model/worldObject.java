package com.benheron.game.model;

import android.graphics.*;
import com.benheron.framework.util.Painter;

public class worldObject {
    protected double xPos;
    protected double yPos;
    protected int width;
    protected int height;
    protected Bitmap objImg;


    public void setX(double x)
    {
        xPos = x;
    }

    public double getX()
    {
        return xPos;
    }

    public void setY(double y)
    {
        yPos = y;
    }

    public double getY()
    {
        return yPos;
    }

    public void setWidth(int w)
    {
        width = w;
    }

    public int getWidth()
    {
        return width;
    }

    public void setHeight(int h)
    {
        height = h;
    }

    public int getHeight()
    {
        return height;
    }

    public void render(Painter g)
    {
        if(objImg != null) {
            g.drawImage(objImg, (int) xPos, (int) yPos);
        }
    }


}