package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.uiassignment.R;

import adapters.MyPostAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPostFragment extends Fragment {
    private RecyclerView recyclerView;
    private MyPostAdapter myPostAdapter;


    /**
     * empty constructor
     */
    public MyPostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_post, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.my_post_recycler);
        myPostAdapter = new MyPostAdapter(getActivity());
        recyclerView.setAdapter(myPostAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

}
