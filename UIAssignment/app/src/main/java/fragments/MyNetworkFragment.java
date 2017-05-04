package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.uiassignment.R;

import adapters.NetworkRecyclerAdapter;

/**
 * network fragment
 */
public class MyNetworkFragment extends Fragment {

    private RecyclerView recyclerView;
    private NetworkRecyclerAdapter networkRecyclerAdapter;

    /**
     * empty constructor
     */
    public MyNetworkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_network, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.my_network_recycler);
        networkRecyclerAdapter = new NetworkRecyclerAdapter(getActivity());
        recyclerView.setAdapter(networkRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }


}
