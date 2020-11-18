package com.tamzid.sleep.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.tamzid.sleep.R;
import com.tamzid.sleep.model.HomeOptionMenuModel;

import java.util.List;

public class HomeOptionMenuAdapter extends RecyclerView.Adapter<HomeOptionMenuAdapter.MyView> {

    private List<HomeOptionMenuModel> list;
    Context context;
    public class MyView extends RecyclerView.ViewHolder {
        TextView title_tv;
        ImageView option_image;
        LinearLayout root_layout;

        public MyView(View view) {
            super(view);

            title_tv = (TextView) view.findViewById(R.id.title_tv);
            option_image = (ImageView) view.findViewById(R.id.option_image);
            root_layout = (LinearLayout) view.findViewById(R.id.root_layout);
        }
    }

    public HomeOptionMenuAdapter(List<HomeOptionMenuModel> horizontalList, Context context) {
        this.list = horizontalList;
        this.context = context;
    }

    // Override onCreateViewHolder which deals
    // with the inflation of the card layout
    // as an item for the RecyclerView.
    @Override
    public MyView onCreateViewHolder(ViewGroup parent,
                                     int viewType) {

        // Inflate item.xml using LayoutInflator
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_home_option_menu, parent, false);

        // return itemView
        return new MyView(itemView);
    }


    @Override
    public void onBindViewHolder(final MyView holder,
                                 final int position) {

        // Set the text of each item of
        holder.title_tv.setText(list.get(position).getTitle());
        holder.option_image.setImageResource(list.get(position).getIcon_id());

        holder.root_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position!=0){
                    Toast.makeText(context, "coming soon...!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Override getItemCount which Returns
    // the length of the RecyclerView.
    @Override
    public int getItemCount() {
        return list.size();
    }
}