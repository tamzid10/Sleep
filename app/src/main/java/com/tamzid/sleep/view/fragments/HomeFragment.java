package com.tamzid.sleep.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tamzid.sleep.R;
import com.tamzid.sleep.adapter.HomeOptionMenuAdapter;
import com.tamzid.sleep.adapter.SongListAdapter;
import com.tamzid.sleep.model.HomeOptionMenuModel;
import com.tamzid.sleep.model.SongsModel;
import com.tamzid.sleep.view.PlayerActivity;
import com.tamzid.sleep.view.SongDetailsActivity;
import com.tomergoldst.tooltips.ToolTip;
import com.tomergoldst.tooltips.ToolTipsManager;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    public static final String TAG = "HomeFragment";
//
//    HomeFragmentListener homeFragmentListener;

//    public interface HomeFragmentListener {
//        void onEmailLoginBackButtonClick();
//
//        void onEmailLoginLoginButtonClick(String email);
//
//    }

    ArrayList<HomeOptionMenuModel> source;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    HomeOptionMenuAdapter homeOptionMenuAdapter;
    LinearLayoutManager HorizontalLayout;

    ToolTipsManager mToolTipsManager;
    ImageView lock_view;
    Button start_btn;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        note.setLocalPath(note.getLocalPath().replace("/media/media_files/note_audios","");

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        try {
//            emailLoginFragmentListener = (EmailLoginFragmentListener) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(context.toString() + " must implement OnImageClickListener");
//        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        mToolTipsManager = new ToolTipsManager();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        lock_view = (ImageView) view.findViewById(R.id.lock_view);
        start_btn = (Button) view.findViewById(R.id.start_btn);


        RecyclerViewLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(RecyclerViewLayoutManager);
        AddItemsToRecyclerViewArrayList();
        homeOptionMenuAdapter = new HomeOptionMenuAdapter(source,getActivity());
        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(HorizontalLayout);
        recyclerView.setAdapter(homeOptionMenuAdapter);

        lock_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ToolTip.Builder builder = new ToolTip.Builder(getActivity(), lock_view, (RelativeLayout) view.findViewById(R.id.bannar_layout), "unlock premium content", ToolTip.POSITION_RIGHT_TO);
                builder.setBackgroundColor(getResources().getColor(R.color.app_background_color));
                mToolTipsManager.show(builder.build());

            }
        });

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getActivity(), PlayerActivity.class);
                startActivity(intent);
            }
        });

        songList(view);
        return view;

    }


    public void AddItemsToRecyclerViewArrayList()
    {
        // Adding items to ArrayList
        source = new ArrayList<HomeOptionMenuModel>();
        source.add(new HomeOptionMenuModel("All",R.drawable.ic_option_all));
        source.add(new HomeOptionMenuModel("My",R.drawable.ic_option_my));
        source.add(new HomeOptionMenuModel("Anxious",R.drawable.ic_option_anxious));
        source.add(new HomeOptionMenuModel("Sleep",R.drawable.ic_option_sleep));
        source.add(new HomeOptionMenuModel("Kids",R.drawable.ic_option_kids));

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
