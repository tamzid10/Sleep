package com.tamzid.sleep.view;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tamzid.sleep.R;

import java.util.concurrent.TimeUnit;

public class PlayerActivity extends AppCompatActivity implements Runnable {


    int playPosition;
    MediaPlayer mp;
    SeekBar progress_seekbar;
    TextView counting_tv, max_duration_tv;
    ImageView play_pause_btn,prev_btn,forward_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);


        findViewById(R.id.download_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PlayerActivity.this, "coming soon...!", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.fav_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PlayerActivity.this, "coming soon...!", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        play_pause_btn = (ImageView) findViewById(R.id.play_pause_btn);
        prev_btn = (ImageView) findViewById(R.id.prev_btn);
        forward_btn = (ImageView) findViewById(R.id.forward_btn);
        progress_seekbar = (SeekBar) findViewById(R.id.progress_seekbar);

        prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()){
                    mp.seekTo(mp.getCurrentPosition()-15000);
                }
            }
        });

        forward_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()){
                    mp.seekTo(mp.getCurrentPosition()+15000);
                }
            }
        });

        counting_tv = (TextView) findViewById(R.id.counting_tv);
        max_duration_tv = (TextView) findViewById(R.id.max_duration_tv);
        initMediaPlayer();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                try {

                    play_pause_btn.setImageDrawable(getResources().getDrawable(R.drawable.ic_play_button));
                    progress_seekbar.setProgress(0);
                    mp.seekTo(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                initMediaPlayer(note.getLocalPath());

            }
        });
        play_pause_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.pause();
                    play_pause_btn.setImageDrawable(getResources().getDrawable(R.drawable.ic_play_button));
                } else {
                    mp.start();
                    mp.seekTo(progress_seekbar.getProgress());
                    play_pause_btn.setImageDrawable(getResources().getDrawable(R.drawable.ic_pause_button));
                    new Thread(PlayerActivity.this).start();

                }
            }
        });

    }

    private void initMediaPlayer() {
        mp = MediaPlayer.create(this, R.raw.music);
        mp.start();
        mp.seekTo(progress_seekbar.getProgress());
        play_pause_btn.setImageDrawable(getResources().getDrawable(R.drawable.ic_pause_button));
        new Thread(PlayerActivity.this).start();

        progress_seekbar.setMax(mp.getDuration());
        String timeDuration = String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(mp.getDuration()),
                TimeUnit.MILLISECONDS.toSeconds(mp.getDuration()) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(mp.getDuration()))
        );
        max_duration_tv.setText(timeDuration + "");
        progress_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

//                counting_tv.setVisibility(View.VISIBLE);
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {
                int x = progress;
                String currentTimeDuration = String.format("%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(x),
                        TimeUnit.MILLISECONDS.toSeconds(x) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(x))
                );
                counting_tv.setText(currentTimeDuration + "");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (mp != null && mp.isPlaying()) {
                    mp.seekTo(seekBar.getProgress());
                }
            }
        });
    }


    @Override
    public void run() {
        int currentPosition = mp.getCurrentPosition();
        int total = mp.getDuration();
        while (mp != null && mp.isPlaying() && currentPosition < total) {
            try {
                Thread.sleep(50);
                currentPosition = mp.getCurrentPosition();
            } catch (InterruptedException e) {
                return;
            } catch (Exception e) {
                return;
            }
            progress_seekbar.setProgress(currentPosition);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();

        try {
            if (mp.isPlaying()){
                mp.pause();
                play_pause_btn.setImageDrawable(getResources().getDrawable(R.drawable.ic_play_button));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}