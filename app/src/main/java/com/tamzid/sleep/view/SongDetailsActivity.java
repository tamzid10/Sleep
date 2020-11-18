package com.tamzid.sleep.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.tamzid.sleep.R;
import com.tamzid.sleep.adapter.SongListAdapter;
import com.tamzid.sleep.model.SongsModel;

import java.util.ArrayList;
import java.util.List;

public class SongDetailsActivity extends AppCompatActivity {

    AppBarLayout appBarLayout;
    Button play_btn;
    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);

        back_btn = (ImageView) findViewById(R.id.back_btn);
        appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        play_btn = (Button) findViewById(R.id.play_btn);
        play_btn.measure(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        final int targetHeight = play_btn.getMeasuredHeight();
        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SongDetailsActivity.this,PlayerActivity.class);
                startActivity(intent);
            }
        });
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (Math.abs(verticalOffset)-appBarLayout.getTotalScrollRange() == 0)
                {
                    //  Collapsed
                    play_btn.animate().translationY(targetHeight)
//                            .alpha(0.0f)
//                            .setDuration(300)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    play_btn.setVisibility(View.GONE);
                                }
                            });
                    ;



                }
                else
                {
                    //Expanded
                    play_btn.setVisibility(View.VISIBLE);
                    play_btn.animate().translationY(0)
//                            .alpha(0.0f)
//                            .setDuration(300)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);

                                }
                            });

                }
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        findViewById(R.id.download_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SongDetailsActivity.this, "coming soon...!", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.fav_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SongDetailsActivity.this, "coming soon...!", Toast.LENGTH_SHORT).show();
            }
        });


        songList();
    }

    public void songList(){
        RecyclerView songListRecyclerView;
        SongListAdapter songListAdapter;
        List<SongsModel> songsModelList = new ArrayList<SongsModel>();


        songListRecyclerView = findViewById(R.id.song_list_recycler_view);
        songListAdapter = new SongListAdapter(songsModelList, new SongListAdapter.OnItemClickListener() {
            @Override
            public void onSongItemClick(SongsModel model, SongListAdapter.MyViewHolder holder) {
                Intent intent = new Intent(SongDetailsActivity.this, SongDetailsActivity.class);
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager manager = new GridLayoutManager(SongDetailsActivity.this, 2);
        songListRecyclerView.setLayoutManager(manager);
        songListRecyclerView.addItemDecoration(new DividerItemDecoration(SongDetailsActivity.this, LinearLayoutManager.VERTICAL));
        songListRecyclerView.setAdapter(songListAdapter);

        songsModelList.add(new SongsModel("Night Island", R.drawable.ic_song_1, "45", "SLEEP MUSIC", "Ease the mind into a restful night’s sleep with these deep, amblent tones.", 250, 651));
        songsModelList.add(new SongsModel("Sweet Sleep", R.drawable.ic_song_2, "30", "SLEEP MUSIC", "Ease the mind into a restful night’s sleep with these deep, amblent tones.", 150, 300));
        songsModelList.add(new SongsModel("Good Night", R.drawable.ic_song_3, "50", "SLEEP MUSIC", "Ease the mind into a restful night’s sleep with these deep, amblent tones.", 310, 521));
        songsModelList.add(new SongsModel("Moon Clouds  ", R.drawable.ic_song_4, "25", "SLEEP MUSIC", "Ease the mind into a restful night’s sleep with these deep, amblent tones.", 360, 601));

        songsModelList.add(new SongsModel("Night Island", R.drawable.ic_song_1, "45", "SLEEP MUSIC", "Ease the mind into a restful night’s sleep with these deep, amblent tones.", 250, 651));
        songsModelList.add(new SongsModel("Sweet Sleep", R.drawable.ic_song_2, "30", "SLEEP MUSIC", "Ease the mind into a restful night’s sleep with these deep, amblent tones.", 150, 300));
        songsModelList.add(new SongsModel("Good Night", R.drawable.ic_song_3, "50", "SLEEP MUSIC", "Ease the mind into a restful night’s sleep with these deep, amblent tones.", 310, 521));
        songsModelList.add(new SongsModel("Moon Clouds  ", R.drawable.ic_song_4, "25", "SLEEP MUSIC", "Ease the mind into a restful night’s sleep with these deep, amblent tones.", 360, 601));

        songsModelList.add(new SongsModel("Night Island", R.drawable.ic_song_1, "45", "SLEEP MUSIC", "Ease the mind into a restful night’s sleep with these deep, amblent tones.", 250, 651));
        songsModelList.add(new SongsModel("Sweet Sleep", R.drawable.ic_song_2, "30", "SLEEP MUSIC", "Ease the mind into a restful night’s sleep with these deep, amblent tones.", 150, 300));
        songsModelList.add(new SongsModel("Good Night", R.drawable.ic_song_3, "50", "SLEEP MUSIC", "Ease the mind into a restful night’s sleep with these deep, amblent tones.", 310, 521));
        songsModelList.add(new SongsModel("Moon Clouds  ", R.drawable.ic_song_4, "25", "SLEEP MUSIC", "Ease the mind into a restful night’s sleep with these deep, amblent tones.", 360, 601));

        songListAdapter.notifyDataSetChanged();
    }



}