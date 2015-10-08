package com.benheron.Tile_Run;

import java.io.IOException;
import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.AudioManager;
import android.media.SoundPool;

public class Assets {
    private static SoundPool soundPool;

    public static Bitmap play, playDwn, edit, editDwn, welscreen, solTile, plImg, bgimage, plIcon, plIconDwn, edBar, tiIconDwn
    ,clIcon, clIconDwn, exTile, goIcon, goIconDwn, touchPlat, tpIcon, tpIconDwn, selIcon, selIconDwn, delIcon, delIconDwn, saveBtn, saveBtnDwn
            , testBtn, testBtnDwn;


    public static int hitID, onJumpID;

    public static void load() {

        welscreen = loadBitmap("welscrn.png", false);

        edit = loadBitmap("editorbtn2.png", true);
        editDwn = loadBitmap("editorbtn.png", true);
        play = loadBitmap("playbtn2.png", true);
        playDwn = loadBitmap("playbtn.png", true);

        bgimage = loadBitmap("bgim.png", true);
        solTile = loadBitmap("groundtile.png", true);
        exTile = loadBitmap("extile.png", true);
        touchPlat = loadBitmap("movPlat.png", true);


        plImg = loadBitmap("player.png", true);
        plIcon = loadBitmap("playIcon.png", true);
        plIconDwn = loadBitmap("playIconDwn.png", true);
        tiIconDwn = loadBitmap("grnIconDwn.png", true);
        clIcon = loadBitmap("clearIcon.png", true);
        clIconDwn = loadBitmap("clearIconDwn.png", true);
        goIcon = loadBitmap("goalIcon.png", true);
        goIconDwn = loadBitmap("goalIconDwn.png", true);
        tpIcon = loadBitmap("tpicon.png", true);
        tpIconDwn = loadBitmap("tpiconDwn.png", true);
        selIcon = loadBitmap("selectIcon.png", true);
        selIconDwn = loadBitmap("selectIconDwn.png", true);
        delIcon = loadBitmap("deleteIcon.png", true);
        delIconDwn = loadBitmap("deleteIconDwn.png", true);
        saveBtn = loadBitmap("saveBtn.png", true);
        saveBtnDwn = loadBitmap("saveBtnDwn.png", true);
        testBtn = loadBitmap("testBtn.png", true);
        testBtnDwn = loadBitmap("testBtnDwn.png", true);


        edBar = loadBitmap("editbar2.png", true);
    }

    private static Bitmap loadBitmap(String filename, boolean transparency) {
        InputStream inputStream = null;
        try {
            inputStream = TR.assets.open(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Options options = new Options();
        if (transparency) {
            options.inPreferredConfig = Config.ARGB_8888;
        } else {
            options.inPreferredConfig = Config.RGB_565;
        }
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null,
                options);
        return bitmap;
    }

    private static int loadSound(String filename) {
        int soundID = 0;
        if (soundPool == null) {
            soundPool = new SoundPool(25, AudioManager.STREAM_MUSIC, 0);
        }
        try {
            soundID = soundPool.load(TR.assets.openFd(filename),
                    1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return soundID;
    }

    public static void playSound(int soundID) {
        soundPool.play(soundID, 1, 1, 1, 0, 1);
    }
}