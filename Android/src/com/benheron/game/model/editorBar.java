package com.benheron.game.model;

import android.graphics.Bitmap;
import com.benheron.Tile_Run.Assets;
import com.benheron.framework.util.Painter;
import com.benheron.framework.util.UIButton;

import java.util.ArrayList;

public class editorBar {

    private EditorItem soTile, plStart, clearTile, goalTile, movPlatIcon, selectIcon, deleteIcon;

    private Bitmap barOvl;

    private int selectedIcon;

    private ArrayList<EditorItem> editorOptions = new ArrayList<EditorItem>();

    public editorBar()
    {
       // xPos = 0;
       // yPos = 0;
        soTile = new EditorItem(365, 25, 64, 64, Assets.solTile, Assets.tiIconDwn);
        plStart = new EditorItem(465, 25, 64, 64, Assets.plIcon, Assets.plIconDwn);
        clearTile = new EditorItem(1065, 25, 64, 64, Assets.clIcon, Assets.clIconDwn);
        goalTile = new EditorItem(565, 25, 64, 64, Assets.goIcon, Assets.goIconDwn);
        movPlatIcon = new EditorItem(665, 25, 64, 64, Assets.tpIcon, Assets.tpIconDwn);
        selectIcon = new EditorItem(1165, 25, 64, 64, Assets.selIcon, Assets.selIconDwn);
        deleteIcon = new EditorItem(1265, 25, 64, 64, Assets.delIcon, Assets.delIconDwn);



        editorOptions.add(soTile);
        editorOptions.add(plStart);
        editorOptions.add(clearTile);
        editorOptions.add(goalTile);
        editorOptions.add(movPlatIcon);
        editorOptions.add(selectIcon);
        editorOptions.add(deleteIcon);



        barOvl = Assets.edBar;
    }

    public void render(Painter g)
    {
        g.drawImage(barOvl, 0, 0);
        for (int i = 0; i < editorOptions.size(); i++)
        {
            editorOptions.get(i).render(g);
        }
    }



    public void onTouch(int touchX, int touchY)
    {
        //make every other option false

        for (int i = 0; i < editorOptions.size(); i++)
        {
           if(editorOptions.get(i).onTouch(touchX, touchY))
           {
               for (int j = 0; j < editorOptions.size(); j++)
               {
                   editorOptions.get(j).setSelected(false);
               }
               editorOptions.get(i).onTouch(touchX, touchY);
           }
        }
    }

    public int getSelectedIcon() {
        for (int i = 0; i < editorOptions.size(); i++)
        {
            if (editorOptions.get(i).isSelected()) {
                return i;
            }
        }
        return -1;
    }

    public void setSelectedIcon(int si) {
        selectedIcon = si;
    }
}
