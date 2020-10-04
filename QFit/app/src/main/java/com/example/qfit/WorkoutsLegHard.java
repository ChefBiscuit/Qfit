package com.example.qfit;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class WorkoutsLegHard extends Activity{
    /** Called when the activity is first created. */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_workouts_leg_hard);

        VideoView videoView = findViewById(R.id.videoLegHard);
        String videoPath = "raw/body_ups.mp4";
        videoView.setVideoPath(videoPath);


        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


    }
}
