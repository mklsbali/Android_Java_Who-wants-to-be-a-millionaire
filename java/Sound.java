package com.example.mythirdapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class Sound extends Service {
    MediaPlayer song;
    public IBinder onBind(Intent arg0) {

        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        song=MediaPlayer.create(this,R.raw.music);
        song.start();
        song.setVolume(100,100);


    }
    public void onDestroy() {
        song.stop();
        song.release();
    }
}
