package com.tamzid.sleep.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tamzid.sleep.R;
import com.tamzid.sleep.adapter.SongListAdapter;
import com.tamzid.sleep.model.SongsModel;
import com.tamzid.sleep.view.SongDetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class SongListFragment extends Fragment {
    public static final String TAG = "SongListFragment";
//
    SongListFragmentListener songListFragmentListener;

    public interface SongListFragmentListener {
        void onBackButtonClickSongListFragment();

    }

    TextView title_tv;
    ImageView back_btn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            songListFragmentListener = (SongListFragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnImageClickListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_song_list, container, false);

        title_tv=(TextView) view.findViewById(R.id.title_tv);
        back_btn=(ImageView) view.findViewById(R.id.back_btn);
        String title = getArguments().getString("title");
        title_tv.setText(title+"");
        songList(view);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songListFragmentListener.onBackButtonClickSongListFragment();            }
        });

        return view;
    }






    public void songList(View view){
        RecyclerView songListRecyclerView;
        SongListAdapter songListAdapter;
        List<SongsModel> songsModelList = new ArrayList<SongsModel>();


        songListRecyclerView = view.findViewById(R.id.song_list_recycler_view);
        songListAdapter = new SongListAdapter(songsModelList, new SongListAdapter.OnItemClickListener() {
            @Override
            public void onSongItemClick(SongsModel model, SongListAdapter.MyViewHolder holder) {
                Intent intent = new Intent(getActivity(), SongDetailsActivity.class);
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager manager = new GridLayoutManager(getActivity(), 2);
        songListRecyclerView.setLayoutManager(manager);
        songListRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
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
