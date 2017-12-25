package demo.example.com.pandalive.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.example.com.pandalive.app.App;
import demo.example.com.pandalive.utils.TUtils;


/**
 * Created by 丁军明 on 2017/11/27.
 */

public abstract class BaseFragment<P extends BasePresenter, M extends BaseModel> extends Fragment {
    public P presenter;
    public M model;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter = TUtils.getT(this, 0);
        model = TUtils.getT(this, 1);
        if (this instanceof BaseView) {
            presenter.setVM(model, this);
        }
        view = inflater.inflate(getLayoutId(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();

    }

    protected abstract void initData();

    protected abstract void initView(View view);

    public abstract int getLayoutId();
}

