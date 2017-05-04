package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.uiassignment.R;

/**
 * Created by user on 5/2/2017.
 */

public class NetworkRecyclerAdapter extends RecyclerView.Adapter<NetworkRecyclerAdapter.ViewHolder> {
    private Context context;

    /**
     * @param ctx context object
     */
    public NetworkRecyclerAdapter(final Context ctx) {
        context = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.network_recycler_row, null);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (position == 0) {

            holder.view.setBackgroundResource(R.drawable.discover_recycler_upper_shape);
        } else if (position == 3) {
            holder.view.setBackgroundResource(R.drawable.discover_recycler_lower_shape);
        } else {
            holder.view.setBackgroundResource(R.drawable.normal_recycler_row_shape);
        }


    }

    @Override
    public int getItemCount() {
        return 4;
    }

    /**
     * inner class
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;

        /**
         *
         * @param itemView view object
         */
        public ViewHolder(final View itemView) {
            super(itemView);
            view = itemView;
        }
    }
}
