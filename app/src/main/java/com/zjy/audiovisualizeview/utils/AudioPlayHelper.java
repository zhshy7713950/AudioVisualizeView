package com.zjy.audiovisualizeview.utils;

import android.content.Context;
import android.media.MediaPlayer;

import com.zjy.audiovisualize.media.MediaManager;
import com.zjy.audiovisualize.media.MediaManagerListener;
import com.zjy.audiovisualize.utils.LogUtils;
import com.zjy.audiovisualize.visualize.VisualizeCallback;
import com.zjy.audiovisualize.visualize.VisualizerHelper;

public class AudioPlayHelper implements MediaManagerListener {

    private Context context;
    protected MediaManager mediaManager;
    protected VisualizerHelper visualizerHelper;

    public AudioPlayHelper(Context context) {
        this.context = context;
        mediaManager = new MediaManager(context);
        mediaManager.setMediaManagerListener(this);

        visualizerHelper = new VisualizerHelper();
    }

    public void setVisualCount(int spectrumCount){
        visualizerHelper.setVisualCount(spectrumCount);
    }

    public void setVisualizeCallback(VisualizeCallback callback){
        visualizerHelper.setVisualizeCallback(callback);
    }

    /**
     * play with session Id, which visualize need.
     * @param audioSessionId {@link MediaPlayer#getAudioSessionId()}
     */
    public void playWithSessionId(int audioSessionId) {
        try {
            visualizerHelper.setAudioSessionId(audioSessionId);
        } catch (Exception e) {
            LogUtils.e(e.getMessage());
        }
    }

    public void doPlay(final int raw) {
        if (mediaManager != null) {
            mediaManager.doPlay(raw);
        }
    }

    /**
     * start play url file
     */
    public void doPlay(final String filePath) {
        if (mediaManager != null) {
            mediaManager.doPlay(filePath);
        }
    }

    @Override
    public void onPrepare(MediaPlayer mediaPlayer) {
        try {
            int mediaPlayerId = mediaManager.getMediaPlayerId();
            visualizerHelper.setAudioSessionId(mediaPlayerId);
        } catch (Exception e) {
            LogUtils.e(e.getMessage());
        }
    }

    @Override
    public void onError() {

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }

    /**
     * release media player and visualizer
     */
    public void release() {
        if (visualizerHelper != null) {
            visualizerHelper.release();
        }
        if (mediaManager != null) {
            mediaManager.release();
        }
    }
}
