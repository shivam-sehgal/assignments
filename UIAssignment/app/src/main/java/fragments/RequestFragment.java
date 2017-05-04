package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.user.uiassignment.R;

import adapters.MyRequestViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class RequestFragment extends Fragment implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private Button btnPost;
    private Button btnMaps;
    private Button btnNetwork;
    private MyRequestViewPagerAdapter myRequestViewPagerAdapter;

    /**
     * empty constructor
     */
    public RequestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_request, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.my_req_viewpager);
        btnPost = (Button) view.findViewById(R.id.post_btn);
        btnMaps = (Button) view.findViewById(R.id.map_btn);
        btnNetwork = (Button) view.findViewById(R.id.network_btn);

        btnMaps.setOnClickListener(this);
        btnPost.setOnClickListener(this);
        btnNetwork.setOnClickListener(this);
        viewPager.addOnPageChangeListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myRequestViewPagerAdapter = new MyRequestViewPagerAdapter(getChildFragmentManager(), getActivity());
        myRequestViewPagerAdapter.addData(new MyNetworkFragment(), "Posts");
        myRequestViewPagerAdapter.addData(new RequestMapFragment(), "Maps");
        myRequestViewPagerAdapter.addData(new MyNetworkFragment(), "Networks");
        viewPager.setAdapter(myRequestViewPagerAdapter);
        selectButtonMap();


    }

    /**
     * on clicking map tab
     */
    public void selectButtonMap() {
        viewPager.setCurrentItem(1);
        btnMaps.setBackgroundResource(R.drawable.middle_selected_shape);
        btnMaps.setTextColor(getResources().getColor(R.color.white));
        btnPost.setBackgroundResource(R.drawable.first_unselected_tab_shape);
        btnNetwork.setBackgroundResource(R.drawable.second_unselected_tab_shape);
        btnPost.setTextColor(getResources().getColor(R.color.greenyBlue));
        btnNetwork.setTextColor(getResources().getColor(R.color.greenyBlue));
    }

    /**
     * on clicking post tab
     */
    public void selectButtonPost() {
        viewPager.setCurrentItem(0);
        btnPost.setBackgroundResource(R.drawable.first_selected_tab_shape);
        btnPost.setTextColor(getResources().getColor(R.color.white));
        btnMaps.setBackgroundResource(R.drawable.middle_unselected_shape);
        btnNetwork.setBackgroundResource(R.drawable.second_unselected_tab_shape);
        btnMaps.setTextColor(getResources().getColor(R.color.greenyBlue));
        btnNetwork.setTextColor(getResources().getColor(R.color.greenyBlue));
    }

    /**
     * on clicking network tab
     */
    public void selectButtonNetwork() {
        viewPager.setCurrentItem(2);
        btnNetwork.setBackgroundResource(R.drawable.second_selected_tab_shape);
        btnNetwork.setTextColor(getResources().getColor(R.color.white));
        btnMaps.setBackgroundResource(R.drawable.middle_unselected_shape);
        btnPost.setBackgroundResource(R.drawable.first_unselected_tab_shape);
        btnMaps.setTextColor(getResources().getColor(R.color.greenyBlue));
        btnPost.setTextColor(getResources().getColor(R.color.greenyBlue));
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.map_btn:
                selectButtonMap();
                break;
            case R.id.post_btn:
                selectButtonPost();
                break;
            case R.id.network_btn:
                selectButtonNetwork();
                break;
            default:
                break;


        }

    }

    @Override
    public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(final int position) {
        if (position == 0) {
            selectButtonPost();
        } else if (position == 1) {
            selectButtonMap();
        } else {
            selectButtonNetwork();
        }

    }

    @Override
    public void onPageScrollStateChanged(final int state) {

    }
}
