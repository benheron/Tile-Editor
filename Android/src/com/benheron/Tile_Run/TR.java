package com.benheron.Tile_Run;

import android.app.Activity;
import android.os.Bundle;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.view.WindowManager;

public class TR extends Activity {
    public static final int GAME_WIDTH = 1920;
    public static final int GAME_HEIGHT = 1080;
    public static GameView sGame;
    public static AssetManager assets;

    private static SharedPreferences prefs;
    private static final String highScoreKey = "highScoreKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = getPreferences(Activity.MODE_PRIVATE);
        assets = getAssets();
        sGame = new GameView(this, GAME_WIDTH, GAME_HEIGHT);
        setContentView(sGame);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

}
