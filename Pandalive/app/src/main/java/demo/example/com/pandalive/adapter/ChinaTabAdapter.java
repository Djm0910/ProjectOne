package demo.example.com.pandalive.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by 丁军明 on 2017/12/26.
 */

public class ChinaTabAdapter extends FragmentStatePagerAdapter {
    private ArrayList<String> mTitle;
    private ArrayList<Fragment> mList;

    public ChinaTabAdapter(FragmentManager fm, ArrayList<String> mTitle, ArrayList<Fragment> mList) {
        super(fm);
        this.mTitle = mTitle;
        this.mList = mList;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.isEmpty() ? 0 : mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
