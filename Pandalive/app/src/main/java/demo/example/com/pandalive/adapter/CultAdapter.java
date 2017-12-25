package demo.example.com.pandalive.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import demo.example.com.pandalive.bean.MyFragment;

/**
 * Created by 丁军明 on 2017/12/22.
 */

public class CultAdapter extends FragmentPagerAdapter {
    private ArrayList<String> TabList;
    private ArrayList<Fragment> FraList;

    public CultAdapter(FragmentManager fm, ArrayList<String> tabList, ArrayList<Fragment> fraList) {
        super(fm);
        TabList = tabList;
        FraList = fraList;
    }

    @Override
    public Fragment getItem(int position) {
        return FraList.get(position);
    }

    @Override
    public int getCount() {
        return FraList.isEmpty() ? 0 : FraList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TabList.get(position);
    }
}
