package com.benheron.game.model;

public class liftTile extends tile {

    public liftTile(int c, int r, boolean s)
    {
        super(c, r, s);
        solid = true;
        movable = true;
    }
}
