package com.example.perez.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity
    implements View.OnClickListener
{
    private String GOOGLE_API_KEY = "AIzaSyAZup_ih6jD1GkiF9EKIFnOxur460lUTrk";
    private String YOUTUBE_VIDEO_ID = "8411lsU1ArA";
    private String YOUTUBE_PLAYLIST = "PLdcj9-UG0IhS_XhoEMT6CdeMaaOsgsQbX";

    private Button btnPlayVideo;
    private Button btnPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);
        btnPlaylist = (Button) findViewById(R.id.btnPlaylist);

        btnPlayVideo.setOnClickListener(this);
        btnPlaylist.setOnClickListener(this);
        //.this is to create one single onClickListener method for both BUTTONS

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
    Intent intent = null;

        switch (v.getId()){
            //Switch statement for when each button is tapped (Find by id)
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
                break;
            case R.id.btnPlaylist:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this,GOOGLE_API_KEY, YOUTUBE_PLAYLIST);
                break;

        }
        if(intent !=null){
            startActivity(intent);
        }

    }
}
