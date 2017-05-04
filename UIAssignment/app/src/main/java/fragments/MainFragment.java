package fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.uiassignment.MainActivity;
import com.example.user.uiassignment.R;
import com.example.user.uiassignment.ViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements ViewPager.OnPageChangeListener {

    private ViewPager vpPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;
    private Toolbar toolbar;

    /**
     * empty constructor
     */
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        vpPager = (ViewPager) view.findViewById(R.id.my_pager);
        tabLayout = (TabLayout) view.findViewById(R.id.sliding_tab);
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), getActivity());
        vpPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(vpPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(viewPagerAdapter.getTabView(i));
        }
        vpPager.addOnPageChangeListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        toolbar = ((MainActivity) getActivity()).getToolbar();
        ((TextView) toolbar.findViewById(R.id.tool_txt)).setText("Discover");

    }

    @Override
    public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(final int position) {

        switch (position) {
            case 0:
                ((TextView) toolbar.findViewById(R.id.tool_txt)).setText("Discover");
                ((ImageButton) toolbar.findViewById(R.id.button_second)).setVisibility(View.VISIBLE);
                ((ImageButton) toolbar.findViewById(R.id.button_third)).setVisibility(View.VISIBLE);
                break;
            case 1:
                ((TextView) toolbar.findViewById(R.id.tool_txt)).setText("MapRequest");
                ((ImageButton) toolbar.findViewById(R.id.button_second)).setVisibility(View.INVISIBLE);
                ((ImageButton) toolbar.findViewById(R.id.button_third)).setVisibility(View.INVISIBLE);
                break;
            case 2:
                ((TextView) toolbar.findViewById(R.id.tool_txt)).setText("MyPost");
                ((ImageButton) toolbar.findViewById(R.id.button_second)).setVisibility(View.INVISIBLE);
                ((ImageButton) toolbar.findViewById(R.id.button_third)).setVisibility(View.VISIBLE);
                break;
            case 3:
                ((TextView) toolbar.findViewById(R.id.tool_txt)).setText("New Requests");
                ((ImageButton) toolbar.findViewById(R.id.button_second)).setVisibility(View.INVISIBLE);
                ((ImageButton) toolbar.findViewById(R.id.button_third)).setVisibility(View.INVISIBLE);
                break;
            case 4:
                ((TextView) toolbar.findViewById(R.id.tool_txt)).setText("New Network");
                ((ImageButton) toolbar.findViewById(R.id.button_second)).setVisibility(View.INVISIBLE);
                ((ImageButton) toolbar.findViewById(R.id.button_third)).setVisibility(View.INVISIBLE);
                break;
            default:
                break;


        }

    }

    @Override
    public void onPageScrollStateChanged(final int state) {

    }
}
