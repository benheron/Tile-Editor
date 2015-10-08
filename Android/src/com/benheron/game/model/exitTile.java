package com.benheron.game.model;

import com.benheron.Tile_Run.Assets;

public class exitTile extends tile {

    public exitTile(int c, int r, boolean s)
    {
        super(c, r, s);
        objImg = Assets.exTile;
    }
}