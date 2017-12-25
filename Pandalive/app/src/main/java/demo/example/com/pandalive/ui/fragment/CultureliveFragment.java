package demo.example.com.pandalive.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;

import demo.example.com.pandalive.R;
import demo.example.com.pandalive.adapter.CultAdapter;
import demo.example.com.pandalive.base.BaseFragment;
import demo.example.com.pandalive.bean.MyFragment;
import demo.example.com.pandalive.net.NetContract;
import demo.example.com.pandalive.net.NetModel;
import demo.example.com.pandalive.net.NetPresenter;
import demo.example.com.pandalive.utils.NoScrollViewPager;

/**
 * Created by 丁军明 on 2017/12/20.
 */

public class CultureliveFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View, View.OnClickListener {
    private TextView mTitle, mContext;
    private ImageView mImg;
    private Button mXy;
    private TabLayout mTab;
    private NoScrollViewPager mNoView;
    private boolean boo = false;
    private static String ARG_PARAM1;
    private static String ARG_PARAM2;
    private ArrayList<String> TabList = new ArrayList<>();
    private ArrayList<Fragment> FraList = new ArrayList<>();
    private CultAdapter cultAdapter;
    private MyFragment myFragment;


    @Override
    public void show(String ss, String type) {
        if (ss != null) {
            Gson gson = new Gson();
            myFragment = gson.fromJson(ss, MyFragment.class);
            Glide.with(getActivity()).load(myFragment.getLive().get(0).getImage()).into(mImg);
            mTitle.setText(myFragment.getLive().get(0).getTitle());
            mContext.setText(myFragment.getLive().get(0).getBrief());
        }
        TabList.add(myFragment.getBookmark().getMultiple().get(0).getTitle());
        TabList.add(myFragment.getBookmark().getWatchTalk().get(0).getTitle());
        CultureOne cultureOne = CultureOne.newInstance("", myFragment.getBookmark().getMultiple().get(0).getUrl());
        FraList.add(cultureOne);
        FraList.add(new CultureTwo());
        cultAdapter = new CultAdapter(getFragmentManager(), TabList, FraList);
        mNoView.setAdapter(cultAdapter);
        mTab.setupWithViewPager(mNoView);
        cultAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        presenter.getDataFromModel(ARG_PARAM2, null);
        mImg = view.findViewById(R.id.Cul_img);
        mImg.setOnClickListener(this);
        mXy = view.findViewById(R.id.Xy);
        mXy.setOnClickListener(this);
        mTitle = view.findViewById(R.id.Cul_Title);
        mContext = view.findViewById(R.id.Cul_Content);
        mTab = view.findViewById(R.id.Tab);
        mNoView = view.findViewById(R.id.Cul_View);
        mNoView.setOffscreenPageLimit(1);
    }

    @Override
    public int getLayoutId() {
        return R.layout.culture_one;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ARG_PARAM1 = getArguments().getString(ARG_PARAM1);
            ARG_PARAM2 = getArguments().getString(ARG_PARAM2);
        }

    }

    public static CultureliveFragment newInstance(String param1, String param2) {
        CultureliveFragment fragment = new CultureliveFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Xy:
                if (boo) {
                    mContext.setVisibility(View.GONE);
                    mXy.setBackground(getResources().getDrawable(R.drawable.live_china_detail_down));
                    boo = false;
                } else {
                    mContext.setVisibility(View.VISIBLE);
                    mXy.setBackground(getResources().getDrawable(R.drawable.live_china_detail_up));
                    boo = true;
                }
                break;
            case R.id.Cul_img:
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getArguments() != null) {
            ARG_PARAM1 = getArguments().getString(ARG_PARAM1);
            ARG_PARAM2 = getArguments().getString(ARG_PARAM2);
        }

    }
}
