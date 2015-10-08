package com.benheron.game.model;

import android.graphics.Color;
import com.benheron.framework.util.Painter;
import android.graphics.*;


public class grid extends worldObject{
    private int rows, columns;
    private int sectSize;

    public grid (int c, int r, int ts, int ox, int oy)
    {
        width = c;
        height = r;
        sectSize = ts;
        xPos = ox;
        yPos = oy;
    }

    public void render(Painter g)
    {
        g.setColor(Color.WHITE);
        for (int i = 0; i < width; i++)
        {
            g.drawLine((int)(i*sectSize+xPos), 128, (int)(i*sectSize+xPos), 1080);
        }

        for (int j = 0; j < height; j++)
        {
            g.drawLine(0, (int)(j*sectSize+yPos), 1920, (int)(j*sectSize+yPos));
        }
    }

}
