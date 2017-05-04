package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.uiassignment.R;

/**
 * Created by user on 4/30/2017.
 */

public class MyPostAdapter extends RecyclerView.Adapter<MyPostAdapter.Viewholder> {

    private Context context;

    /**
     *
     * @param ctx context object
     */
    public MyPostAdapter(final Context ctx) {
        context = ctx;
    }

    @Override
    public Viewholder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_post_recycler_row, parent, false);
        Viewholder viewholder = new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(final Viewholder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    /**
     * inner class
     */

    public class Viewholder extends RecyclerView.ViewHolder {
        /**
         *
         * @param itemView view object
         */
        public Viewholder(final View itemView) {
            super(itemView);
        }
    }
}
