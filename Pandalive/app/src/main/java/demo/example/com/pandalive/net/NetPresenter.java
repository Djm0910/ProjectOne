package demo.example.com.pandalive.net;

import java.util.Map;

/**
 * Created by TMVPHelper on 2017/11/27
 */
public class NetPresenter extends NetContract.Presenter {
    @Override
    public void getDataFromModel(String url, final String type) {
        baseModel.getDataFromNet(url, new CallBacks() {
            @Override
            public void succ(String result) {
                baseView.show(result,type);
            }
        });
    }

}