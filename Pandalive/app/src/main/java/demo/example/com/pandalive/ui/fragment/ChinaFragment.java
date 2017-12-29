package demo.example.com.pandalive.ui.fragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import demo.example.com.pandalive.green.AlllistBeanDao;
import demo.example.com.pandalive.R;
import demo.example.com.pandalive.green.TablistBeanDao;
import demo.example.com.pandalive.adapter.ChinaTabAdapter;
import demo.example.com.pandalive.app.App;
import demo.example.com.pandalive.base.BaseFragment;
import demo.example.com.pandalive.net.NetContract;
import demo.example.com.pandalive.net.NetModel;
import demo.example.com.pandalive.net.NetPresenter;
import demo.example.com.pandalive.ui.fragment.chinaFragment.AlllistBean;
import demo.example.com.pandalive.ui.fragment.chinaFragment.BaseZg;
import demo.example.com.pandalive.ui.fragment.chinaFragment.GreenDAo;
import demo.example.com.pandalive.ui.fragment.chinaFragment.MainZgActivity;
import demo.example.com.pandalive.ui.fragment.chinaFragment.TablistBean;

/**
 * Created by 丁军明 on 2017/12/19.
 */

public class ChinaFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {

    private TabLayout zg_tab;
    private ImageView zg_imge;
    private ViewPager zg_pager;
    private AlllistBeanDao dao;
    private TablistBeanDao daos;
    private ArrayList<Fragment> tabfragment;
    private ArrayList<String> tablists;


    @Override
    public void show(String ss, String type) {
        Gson gson = new Gson();
        List<TablistBean> tablist = daos.queryBuilder().list();
        if (tablist.size() > 0 && tablist != null) {
            tabfragment = new ArrayList<>();
            tablists = new ArrayList<>();
            for (int i = 0; i < tablist.size(); i++) {
                String title = tablist.get(i).getTitle();
                tablists.add(title);
                String url = tablist.get(i).getUrl();
                DuoFragment tongYFragment = DuoFragment.newInstance(url);
                tabfragment.add(tongYFragment);
            }
            ChinaTabAdapter fragmentTabAdapter = new ChinaTabAdapter(getActivity().getSupportFragmentManager(), tablists, tabfragment);
            zg_pager.setAdapter(fragmentTabAdapter);
            zg_tab.setupWithViewPager(zg_pager);
        } else {
            switch (type) {
                case "0":
                    ArrayList<Fragment> tab = new ArrayList<>();
                    ArrayList<String> tabs = new ArrayList<>();
                    BaseZg baseZg = gson.fromJson(ss, BaseZg.class);
                    List<TablistBean> tablist1 = baseZg.getTablist();
                    for (int i = 0; i < tablist1.size(); i++) {
                        String title = tablist1.get(i).getTitle();
                        tabs.add(title);
                        String url = tablist1.get(i).getUrl();
                        DuoFragment tongYFragment = DuoFragment.newInstance(url);
                        tab.add(tongYFragment);
                    }
                    ChinaTabAdapter fragmentTabAdapter = new ChinaTabAdapter(getActivity().getSupportFragmentManager(), tabs, tab);
                    zg_pager.setAdapter(fragmentTabAdapter);
                    zg_tab.setupWithViewPager(zg_pager);
                    daos.insertInTx(tablist1);
                    BaseZg baseZgs = gson.fromJson(ss, BaseZg.class);
                    List<AlllistBean> alllist = baseZgs.getAlllist();
                    alllist.removeAll(tablist1);
                    dao.insertInTx(alllist);
                    break;
            }
        }
    }


    @Override
    protected void initData() {
        presenter.getDataFromModel("http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json", "0");
        zg_imge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), MainZgActivity.class));
            }
        });
    }

    @Override
    protected void initView(View view) {
        App.mLastFragment = this;
        App.mActivity.mHuDong.setVisibility(View.GONE);
        App.mActivity.mPanda.setVisibility(View.GONE);
        App.mActivity.title.setVisibility(View.VISIBLE);
        zg_tab = (TabLayout) view.findViewById(R.id.zg_tab);
        zg_imge = (ImageView) view.findViewById(R.id.zg_imge);
        zg_pager = (ViewPager) view.findViewById(R.id.zg_pager);
        dao = GreenDAo.getTan(getActivity()).getDao();
        daos = GreenDAo.getTan(getActivity()).getDaos();
        zg_tab.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_china;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.getDataFromModel("http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json", "0");
    }
}
