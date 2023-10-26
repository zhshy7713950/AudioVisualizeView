package com.zjy.audiovisualize.media;

import android.media.MediaPlayer;

/**
 * Date: 2020/11/24
 * Author: Yang
 * Describe: listener of media manager
 */
public interface MediaManagerListener {

    void onPrepare(MediaPlayer mediaPlayer);

    void onError();

    void onCompletion(MediaPlayer mediaPlayer);
}
