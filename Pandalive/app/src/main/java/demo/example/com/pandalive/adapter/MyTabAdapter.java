package demo.example.com.pandalive.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import demo.example.com.pandalive.bean.MyTab;

/**
 * Created by 丁军明 on 2017/12/20.
 */

public class MyTabAdapter extends FragmentStatePagerAdapter {
    private List<MyTab.TablistBean> mTab;
    private ArrayList<Fragment> mList;

    public MyTabAdapter(FragmentManager fm, List<MyTab.TablistBean> mTab, ArrayList<Fragment> mList) {
        super(fm);
        this.mTab = mTab;
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
        return mTab.get(position).getTitle();
    }
}
