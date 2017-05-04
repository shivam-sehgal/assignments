package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.uiassignment.R;

import adapters.RequestRecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class RequestMapFragment extends Fragment {
    private RecyclerView recyclerView;
    private RequestRecyclerAdapter requestRecyclerAdapter;

    /**
     * empty constructor
     */
    public RequestMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_request_map, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.req_recycler);


        return view;
    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        requestRecyclerAdapter = new RequestRecyclerAdapter(getActivity());
        recyclerView.setAdapter(requestRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
}
