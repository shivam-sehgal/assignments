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

public class RequestRecyclerAdapter extends RecyclerView.Adapter<RequestRecyclerAdapter.ViewHolder> {
    private Context context;

    /**
     * @param ctx context object
     */
    public RequestRecyclerAdapter(final Context ctx) {
        context = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.request_recycler_row, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


    }

    @Override
    public int getItemCount() {
        return 4;
    }

    /**
     * inner class
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        /**
         *
         * @param itemView view object
         */
        public ViewHolder(final View itemView) {
            super(itemView);
        }
    }
}
