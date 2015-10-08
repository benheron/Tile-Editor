package com.benheron.game.model;


import android.graphics.Bitmap;
import android.graphics.Rect;
import com.benheron.framework.util.Painter;


public class EditorItem extends worldObject {
    private Rect itemRect;
    private boolean selected = false;
    private Bitmap itImg, selImg;

    public EditorItem(int x, int y, int width, int height, Bitmap img, Bitmap sImg)
    {
        xPos = x;
        yPos = y;

        itemRect = new Rect(x, y, x + width, y + height);
        itImg = img;
        selImg = sImg;
    }

    public boolean onTouch(int touchX, int touchY)
    {
        if (itemRect.contains(touchX, touchY))
        {
            selected = true;
            return true;
            /*
            if (selected) {
                    selected = false;
                } else {
                    selected = true;
            }*/

        }
        return false;
    }

    public void render(Painter g)
    {
        Bitmap curImg = selected ? selImg : itImg;
        g.drawImage(curImg, itemRect.left, itemRect.top, itemRect.width(), itemRect.height());
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean s) {
        selected = s;
    }
}
