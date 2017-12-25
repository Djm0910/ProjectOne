package demo.example.com.pandalive.net;

import java.util.Map;

import demo.example.com.pandalive.base.BaseModel;
import demo.example.com.pandalive.base.BasePresenter;
import demo.example.com.pandalive.base.BaseView;


/**
 * Created by 丁军明 on 2017/11/27.
 */

public class NetContract {

    public interface View extends BaseView {
        void show(String ss,String type);
    }

    interface Model extends BaseModel {
        void getDataFromNet(String url, CallBacks callBacks);
    }

    abstract static class Presenter extends BasePresenter<Model, View> {

        @Override
        public void onStart() {

        }

        public abstract void getDataFromModel(String url,String type);
    }
}