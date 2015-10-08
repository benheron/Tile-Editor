package com.benheron.game.model;


import android.graphics.Rect;
import com.benheron.Tile_Run.Assets;

import java.util.ArrayList;

public class player extends worldObject {
    protected boolean onGround;
    private int velX, velY;
    private int grav = 600;
    private int speed = 600;
    private int jumpForce = -800;
    private Rect playerRect;

    private double newX;

    public player(int x, int y)
    {
        xPos = x;
        yPos = y;
        objImg = Assets.plImg;
        velY = 0;
        onGround = false;

        newX = xPos;

        width = 35;
        height = 75;

        playerRect = new Rect((int)xPos, (int)yPos, (int)xPos + width, (int)yPos + height);
    }


    public void update(float delta)
    {

        if (xPos < newX)
        {
            xPos += speed * delta;
        } else if (xPos > newX)
        {
            xPos -= speed * delta;
        }


       if (Math.abs(xPos - newX) < 32)
       {
           newX = xPos;
       }


        yPos += grav * delta;


    }

    public void stop()
    {
        velY = 0;
        newX = xPos;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    public double getNewX() {
        return newX;
    }

    public void setX(int x)
    {
        xPos = x;
        newX = x;
    }

    public void setNewX(double nX) {
        newX = nX;
    }

    public boolean onTouch(int touchX, int touchY)
    {
        if (playerRect.contains(touchX, touchY))
        {
            return true;
        }
        return false;
    }

    public void updateRect()
    {
        playerRect.set((int)xPos, (int)yPos, (int)xPos + width, (int)yPos + height);
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getGrav() {
        return grav;
    }

    public void setGrav(int grav) {
        this.grav = grav;
    }
}
