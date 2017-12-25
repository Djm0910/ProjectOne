package demo.example.com.pandalive.app;

import android.app.Application;

import demo.example.com.pandalive.base.BaseActivity;
import demo.example.com.pandalive.base.BaseFragment;

/**
 * Created by 丁军明 on 2017/11/27.
 */

public class App extends Application {
    public static BaseActivity mActivity;
    public static BaseFragment mLastFragment;
}
