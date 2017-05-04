package adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.user.uiassignment.R;

import java.util.ArrayList;

/**
 * Created by user on 5/1/2017.
 */

public class MyRequestViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;
    private Context context;

    /**
     * @param fm  fragment manager object
     * @param ctx context object
     */
    public MyRequestViewPagerAdapter(final FragmentManager fm, final Context ctx) {
        super(fm);
        context = ctx;
        fragments = new ArrayList<Fragment>();
        titles = new ArrayList<String>();
    }

    /**
     * @param fragment fragment object
     * @param title    string object
     */
    public void addData(final Fragment fragment, final String title) {
        fragments.add(fragment);
        titles.add(title);
    }

    @Override
    public Fragment getItem(final int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    /**
     * @param position get view of this position
     * @return view for bove position
     */
    public View getView(final int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.myreq_tab_layout, null);
        TextView text = (TextView) view.findViewById(R.id.my_title);
        text.setText(titles.get(position));
        return view;
    }


}
