package com.benheron.game.model;


import com.benheron.Tile_Run.Assets;

public class genTile extends tile {

    public genTile(int c, int r, boolean s)
    {
        super(c, r, s);
        objImg = Assets.solTile;
        solid = true;
    }
}
