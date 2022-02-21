package com.example.reproductor_de_musica;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class MainActivity3 extends AppCompatActivity {
    VideoView videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        videoview = (VideoView)this.findViewById(R.id.vVideo);
        String path = "android.resource://"+ getPackageName() + "/" + R.raw.video_tiktok;
        videoview.setVideoURI(Uri.parse(path));
        videoview.start();
    }
}