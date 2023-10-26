package com.zjy.audiovisualizeview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.zjy.audiovisualize.view.AudioVisualizeView;
import com.zjy.audiovisualizeview.utils.AudioPlayHelper;

public class ReflectVisualizeActivity extends AppCompatActivity {

    private AudioVisualizeView vAudioVisualize;
    private AudioPlayHelper audioPlayHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflect_visualize);

        vAudioVisualize = findViewById(R.id.audio_visualize_view);
        audioPlayHelper = new AudioPlayHelper(this);
        audioPlayHelper.setVisualizeCallback(vAudioVisualize);
        audioPlayHelper.setVisualCount(10);
        audioPlayHelper.doPlay(R.raw.sound);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        audioPlayHelper.release();
    }
}