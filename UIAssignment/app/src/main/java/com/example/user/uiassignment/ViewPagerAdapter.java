package com.example.user.uiassignment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fragments.DiscoverFragment;
import fragments.MapFragment;
import fragments.MyNetworkFragment;
import fragments.MyPostFragment;
import fragments.RequestFragment;

/**
 * Created by user on 4/28/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private int[] imageArr = {R.drawable.discover_icon, R.drawable.map, R.drawable.my_post, R.drawable.request, R.drawable.my_network};
    private String[] titles = {"Discover", "Map", "My Posts", "Requests", "MyNetwork"};
    private Context context;
    private Fragment[] fragments = {new DiscoverFragment(), new MapFragment(), new MyPostFragment(), new RequestFragment(), new MyNetworkFragment()};

    /**
     * @param fm  fragment manager object
     * @param ctx context object
     */
    public ViewPagerAdapter(final FragmentManager fm, final Context ctx) {
        super(fm);
        this.context = ctx;
    }

    @Override
    public Fragment getItem(final int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    /**
     * @param position position of tab
     * @return view for tab
     */
    public View getTabView(final int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_layout, null);
        TextView tvIconText = (TextView) view.findViewById(R.id.tv_icon_txt);
        ImageView ivIcon = (ImageView) view.findViewById(R.id.tab_icon);
        tvIconText.setText(titles[position]);

        ivIcon.setImageResource(imageArr[position]);
        return view;

    }


}
