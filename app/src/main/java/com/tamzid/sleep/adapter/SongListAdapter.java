package com.tamzid.sleep.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tamzid.sleep.R;
import com.tamzid.sleep.model.SongsModel;

import java.util.List;
import java.util.Random;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.MyViewHolder> {
    List<SongsModel> songList;

    public interface OnItemClickListener {
        void onSongItemClick(SongsModel model, MyViewHolder holder);
    }

    private final OnItemClickListener onItemClickListener;


    public SongListAdapter(List<SongsModel> songList, OnItemClickListener onItemClickListener) {
        this.songList = songList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_song_list, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        SongsModel data = songList.get(i);

        viewHolder.title_tv.setText(data.getName() + "");
        viewHolder.song_desc.setText(data.getTime() + " MIN . " + data.getCategory());
        viewHolder.song_icon.setImageResource(data.getIcon());

        viewHolder.bind(data, onItemClickListener, viewHolder);

    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title_tv, song_desc;
        ImageView song_icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            title_tv = itemView.findViewById(R.id.title_tv);
            song_desc = itemView.findViewById(R.id.song_desc);
            song_icon = itemView.findViewById(R.id.song_icon);
        }

        public void bind(final SongsModel item, final OnItemClickListener listener, final MyViewHolder holder) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onSongItemClick(item, holder);
                }
            });
        }
    }
}