package com.example.user.uiassignment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 4/29/2017.
 */

public class DiscoverRecyclerAdapter extends RecyclerView.Adapter<DiscoverRecyclerAdapter.ViewHolder> {
    private ArrayList<String> exploreList;
    private ArrayList<String> places;
    private Context context;
    private int mode;

    /**
     * @param ctx  context
     * @param mode mode integer value
     */

    public DiscoverRecyclerAdapter(final Context ctx, final int mode) {
        exploreList = new ArrayList<String>();
        exploreList.add("Explore Paris");
        exploreList.add("Explore Rome");
        exploreList.add("Explore London");
        places = new ArrayList<String>();
        places.add("paris");
        places.add("Rome");
        places.add("London");
        this.mode = mode;
        context = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = null;

        if (mode == 2) {
            view = layoutInflater.inflate(R.layout.discover_recycler_grid_row, parent, false);

        } else {
            view = layoutInflater.inflate(R.layout.discover_recycler_row, parent, false);
        }


        ViewHolder viewHolder = new ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (mode == 1) {
            holder.tvExplore.setText(exploreList.get(position));
            holder.tvPlace.setText(places.get(position));
        } else {
            holder.tvPlace.setText(places.get(position));
        }
        if (position == 0) {
            holder.view.setBackgroundResource(R.drawable.discover_recycler_upper_shape);
        } else if (position == places.size() - 1) {
            holder.view.setBackgroundResource(R.drawable.discover_recycler_lower_shape);
        }


    }


    @Override
    public int getItemCount() {
        return places.size();
    }

    /**
     * inner class
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvExplore;
        private TextView tvPlace;
        private View view;

        /**
         * @param itemView vie wfor row
         */
        public ViewHolder(final View itemView) {
            super(itemView);
            if (mode == 1) {
                tvExplore = (TextView) itemView.findViewById(R.id.tv_explore);
                tvPlace = (TextView) itemView.findViewById(R.id.country_name);
                view = itemView;
            } else {
                tvPlace = (TextView) itemView.findViewById(R.id.country_name);
                view = itemView;

            }

        }
    }
}
