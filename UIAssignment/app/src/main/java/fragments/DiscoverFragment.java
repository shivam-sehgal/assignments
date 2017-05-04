package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.user.uiassignment.DiscoverRecyclerAdapter;
import com.example.user.uiassignment.MainActivity;
import com.example.user.uiassignment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    private DiscoverRecyclerAdapter recyclerAdapter;
    private Toolbar toolbar;
    private ImageButton ibtnGrid;
    private ImageButton ibtnList;
    private boolean isGrid = false;
    private boolean isLinear = true;

    /**
     * empty constructor
     */
    public DiscoverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler);
        recyclerAdapter = new DiscoverRecyclerAdapter(getActivity(), 1);
        toolbar = ((MainActivity) getActivity()).getToolbar();
        ibtnGrid = (ImageButton) toolbar.findViewById(R.id.button_third);
        ibtnList = (ImageButton) toolbar.findViewById(R.id.button_second);
        ibtnGrid.setOnClickListener(this);
        ibtnList.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerAdapter);

        return view;
    }


    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.button_third:
                DiscoverRecyclerAdapter discoverRecyclerAdapter;
                if (!isGrid) {
                    isGrid = true;
                    discoverRecyclerAdapter = new DiscoverRecyclerAdapter(getActivity(), 2);
                    recyclerView.setAdapter(discoverRecyclerAdapter);
                    isLinear = false;
                    recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
                }
                break;
            case R.id.button_second:
                if (!isLinear) {
                    discoverRecyclerAdapter = new DiscoverRecyclerAdapter(getActivity(), 1);
                    isLinear = true;
                    isGrid = false;
                    recyclerView.setAdapter(discoverRecyclerAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                }
                break;
            default:
                break;


        }
    }
}
