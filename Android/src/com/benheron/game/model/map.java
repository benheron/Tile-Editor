package com.benheron.game.model;

import android.graphics.Rect;
import android.util.Log;
import com.benheron.framework.util.Painter;
import com.benheron.game.model.tile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class map {
    private int width;
    private int height;

    private int offsetY;

    private boolean editMode;
    protected Rect mapRect;
    private player mainChar;
    private boolean itemSelected = false;
    private int itemIndex = -1;

    private ArrayList<ArrayList<tile>> tileMap = new ArrayList<ArrayList<tile>>();
    private ArrayList<movingPlatform> movPlats = new ArrayList<movingPlatform>();

    public map(int w, int h, boolean e)
    {


        width = w;
        height = h;
        editMode = e;
        offsetY = 128;

        mapRect = new Rect(0, 128, 1920, 1080);
        if (e)
        {
            createEditorMap();
        } else {
            createMap();
        }


    }


    private void createMap()
    {
        int testData[][] =
                {
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

                };

        width = 30;
        height = 17;


        for (int i=0;i<width;i++)
        {
            tileMap.add(new ArrayList<tile>());
            //tileMap.get(i) = new ArrayList<tile>();
            for (int j=0;j<height;j++)
            {
               // tile t = new tile(i,j,false);
                tile t;

                switch (testData[i][j])
                {
                    case 0:
                        //air tiles
                        t = new tile(i, j, false);
                        break;
                    case 1:
                        //generic block
                        t = new genTile(i, j, true);
                        break;
                    case 2:
                        t = new exitTile(i, j, true);
                        break;
                    default:
                        t = new tile(i, j, false);
                        break;
                }

                tileMap.get(i).add(t);
            }
        }
    }

    private void createEditorMap()
    {
        mainChar = new player(90, 64*25);

        int testData[][] =
                {
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

                };


        for (int i=0;i<width;i++)
        {
            tileMap.add(new ArrayList<tile>());
            //tileMap.get(i) = new ArrayList<tile>();
            for (int j=0;j<height;j++)
            {
                // tile t = new tile(i,j,false);
                tile t;

                switch (testData[i][j])
                {
                    case 0:
                        //air tiles
                        t = new tile(i, j, false);
                        break;
                    case 1:
                        //generic block
                        t = new genTile(i, j, true);
                        break;
                    case 2:
                        t = new exitTile(i, j, true);
                        break;
                    default:
                        t = new tile(i, j, false);
                        break;
                }

                tileMap.get(i).add(t);
            }
        }
    }

    public void render(Painter g)
    {
        for (int i=0;i<width;i++)
        {
            for(int j=0;j<height;j++)
            {
                tileMap.get(i).get(j).render(g);
            }
        }
        for (int k = 0;k< movPlats.size();k++)
        {
            movPlats.get(k).render(g);
        }

        mainChar.render(g);

    }

    public void onTouch(int touchX, int touchY, int tt) {
        if (mapRect.contains(touchX, touchY)) {
            if (editMode) {
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        if (tileMap.get(i).get(j).onTouch(touchX, touchY)) {
                            tile t;
                            switch (tt) {
                                case 0:
                                    t = new tile(i, j, false);
                                    tileMap.get(i).set(j, t);
                                    break;
                                case 1:
                                    t = new genTile(i, j, true);
                                    tileMap.get(i).set(j, t);
                                    break;
                                case 2:
                                    t = new exitTile(i, j, true);
                                    tileMap.get(i).set(j, t);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
                int a;
                int b;
                switch (tt)
                {
                    case 3:

                        movingPlatform mp = new movingPlatform(touchX-60, touchY-12);
                        movPlats.add(mp);
                        break;
                    case 7:
                        a = mainChar.getWidth() / 2;
                        b = mainChar.getHeight() / 2;
                        mainChar.setX(touchX - a);
                        mainChar.setY(touchY - b);
                        mainChar.updateRect();
                        break;
                    case 8:
                        if (!itemSelected)
                        {
                            for (int i = 0;i< movPlats.size();i++)
                            {
                                if (movPlats.get(i).onTouch(touchX, touchY))
                                {
                                    itemSelected = true;
                                    itemIndex = i;
                                }

                            }
                            if (!itemSelected)
                            {
                                if (mainChar.onTouch(touchX, touchY))
                                {
                                    itemSelected = true;
                                    itemIndex = -1;
                                }
                            }
                        }

                        if (itemSelected)
                        {
                            if (itemIndex == -1)
                            {
                                a = mainChar.getWidth() / 2;
                                b = mainChar.getHeight() / 2;
                                mainChar.setX(touchX - a);
                                mainChar.setY(touchY - b);
                                mainChar.updateRect();
                            } else {
                                movPlats.get(itemIndex).setX(touchX-60);
                                movPlats.get(itemIndex).setY(touchY-12);
                                movPlats.get(itemIndex).updateRect();
                            }
                        }
                        break;
                    case 9:
                        for (int i = 0;i< movPlats.size();i++) {
                            if (movPlats.get(i).onTouch(touchX, touchY)) {
                                movPlats.remove(i);
                            }
                        }
                        break;
                    default:
                        break;
                }

            }
        }
    }

    public void onPlayTouch(int touchX, int touchY)
    {
        mainChar.setNewX(touchX);
        itemIndex = -1;

    }

    public void onPlayTouchDwn(int touchX, int touchY)
    {
        for (int i = 0;i< movPlats.size();i++)
        {
            if (movPlats.get(i).onTouch(touchX, touchY))
            {
                itemIndex = i;
            }

        }

        if (itemIndex > -1)
        {
            movPlats.get(itemIndex).setX(touchX-60);
            movPlats.get(itemIndex).setY(touchY-12);
            movPlats.get(itemIndex).updateRect();
        }
    }

    public void onUp()
    {
        itemSelected = false;
        itemIndex = -1;
    }

    public void update(float dt)
    {
        mainChar.update(dt);

        /*
        double ps = mainChar.getY();
        int gs = mainChar.getGrav();
        ps +=gs *dt;

        boolean toupdate = true;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++)
            {
                if (tileMap.get(i).get(j).isSolid())
                {
                    if (intersect(mainChar, tileMap.get(i).get(j)))
                    {
                        toupdate = false;
                    }
                }

            }

        }

        if (toupdate)
        {
            mainChar.setY(ps);
        } else {
           // int g = -mainChar.getGrav();
           // mainChar.setGrav(g);
        }*/

        int mx = (int)mainChar.getX()/64;
        int my = (int)mainChar.getY()/64;


        for (int i = mx - 1; i < mx + 2; i++) {
            for (int j = my - 1; j < my + 2; j++) {
                if (((i > -1) && (i < width))
                    && ((j > -1) && (j < height)))
                {
                    if (intersect(mainChar, tileMap.get(i).get(j))) {
                        if (tileMap.get(i).get(j).isSolid()) {

                            int ty = (int) tileMap.get(i).get(j).getY() - mainChar.getHeight();


                            mainChar.setY(ty);

                        }


                    }
                }
            }
        }

        for (int i = 0;i< movPlats.size();i++)
        {
            if (intersect(mainChar, movPlats.get(i)))
            {
                mainChar.setY(movPlats.get(i).getY()- mainChar.getHeight());
            }

        }




    }


    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean e) {
        editMode = e;
    }

    private boolean intersect(worldObject object1, worldObject object2)
    {
        int t1x = (int)object1.getX() ;
        int t1y = (int)object1.getY();
        int t1w = object1.getWidth();
        int t1h = object1.getHeight();

        int t2x = (int)object2.getX();
        int t2y = (int)object2.getY();
        int t2w = object2.getWidth();
        int t2h = object2.getHeight();


        if (t1x + t1w < t2x ||
                t1x > t2x + t2w ||
                t1y + t1h < t2y ||
                t1y > t2y + t2h)
        {
            //Log.w("TR", "NO INTERSECTION");
            return false;
        }
        //Log.w("TR", "I AM INTERSECTING");
        return true;
    }
}
